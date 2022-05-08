package za.co.flexpay.funding.api.model;

import java.io.Serializable;

/**
 * Hold Swift high value beneficiary info
 */
public class SwiftFundingBeneficiaryInfoDTO implements Serializable {

    private static final long serialVersionUID = 556540263964373268L;
    private String name;
    private String cellphoneNo;
    private String email;
    private String accountNumber;
    private String branchCode;
    private Integer accountType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphoneNo() {
        return cellphoneNo;
    }

    public void setCellphoneNo(String cellphoneNo) {
        this.cellphoneNo = cellphoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }
}

