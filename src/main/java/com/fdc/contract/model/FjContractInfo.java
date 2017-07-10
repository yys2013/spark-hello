package com.fdc.contract.model;

import java.io.Serializable;
import java.util.Date;

//@XmlType(propOrder={"id","oriContractInfoId","contractType","rtlOrderNo","extContractNo","contractLevel","groupId","custId","acctId","userId","phoneNo","valueDate","allocSts","closeDate","dealSts","isUpgrade","dealMsg","dealDate","createDate","createOpId","createOrgId","tenantId","fiscalPeriod","remarks","parentId","totalContractPrice","rptTotalAllocPrice","rptVariance","notAllocated","regionCode","billedSts","sumSts","isDeferedContract","countryCode"})
public class FjContractInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * primary key
     */
    private long id;

    private Long oriContractInfoId;

    /**
     * 协议期类型,目前主要有以下几种： 1--new phone commitment:限定在该协议期内不允许再次办理优惠购机业务
     * 2--subscription commitment:签订的基本套餐协议期 3--service commitment:增值策划的协议期
     */
    private Long contractType;

    /**
     * 客户购买手机的订单编号
     */
    private String rtlOrderNo;

    private String extContractNo;

    /**
     * 1001 user level 2001 acct level 3001 cust level 4001 group level 5001 order
     * level default
     */
    private Integer contractLevel;

    private Long groupId;

    private Long custId;

    private Long acctId;

    /**
     * 用户编号
     */
    private Long userId;

    private String phoneNo;

    private Date valueDate;

    /**
     * 0 open 1 closed
     */
    private Integer allocSts;

    private Date closeDate;

    private Integer dealSts;

    private Integer isUpgrade;

    private String dealMsg;

    /**
     * 当前业务受理日期
     */
    private Date dealDate;

    private Date createDate;

    private Long createOpId;

    private Long createOrgId;

    /**
     * Tenant id
     */
    private Long tenantId;

    /**
     * Fiscal period
     */
    private Long fiscalPeriod;

    private String remarks;

    private Long parentId;

    private Long totalContractPrice;

    /**
     * 报表数据沉淀字段：该合同截止到当前会计期已分配的revenue
     */
    private Long rptTotalAllocPrice;

    /**
     * rpt_total_alloc_price和total_contract_price的差值
     */
    private Long rptVariance;

    private Long notAllocated;

    private String regionCode;

    private int billedSts;

    private int sumSts;

    private int isDeferedContract;

    /**
     * 县市编码
     */
    private String countryCode;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getOriContractInfoId() {
        return oriContractInfoId;
    }

    public void setOriContractInfoId(Long oriContractInfoId) {
        this.oriContractInfoId = oriContractInfoId;
    }

    public Long getContractType() {
        return contractType;
    }

    public void setContractType(Long contractType) {
        this.contractType = contractType;
    }

    public String getRtlOrderNo() {
        return rtlOrderNo;
    }

    public void setRtlOrderNo(String rtlOrderNo) {
        this.rtlOrderNo = rtlOrderNo;
    }

    public String getExtContractNo() {
        return extContractNo;
    }

    public void setExtContractNo(String extContractNo) {
        this.extContractNo = extContractNo;
    }

    public Integer getContractLevel() {
        return contractLevel;
    }

    public void setContractLevel(Integer contractLevel) {
        this.contractLevel = contractLevel;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public Long getAcctId() {
        return acctId;
    }

    public void setAcctId(Long acctId) {
        this.acctId = acctId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public Integer getAllocSts() {
        return allocSts;
    }

    public void setAllocSts(Integer allocSts) {
        this.allocSts = allocSts;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Integer getDealSts() {
        return dealSts;
    }

    public void setDealSts(Integer dealSts) {
        this.dealSts = dealSts;
    }

    public Integer getIsUpgrade() {
        return isUpgrade;
    }

    public void setIsUpgrade(Integer isUpgrade) {
        this.isUpgrade = isUpgrade;
    }

    public String getDealMsg() {
        return dealMsg;
    }

    public void setDealMsg(String dealMsg) {
        this.dealMsg = dealMsg;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreateOpId() {
        return createOpId;
    }

    public void setCreateOpId(Long createOpId) {
        this.createOpId = createOpId;
    }

    public Long getCreateOrgId() {
        return createOrgId;
    }

    public void setCreateOrgId(Long createOrgId) {
        this.createOrgId = createOrgId;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public Long getFiscalPeriod() {
        return fiscalPeriod;
    }

    public void setFiscalPeriod(Long fiscalPeriod) {
        this.fiscalPeriod = fiscalPeriod;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getTotalContractPrice() {
        return totalContractPrice;
    }

    public void setTotalContractPrice(Long totalContractPrice) {
        this.totalContractPrice = totalContractPrice;
    }

    public Long getRptTotalAllocPrice() {
        return rptTotalAllocPrice;
    }

    public void setRptTotalAllocPrice(Long rptTotalAllocPrice) {
        this.rptTotalAllocPrice = rptTotalAllocPrice;
    }

    public Long getRptVariance() {
        return rptVariance;
    }

    public void setRptVariance(Long rptVariance) {
        this.rptVariance = rptVariance;
    }

    public Long getNotAllocated() {
        return notAllocated;
    }

    public void setNotAllocated(Long notAllocated) {
        this.notAllocated = notAllocated;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public int getBilledSts() {
        return billedSts;
    }

    public void setBilledSts(int billedSts) {
        this.billedSts = billedSts;
    }

    public int getSumSts() {
        return sumSts;
    }

    public void setSumSts(int sumSts) {
        this.sumSts = sumSts;
    }

    public int getIsDeferedContract() {
        return isDeferedContract;
    }

    public void setIsDeferedContract(int isDeferedContract) {
        this.isDeferedContract = isDeferedContract;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}