package com.fdc.contract;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.spark.api.java.function.ForeachPartitionFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.fdc.contract.model.FjContractAlloc;
import com.fdc.contract.model.FjContractDtl;
import com.fdc.contract.model.FjContractInfo;
import com.fdc.util.Constants;
import com.fdc.util.DateUtil;
import com.fdc.util.JdbcUtils;
import com.fdc.util.MyBasicRowProcessor;

public class ContractToAllocationExcutor {

    public static void main(String[] args) {
        
//        SparkSession sparkSession = 
//                SparkSession.builder()
//                .appName("ContractToAllocation")
//                .master("local")
//                .getOrCreate();
        
        //System.setProperty("user.timezone", "GMT");
        
        
        SparkSession sparkSession = 
                SparkSession.builder()
                .appName("ContractToAllocation")
                //.master("spark://server01:7077")
                .getOrCreate();
        
        
        String url = "jdbc:oracle:thin:@10.1.241.76:1522:fjsdev";
        Dataset<Row> fjContractInfoDataSet = sparkSession.read().format("jdbc")
                .option("url", url)
                .option("driver", "oracle.jdbc.driver.OracleDriver")
                .option("dbtable", "FJ.FJ_CONTRACT_INFO_577_201612")
                .option("user", "fj")
                .option("password", "fj")
                .option("fetchSize", "20")
                .load();
        
        Encoder<FjContractInfo> infoEncoder = Encoders.bean(FjContractInfo.class);
        
        Dataset<FjContractInfo> mapSet = fjContractInfoDataSet.map(new MapFunction<Row, FjContractInfo>() {
            @Override
            public FjContractInfo call(Row value) throws Exception {
                return dealContractToAllocation(value);
            }
        }, infoEncoder);
        
        
        mapSet.foreachPartition(new ForeachPartitionFunction<FjContractInfo>() {
            @Override
            public void call(Iterator<FjContractInfo> t) throws Exception {
                
                while (t.hasNext()) {
                    FjContractInfo fjContractInfo = t.next();
                    //Connection conn = DBUtils.getConnect();
                    Connection conn = JdbcUtils.getDataSource().getConnection();
                    QueryRunner run = new QueryRunner();
                    String updateSql = "UPDATE FJ_CONTRACT_INFO_577_201612 SET ALLOC_STS=?, DEAL_MSG=? WHERE ID=?";
                    run.update(conn, updateSql, fjContractInfo.getAllocSts(), fjContractInfo.getDealMsg(),
                            fjContractInfo.getId());
                    //conn.commit();
                }
            }
        });
        
        sparkSession.stop();
    }

