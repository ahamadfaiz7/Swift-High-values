package za.co.flexpay.funding.api.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SwiftInFundingRequest implements Serializable {


    private Integer systemID;
    private String financialInstitution;
    private String statementReference;
    private String transactionDate;
    private String settlementDate;
    private BigDecimal settlementAmount;
    private String currencyCode;
    private String uniqueEndToEndIdentifier;
    private List<SwiftFundingPayerInfoDTO> payerInfo = new ArrayList<>();
    private List<SwiftFundingBeneficiaryInfoDTO> beneficiaryInfo = new ArrayList<>();

    public Integer getSystemID() {
        return systemID;
    }

    public void setSystemID(Integer systemID) {
        this.systemID = systemID;
    }

    public String getFinancialInstitution() {
        return financialInstitution;
    }

    public void setFinancialInstitution(String financialInstitution) {
        this.financialInstitution = financialInstitution;
    }

    public String getStatementReference() {
        return statementReference;
    }

    public void setStatementReference(String statementReference) {
        this.statementReference = statementReference;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
    }

    public BigDecimal getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(BigDecimal settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getUniqueEndToEndIdentifier() {
        return uniqueEndToEndIdentifier;
    }

    public void setUniqueEndToEndIdentifier(String uniqueEndToEndIdentifier) {
        this.uniqueEndToEndIdentifier = uniqueEndToEndIdentifier;
    }

    public List<SwiftFundingPayerInfoDTO> getPayerInfo() {
        return payerInfo;
    }

    public void setPayerInfo(List<SwiftFundingPayerInfoDTO> payerInfo) {
        this.payerInfo = payerInfo;
    }

    public List<SwiftFundingBeneficiaryInfoDTO> getBeneficiaryInfo() {
        return beneficiaryInfo;
    }

    public void setBeneficiaryInfo(List<SwiftFundingBeneficiaryInfoDTO> beneficiaryInfo) {
        this.beneficiaryInfo = beneficiaryInfo;
    }
}