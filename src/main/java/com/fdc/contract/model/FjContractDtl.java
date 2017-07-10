package com.fdc.contract.model;

import java.io.Serializable;
import java.util.Date;

//@XmlType(propOrder={"id","contractInfoId","oriContractInfoId","cycleFreq","chargeType","paymentcardCycle","itemCode","offerId","measureId","productOfferingId","contractPrice","saPrice","allocPrice","activationDate","allocationRate","commStartDate","commEndDate","serviceStartDate","serviceEndDate","dealSts","contractItemType","dealMsg","valueDate","dealDate","createDate","createOpId","createOrgId","tenantId","fiscalPeriod","remarks","custId","acctId","userId","phoneNo","period1","period2","period3","period4","period5","period6","period7","invoiceAmount","regionCode","billedSts","notSplitAmount","contractFAmount","contractAmount","allocAmount","allocFAmount","countryCode","purchasePrice","brandId"})
public class FjContractDtl implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private long id;

    private long contractInfoId;

    private Long oriContractInfoId;

    private Integer cycleFreq;

    /**
     * device of handset
     */
    private Integer chargeType;

    private Integer paymentcardCycle;

    private Long itemCode;

    /**
     * external system contract ID
     */
    private Long offerId;

    private Long measureId;

    private Long productOfferingId;

    /**
     * 对于承诺期的产品，由于只是承诺要消费，实际账单还没有出，也可能preinvouce出过了。出过了就等于billed price
     */
    private Long contractPrice;

    /**
     * Stand alone price
     */
    private Long saPrice;

    /**
     * to be allocated amount
     */
    private Long allocPrice;

    private Date activationDate;

    private Long allocationRate;

    private Date commStartDate;

    private Date commEndDate;

    private Date serviceStartDate;

    private Date serviceEndDate;

    private Integer dealSts;

    private Integer contractItemType;

    private String dealMsg;

    /**
     * fjs value date
     */
    private Date valueDate;

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

    private Long custId;

    private Long acctId;

    private Long userId;

    private String phoneNo;

    private String regionCode;

    private int billedSts;

    private Long notSplitAmount;

    /**
     * 首月，合同内的价格
     */
    private Long contractFAmount;

    /**
     * 合同内总价格
     */
    private Long contractAmount;

    /**
     * 分配总价格
     */
    private Long allocAmount;

    /**
     * 首月分配的价格
     */
    private Long allocFAmount;

    /**
     * 县市编码
     */
    private String countryCode;

    /**
     * Purchase Price 采购价（成本价）
     */
    private Long purchasePrice;

    private Long brandId;

    private String period1;

    private String period2;

    private String period3;

    private String period4;

    private String period5;

    private String period6;

    private String period7;

    private Long invoiceAmount;

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

    public Long getOriContractInfoId() {
        return oriContractInfoId;
    }

    public void setOriContractInfoId(Long oriContractInfoId) {
        this.oriContractInfoId = oriContractInfoId;
    }

    public Integer getCycleFreq() {
        return cycleFreq;
    }

    public void setCycleFreq(Integer cycleFreq) {
        this.cycleFreq = cycleFreq;
    }

    public Integer getChargeType() {
        return chargeType;
    }

    public void setChargeType(Integer chargeType) {
        this.chargeType = chargeType;
    }

    public Integer getPaymentcardCycle() {
        return paymentcardCycle;
    }

    public void setPaymentcardCycle(Integer paymentcardCycle) {
        this.paymentcardCycle = paymentcardCycle;
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

    public Long getMeasureId() {
        return measureId;
    }

    public void setMeasureId(Long measureId) {
        this.measureId = measureId;
    }

    public Long getProductOfferingId() {
        return productOfferingId;
    }

    public void setProductOfferingId(Long productOfferingId) {
        this.productOfferingId = productOfferingId;
    }

    public Long getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(Long contractPrice) {
        this.contractPrice = contractPrice;
    }

    public Long getSaPrice() {
        return saPrice;
    }

    public void setSaPrice(Long saPrice) {
        this.saPrice = saPrice;
    }

    public Long getAllocPrice() {
        return allocPrice;
    }

    public void setAllocPrice(Long allocPrice) {
        this.allocPrice = allocPrice;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Long getAllocationRate() {
        return allocationRate;
    }

    public void setAllocationRate(Long allocationRate) {
        this.allocationRate = allocationRate;
    }

    public Date getCommStartDate() {
        return commStartDate;
    }

    public void setCommStartDate(Date commStartDate) {
        this.commStartDate = commStartDate;
    }

    public Date getCommEndDate() {
        return commEndDate;
    }

    public void setCommEndDate(Date commEndDate) {
        this.commEndDate = commEndDate;
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

    public Integer getDealSts() {
        return dealSts;
    }

    public void setDealSts(Integer dealSts) {
        this.dealSts = dealSts;
    }

    public Integer getContractItemType() {
        return contractItemType;
    }

    public void setContractItemType(Integer contractItemType) {
        this.contractItemType = contractItemType;
    }

    public String getDealMsg() {
        return dealMsg;
    }

    public void setDealMsg(String dealMsg) {
        this.dealMsg = dealMsg;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
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

    public int getBilledSts() {
        return billedSts;
    }

    public void setBilledSts(int billedSts) {
        this.billedSts = billedSts;
    }

    public Long getNotSplitAmount() {
        return notSplitAmount;
    }

    public void setNotSplitAmount(Long notSplitAmount) {
        this.notSplitAmount = notSplitAmount;
    }

    public Long getContractFAmount() {
        return contractFAmount;
    }

    public void setContractFAmount(Long contractFAmount) {
        this.contractFAmount = contractFAmount;
    }

    public Long getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(Long contractAmount) {
        this.contractAmount = contractAmount;
    }

    public Long getAllocAmount() {
        return allocAmount;
    }

    public void setAllocAmount(Long allocAmount) {
        this.allocAmount = allocAmount;
    }

    public Long getAllocFAmount() {
        return allocFAmount;
    }

    public void setAllocFAmount(Long allocFAmount) {
        this.allocFAmount = allocFAmount;
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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getPeriod1() {
        return period1;
    }

    public void setPeriod1(String period1) {
        this.period1 = period1;
    }

    public String getPeriod2() {
        return period2;
    }

    public void setPeriod2(String period2) {
        this.period2 = period2;
    }

    public String getPeriod3() {
        return period3;
    }

    public void setPeriod3(String period3) {
        this.period3 = period3;
    }

    public String getPeriod4() {
        return period4;
    }

    public void setPeriod4(String period4) {
        this.period4 = period4;
    }

    public String getPeriod5() {
        return period5;
    }

    public void setPeriod5(String period5) {
        this.period5 = period5;
    }

    public String getPeriod6() {
        return period6;
    }

    public void setPeriod6(String period6) {
        this.period6 = period6;
    }

    public String getPeriod7() {
        return period7;
    }

    public void setPeriod7(String period7) {
        this.period7 = period7;
    }

    public Long getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(Long invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

}