package com.fdc.contract.model;

import java.io.Serializable;
import java.util.Date;

// @XmlType(propOrder={"id","contractInfoId","contractDtlId","chargeType","itemCode","offerId","productOfferingId","measureId","revBeginCycleDate","revEndCycleDate","serviceStartDate","serviceEndDate","valueDate","allocRev","fiscalPeriod","contractFiscalPeriod","dealSts","dealMsg","dealDate","tenantId","remarks","custId","acctId","userId","phoneNo","regionCode","strAllocRev","countryCode","purchasePrice"})
public class FjContractAlloc implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private long id;

    private long contractInfoId;

    private long contractDtlId;

    private int chargeType;

    private long itemCode;

    private long offerId;

    private long productOfferingId;

    private long measureId;

    private Date revBeginCycleDate;

    private Date revEndCycleDate;

    private Date serviceStartDate;

    private Date serviceEndDate;

    private Date valueDate;

    private long allocRev;

    private long fiscalPeriod;

    private long contractFiscalPeriod;

    private int dealSts;

    private String dealMsg;

    private Date dealDate;

    /**
     * Tenant id
     */
    private long tenantId;

    private String remarks;

    private long custId;

    private long acctId;

    private long userId;

    private String phoneNo;

    private String regionCode;

    /**
     * 县市编码
     */
    private String countryCode;

    /**
     * Purchase Price 采购价（成本价）
     */
    private long purchasePrice;

    private String strAllocRev;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getContractInfoId() {
        return contractInfoId;
    }

    public void setContractInfoId(long contractInfoId) {
        this.contractInfoId = contractInfoId;
    }

    public long getContractDtlId() {
        return contractDtlId;
    }

    public void setContractDtlId(long contractDtlId) {
        this.contractDtlId = contractDtlId;
    }

    public int getChargeType() {
        return chargeType;
    }

    public void setChargeType(int chargeType) {
        this.chargeType = chargeType;
    }

    public long getItemCode() {
        return itemCode;
    }

    public void setItemCode(long itemCode) {
        this.itemCode = itemCode;
    }

    public long getOfferId() {
        return offerId;
    }

    public void setOfferId(long offerId) {
        this.offerId = offerId;
    }

    public long getProductOfferingId() {
        return productOfferingId;
    }

    public void setProductOfferingId(long productOfferingId) {
        this.productOfferingId = productOfferingId;
    }

    public long getMeasureId() {
        return measureId;
    }

    public void setMeasureId(long measureId) {
        this.measureId = measureId;
    }

    public Date getRevBeginCycleDate() {
        return revBeginCycleDate;
    }

    public void setRevBeginCycleDate(Date revBeginCycleDate) {
        this.revBeginCycleDate = revBeginCycleDate;
    }

    public Date getRevEndCycleDate() {
        return revEndCycleDate;
    }

    public void setRevEndCycleDate(Date revEndCycleDate) {
        this.revEndCycleDate = revEndCycleDate;
    }

    public Date getServiceStartDate() {
        return serviceStartDate;
    }

    public void setServiceStartDate(Date serviceStartDate) {
        this.serviceStartDate = serviceStartDate;
    }

    public Date getServiceEndDate() {
        return serviceEndDate;
    }

    public void setServiceEndDate(Date serviceEndDate) {
        this.serviceEndDate = serviceEndDate;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public long getAllocRev() {
        return allocRev;
    }

    public void setAllocRev(long allocRev) {
        this.allocRev = allocRev;
    }

    public long getFiscalPeriod() {
        return fiscalPeriod;
    }

    public void setFiscalPeriod(long fiscalPeriod) {
        this.fiscalPeriod = fiscalPeriod;
    }

    public long getContractFiscalPeriod() {
        return contractFiscalPeriod;
    }

    public void setContractFiscalPeriod(long contractFiscalPeriod) {
        this.contractFiscalPeriod = contractFiscalPeriod;
    }

    public int getDealSts() {
        return dealSts;
    }

    public void setDealSts(int dealSts) {
        this.dealSts = dealSts;
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

    public long getTenantId() {
        return tenantId;
    }

    public void setTenantId(long tenantId) {
        this.tenantId = tenantId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    public long getAcctId() {
        return acctId;
    }

    public void setAcctId(long acctId) {
        this.acctId = acctId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public long getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(long purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getStrAllocRev() {
        return strAllocRev;
    }

    public void setStrAllocRev(String strAllocRev) {
        this.strAllocRev = strAllocRev;
    }

}