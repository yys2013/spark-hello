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

    private Long contractInfoId;

    private long contractDtlId;

    private Integer chargeType;

    private Long itemCode;

    private Long offerId;

    private Long productOfferingId;

    private Long measureId;

    private Date revBeginCycleDate;

    private Date revEndCycleDate;

    private Date serviceStartDate;

    private Date serviceEndDate;

    private Date valueDate;

    private Long allocRev;

    private Long fiscalPeriod;

    private Long contractFiscalPeriod;

    private Integer dealSts;

    private String dealMsg;

    private Date dealDate;

    /**
     * Tenant id
     */
    private Long tenantId;

    private String remarks;

    private Long custId;

    private Long acctId;

    private Long userId;

    private String phoneNo;

    private String regionCode;

    /**
     * 县市编码
     */
    private String countryCode;

    /**
     * Purchase Price 采购价（成本价）
     */
    private Long purchasePrice;

    private String strAllocRev;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getContractInfoId() {
        return contractInfoId;
    }

    public void setContractInfoId(Long contractInfoId) {
        this.contractInfoId = contractInfoId;
    }

    public long getContractDtlId() {
        return contractDtlId;
    }

    public void setContractDtlId(long contractDtlId) {
        this.contractDtlId = contractDtlId;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public Long getItemCode() {
        return itemCode;
    }

    public void setItemCode(Long itemCode) {
        this.itemCode = itemCode;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public Long getProductOfferingId() {
        return productOfferingId;
    }

    public void setProductOfferingId(Long productOfferingId) {
        this.productOfferingId = productOfferingId;
    }

    public Long getMeasureId() {
        return measureId;
    }

    public void setMeasureId(Long measureId) {
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

    public Long getAllocRev() {
        return allocRev;
    }

    public void setAllocRev(Long allocRev) {
        this.allocRev = allocRev;
    }

    public Long getFiscalPeriod() {
        return fiscalPeriod;
    }

    public void setFiscalPeriod(Long fiscalPeriod) {
        this.fiscalPeriod = fiscalPeriod;
    }

    public Long getContractFiscalPeriod() {
        return contractFiscalPeriod;
    }

    public void setContractFiscalPeriod(Long contractFiscalPeriod) {
        this.contractFiscalPeriod = contractFiscalPeriod;
    }

    public Integer getDealSts() {
        return dealSts;
    }

    public void setDealSts(Integer dealSts) {
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

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public Long getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Long purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getStrAllocRev() {
        return strAllocRev;
    }

    public void setStrAllocRev(String strAllocRev) {
        this.strAllocRev = strAllocRev;
    }

}