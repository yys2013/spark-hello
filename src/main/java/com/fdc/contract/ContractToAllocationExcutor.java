package com.fdc.contract;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.spark.api.java.function.ForeachPartitionFunction;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoder;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.fdc.contract.model.FjContractDtl;
import com.fdc.contract.model.FjContractInfo;
import com.fdc.util.DBUtils;

public class ContractToAllocationExcutor {

    public static void main(String[] args) {
        
        SparkSession sparkSession = 
                SparkSession.builder()
                .appName("ContractToAllocation")
                .master("local")
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
                    Connection conn = DBUtils.getConnect();
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

    private static FjContractInfo dealContractToAllocation(Row value) {
        
        BigDecimal id = value.getAs("ID");
        BigDecimal fiscalPeriod = value.getAs("FISCAL_PERIOD");
        String regionCode = value.getAs("REGION_CODE");
        
        FjContractInfo fjContractInfo = new FjContractInfo();
        fjContractInfo.setId(id.intValue());
        fjContractInfo.setFiscalPeriod(fiscalPeriod.longValue());
        fjContractInfo.setRegionCode(regionCode);
        
        String sql = "SELECT * FROM FJ.FJ_CONTRACT_DTL_577_201612 WHERE CONTRACT_INFO_ID=? AND REGION_CODE=? AND FISCAL_PERIOD=?";
        Connection conn = DBUtils.getConnect();
        QueryRunner run = new QueryRunner();
        try {
            List<FjContractDtl> list = run.query(conn, sql,
                    new BeanListHandler<FjContractDtl>(FjContractDtl.class),
                    id, regionCode, fiscalPeriod);
            System.out.println("FjContractDtl list : " + list);
            fjContractInfo.setAllocSts(1);
            fjContractInfo.setDealMsg("Spark Deal Success！");
        } catch (SQLException e) {
            fjContractInfo.setAllocSts(2);
            fjContractInfo.setDealMsg(e.getMessage());
            e.printStackTrace();
        }
        return fjContractInfo;
    }
    
}
