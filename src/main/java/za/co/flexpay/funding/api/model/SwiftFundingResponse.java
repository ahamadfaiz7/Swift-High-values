package za.co.flexpay.funding.api.model;

import java.io.Serializable;

public class SwiftFundingResponse implements Serializable {

    private String transactionIdentifier;
    private String errorNo;
    private String errorDescription;


    public SwiftFundingResponse(String transactionIdentifier, String errorNo, String errorDescription) {
        this.transactionIdentifier = transactionIdentifier;
        this.errorNo = errorNo;
        this.errorDescription = errorDescription;
    }

    public String getTransactionIdentifier() {
        return transactionIdentifier;
    }

    public void setTransactionIdentifier(String transactionIdentifier) {
        this.transactionIdentifier = transactionIdentifier;
    }

    public String getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(String errorNo) {
        this.errorNo = errorNo;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }
}