    private static FjContractInfo dealContractToAllocation(Row value) throws Exception {
        
        BigDecimal id = value.getAs("ID");
        BigDecimal fiscalPeriod = value.getAs("FISCAL_PERIOD");
        String regionCode = value.getAs("REGION_CODE");
        Date valueDate = value.getAs("VALUE_DATE");
        
        FjContractInfo fjContractInfo = new FjContractInfo();
        fjContractInfo.setId(id.intValue());
        fjContractInfo.setFiscalPeriod(fiscalPeriod.longValue());
        fjContractInfo.setRegionCode(regionCode);
        fjContractInfo.setValueDate(valueDate);
        
        String sql = "SELECT * FROM FJ.FJ_CONTRACT_DTL_577_201612 WHERE CONTRACT_INFO_ID=? AND REGION_CODE=? AND FISCAL_PERIOD=?";
        //Connection conn = DBUtils.getConnect();
        Connection conn = JdbcUtils.getDataSource().getConnection();
        QueryRunner run = new QueryRunner();
        try {
            List<FjContractDtl> fjContractDtlList = run.query(conn, sql,
                    new BeanListHandler<FjContractDtl>(FjContractDtl.class, new MyBasicRowProcessor()),
                    id, regionCode, fiscalPeriod);
            
            //无明细不处理
            if (fjContractDtlList == null || fjContractDtlList.size() == 0) {
                fjContractInfo.setDealSts(1);
                fjContractInfo.setDealDate(new Date());
                return fjContractInfo;
            }
            
            splitContratctDtl(fjContractInfo, fjContractDtlList);
            
            System.out.println("FjContractDtl list : " + fjContractDtlList);
            fjContractInfo.setAllocSts(Constants.DealSts.SUCCESS);
            fjContractInfo.setDealDate(new Date());
            fjContractInfo.setDealMsg("Spark Deal Success！");
        } catch (SQLException e) {
            fjContractInfo.setAllocSts(Constants.DealSts.FAIL);
            fjContractInfo.setDealMsg(e.getMessage());
            e.printStackTrace();
        }
        return fjContractInfo;
    }
    
    
    private static void splitContratctDtl(FjContractInfo fjContractInfo, List<FjContractDtl> fjContractDtlList) {
        
        try {
            // save data
            List<FjContractAlloc> fjContractAllocList = new ArrayList<FjContractAlloc>();
            
            for (FjContractDtl fjContractDtl : fjContractDtlList) {
                FjContractAlloc baseFjContractAlloc = getNewFjContractAlloc(fjContractDtl);
                baseFjContractAlloc.setContractFiscalPeriod(fjContractInfo.getFiscalPeriod());
                //服务开始日期
                Date serviceStartDate = fjContractDtl.getServiceStartDate();
                
                
                if(fjContractDtl.getChargeType().intValue() == Constants.CmcChargeType.TERMINAL.intValue()) {
                    // 终端
                    FjContractAlloc newFjContractAlloc = new FjContractAlloc();
                    
                    BeanUtils.copyProperties(newFjContractAlloc, baseFjContractAlloc);
                    
    
                    newFjContractAlloc.setId(getSequence(newFjContractAlloc.getServiceStartDate(), newFjContractAlloc.getContractDtlId()));
    
                    newFjContractAlloc.setAllocRev(fjContractDtl.getAllocPrice());
                    newFjContractAlloc.setRevBeginCycleDate(serviceStartDate);
                    newFjContractAlloc.setRevEndCycleDate(fjContractDtl.getServiceEndDate());
                    newFjContractAlloc.setPurchasePrice(fjContractDtl.getPurchasePrice());
                    
                    if (DateUtil.MonthSubtract(serviceStartDate, fjContractInfo.getValueDate()) > 0) {
                        newFjContractAlloc.setFiscalPeriod(fjContractInfo.getFiscalPeriod());
                        newFjContractAlloc.setValueDate(DateUtil.getMonthEnd(fjContractInfo.getValueDate()));
                    } else {
                        newFjContractAlloc.setFiscalPeriod(Long.parseLong(DateUtil.formatDate(fjContractDtl.getServiceStartDate(), DateUtil.YEAR_MONTH_FORMAT2)));
                        newFjContractAlloc.setValueDate(DateUtil.getMonthEnd(fjContractDtl.getServiceStartDate()));
                    }
                    
                    fjContractAllocList.add(newFjContractAlloc);
    
                //保底
                }else if(fjContractDtl.getChargeType().intValue() == Constants.CmcChargeType.GUARANTEED_FEE.intValue()) {
                    
                    Date serviceEndDate = fjContractDtl.getServiceEndDate();
                    
                    //BIZBILLING_REQ_175444 延迟的保底需要填默认值
                    Date startDate = serviceStartDate;
                    Date contractValueDate = fjContractInfo.getValueDate();
                    if(DateUtil.MonthSubtract(contractValueDate, serviceStartDate) > 0) {
                        startDate = contractValueDate;
                    }
                    
                    //20160101   20160401  ---  201601 201602 201603
                    long months = DateUtil.MonthSubtract(startDate, serviceEndDate);
                    //处理最后一期不是整月的情况MonthSubtract计算的结果分摊期需要加一期
                    if(DateUtil.getMonthBegin(serviceEndDate).compareTo(serviceEndDate) != 0) {
                        months += 1;
                    }
                    long splitTotalAmount = 0L;
                    for(int i=0; i<months; i++) {
                        
                        FjContractAlloc newFjContractAlloc = new FjContractAlloc();
                        BeanUtils.copyProperties(newFjContractAlloc, baseFjContractAlloc);
                        
                        newFjContractAlloc.setId(getSequence(startDate, fjContractDtl.getId()));
                        
                        Date thisMonthEnd = DateUtil.getMonthEnd(startDate);
                        // 存量数据放到当月
                        if (DateUtil.MonthSubtract(startDate, fjContractInfo.getValueDate()) > 0) {
                            newFjContractAlloc.setFiscalPeriod(fjContractInfo.getFiscalPeriod());
                            newFjContractAlloc.setValueDate(DateUtil.getMonthEnd(fjContractInfo.getValueDate()));
                        } else {
                            newFjContractAlloc.setFiscalPeriod(Long.parseLong(DateUtil.formatDate(startDate, DateUtil.YEAR_MONTH_FORMAT2)));
                            newFjContractAlloc.setValueDate(thisMonthEnd);
                        }
                        
                        newFjContractAlloc.setRevBeginCycleDate(startDate);
                        newFjContractAlloc.setRevEndCycleDate(thisMonthEnd);
                        
                        if(DateUtil.MonthSubtract(serviceStartDate, startDate) < 0) {
                            newFjContractAlloc.setAllocRev((long) 0); //虚拟设置金额，方便差异调整报表sum流程计算
                        }else {
                            //实际的第一期
                            if(DateUtil.MonthSubtract(startDate, serviceStartDate) == 0) {
                                splitTotalAmount += fjContractDtl.getAllocFAmount();
                                newFjContractAlloc.setAllocRev(fjContractDtl.getAllocFAmount());
                            //最后一期
                            }else if(i == (months-1)) {
                                newFjContractAlloc.setRevEndCycleDate(fjContractDtl.getServiceEndDate());
                                newFjContractAlloc.setAllocRev(fjContractDtl.getAllocAmount() - splitTotalAmount);
                            }else {
                                splitTotalAmount += fjContractDtl.getAllocPrice();
                                newFjContractAlloc.setAllocRev(fjContractDtl.getAllocPrice()); //平均每月价格
                            }
                        }
                        startDate = DateUtil.addMonths(DateUtil.getMonthBegin(startDate), 1);
                        fjContractAllocList.add(newFjContractAlloc);
                    }
                }
            }
            Map<String, List<FjContractAlloc>> allocMap = new HashMap<String, List<FjContractAlloc>>();
            for(FjContractAlloc fjContractAlloc : fjContractAllocList) {
                Long mod  = fjContractAlloc.getContractInfoId() % 10;
                String strYear = (fjContractAlloc.getFiscalPeriod() + "").substring(0,4);
                String key = mod + "_" + strYear;
                List<FjContractAlloc> list = allocMap.get(key);
                if(list == null) {
                    list = new ArrayList<FjContractAlloc>();
                    allocMap.put(key, list);
                }
                list.add(fjContractAlloc);
            }
            
            //新增15拆分数据
            if(allocMap.size() > 0) {
                for(Entry<String, List<FjContractAlloc>> entry : allocMap.entrySet()) {
                    List<FjContractAlloc> allocList = entry.getValue();
                    processDbBatchInsertAlloc(entry.getKey(), allocList);
                }
            }
        
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private static void processDbBatchInsertAlloc(String pKey, List<FjContractAlloc> allocList) throws Exception {
        
        //Connection conn = DBUtils.getConnect();
        //QueryRunner run = new QueryRunner();
        
        Connection conn = JdbcUtils.getDataSource().getConnection();
        
        
        String tableName = "FJ.FJ_CONTRACT_ALLOC_" + pKey;
        String insertSql = "INSERT INTO " +  tableName
                + "(ID, "
                + "CONTRACT_INFO_ID, "
                + "CONTRACT_DTL_ID, "
                + "CHARGE_TYPE, "
                + "ITEM_CODE, "
                + "OFFER_ID, "
                + "PRODUCT_OFFERING_ID, "
                + "SERVICE_START_DATE, "
                + "SERVICE_END_DATE, "
                + "ALLOC_REV, "
                + "FISCAL_PERIOD, "
                + "CONTRACT_FISCAL_PERIOD, "
                + "DEAL_STS, "
                + "DEAL_DATE, "
                + "TENANT_ID, "
                + "REMARKS, "
                + "CUST_ID, "
                + "ACCT_ID, "
                + "USER_ID, "
                + "PHONE_NO, "
                + "MEASURE_ID, "
                + "REV_BEGIN_CYCLE_DATE, "
                + "REV_END_CYCLE_DATE, "
                + "DEAL_MSG, "
                + "VALUE_DATE, "
                + "REGION_CODE, "
                + "COUNTRY_CODE, "
                + "PURCHASE_PRICE) VALUES "
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement pst = conn.prepareStatement(insertSql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        for(int i = 0; i < allocList.size(); i++){
            FjContractAlloc alloc = allocList.get(i);
            pst.setLong(1, alloc.getId());
            pst.setLong(2, alloc.getContractInfoId());
            pst.setLong(3, alloc.getContractDtlId());
            pst.setInt(4, alloc.getChargeType());
            pst.setLong(5, alloc.getItemCode());
            pst.setLong(6, alloc.getOfferId());
            pst.setLong(7, alloc.getProductOfferingId());
            pst.setDate(8, new java.sql.Date(alloc.getServiceStartDate().getTime()));
            pst.setDate(9, new java.sql.Date(alloc.getServiceEndDate().getTime()));
            pst.setLong(10, alloc.getAllocRev());
            pst.setLong(11, alloc.getFiscalPeriod());
            pst.setLong(12, alloc.getContractFiscalPeriod());
            pst.setInt(13, alloc.getDealSts());
            pst.setDate(14, new java.sql.Date(alloc.getDealDate().getTime()));
            pst.setLong(15, alloc.getTenantId());
            pst.setString(16, alloc.getRemarks());
            pst.setLong(17, alloc.getCustId());
            pst.setLong(18, alloc.getAcctId());
            pst.setLong(19, alloc.getUserId());
            pst.setString(20, alloc.getPhoneNo());
            pst.setLong(21, alloc.getMeasureId());
            pst.setDate(22, new java.sql.Date(alloc.getRevBeginCycleDate().getTime()));
            pst.setDate(23, new java.sql.Date(alloc.getRevEndCycleDate().getTime()));
            pst.setString(24, alloc.getDealMsg());
            pst.setDate(25, new java.sql.Date(alloc.getValueDate().getTime()));
            pst.setString(26, alloc.getRegionCode());
            pst.setString(27, alloc.getCountryCode());
            pst.setLong(28, alloc.getPurchasePrice());
            
            pst.addBatch();
        }
        
        pst.executeBatch();
        conn.commit();
        conn.close();
        
//        Field[] declaredFields = FjContractAlloc.class.getDeclaredFields();
//        Object[][] params=new Object[allocList.size()][declaredFields.length];
//        for (int i = 0; i < params.length; i++) {
//            FjContractAlloc alloc = allocList.get(i);
//            params[i]=new Object[]{
//                    alloc.getId(),
//                    alloc.getContractInfoId(),
//                    alloc.getContractDtlId(),
//                    alloc.getChargeType(),
//                    alloc.getItemCode(),
//                    alloc.getOfferId(),
//                    alloc.getProductOfferingId(),
//                    null,//alloc.getServiceStartDate(),
//                    null,//alloc.getServiceEndDate(),
//                    alloc.getAllocRev(),
//                    alloc.getFiscalPeriod(),
//                    alloc.getContractFiscalPeriod(),
//                    alloc.getDealSts(),
//                    alloc.getDealDate(),
//                    alloc.getTenantId(),
//                    alloc.getRemarks(),
//                    alloc.getCustId(),
//                    alloc.getAcctId(),
//                    alloc.getUserId(),
//                    alloc.getPhoneNo(),
//                    alloc.getMeasureId(),
//                    null,//alloc.getRevBeginCycleDate(),
//                    null,//alloc.getRevEndCycleDate(),
//                    alloc.getDealMsg(),
//                    null,//alloc.getValueDate(),
//                    alloc.getRegionCode(),
//                    alloc.getCountryCode(),
//                    alloc.getPurchasePrice()};
//        }
//        //run.batch(conn, insertSql, params);
//        run.insertBatch(conn, insertSql, null, params);
    }

    public static FjContractAlloc getNewFjContractAlloc(FjContractDtl fjContractDtl) {
        FjContractAlloc fjContractAlloc = new FjContractAlloc();
        fjContractAlloc.setContractInfoId(fjContractDtl.getContractInfoId());
        fjContractAlloc.setContractDtlId(fjContractDtl.getId());
        fjContractAlloc.setChargeType(fjContractDtl.getChargeType());
        //fjContractAlloc.setContractFiscalPeriod(fjContractDtl.getFiscalPeriod());
        fjContractAlloc.setDealSts(0);
        fjContractAlloc.setDealDate(new Date());
        fjContractAlloc.setItemCode(fjContractDtl.getItemCode());
        fjContractAlloc.setOfferId(fjContractDtl.getOfferId());
        fjContractAlloc.setProductOfferingId(fjContractDtl.getProductOfferingId());
        fjContractAlloc.setTenantId(fjContractDtl.getTenantId());
        fjContractAlloc.setServiceEndDate(fjContractDtl.getServiceEndDate());
        fjContractAlloc.setServiceStartDate(fjContractDtl.getServiceStartDate());
        fjContractAlloc.setCustId(fjContractDtl.getCustId());
        fjContractAlloc.setAcctId(fjContractDtl.getAcctId());
        fjContractAlloc.setUserId(fjContractDtl.getUserId());
        fjContractAlloc.setPhoneNo(fjContractDtl.getPhoneNo());
        fjContractAlloc.setMeasureId(fjContractDtl.getMeasureId());
        fjContractAlloc.setRegionCode(fjContractDtl.getRegionCode());
        fjContractAlloc.setCountryCode(fjContractDtl.getCountryCode());
        return fjContractAlloc;
    }
    
    /**
     * 获取序列
     * @param type
     * @param serviceStartDate
     * @param id
     * @return
     */
    public static long getSequence(Date serviceStartDate, long id) {
        long llSeq = Long.parseLong(DateUtil.formatDate(new Date(), DateUtil.YEAR_MONTH_FORMAT4) +
                    DateUtil.formatDate(serviceStartDate, DateUtil.YEAR_MONTH_FORMAT4)+ id);
        return llSeq;
    }
}
