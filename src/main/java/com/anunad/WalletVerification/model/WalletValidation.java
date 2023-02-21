package com.anunad.WalletVerification.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "wallet_validation")
public class WalletValidation {

    private int id;

    private Timestamp createdTime;
    private Timestamp modifiedTime;
    private String accountNo;
    private Integer attempt;
    private Integer isAllow;
    private Integer beneficiaryId;

    private Integer mobileBankingProviderId;

    private int isVerified;

//    @ManyToOne
//    @JoinColumn(name = "beneficiary_id", referencedColumnName = "Id", nullable = false)
//    private Beneficiary beneficiaryById;

//    @ManyToOne
//    @JoinColumn(name = "mobile_bank_provider_id", referencedColumnName = "Id", nullable = false)
//    private MobileBankingProvider MobileBankingProviderById;

    @Basic
    @Column(name = "mobile_bank_provider_id", nullable = true)
    public Integer getMobileBankingProviderId() {
        return mobileBankingProviderId;
    }

    public void setMobileBankingProviderId(Integer mobileBankingProviderId) {
        this.mobileBankingProviderId = mobileBankingProviderId;
    }

//    public MobileBankingProvider getMobileBankingProviderById() {
//        return MobileBankingProviderById;
//    }
//
//    public void setMobileBankingProviderById(MobileBankingProvider mobileBankingProviderById) {
//        MobileBankingProviderById = mobileBankingProviderById;
//    }

    @Basic
    @Column(name = "beneficiary_id", nullable = true)
    public Integer getBeneficiaryId() {
        return beneficiaryId;
    }

    public void setBeneficiaryId(Integer beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }


//    public Beneficiary getBeneficiaryById() {
//        return beneficiaryById;
//    }
//
//    public void setBeneficiaryById(Beneficiary beneficiaryById) {
//        this.beneficiaryById = beneficiaryById;
//    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "created_time", nullable = true)
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "modified_time", nullable = true)
    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Basic
    @Column(name = "account_no", nullable = true, length = 50)
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Basic
    @Column(name = "attempt", nullable = true)
    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    @Basic
    @Column(name = "is_allow", nullable = true)
    public Integer getIsAllow() {
        return isAllow;
    }

    public void setIsAllow(Integer isAllow) {
        this.isAllow = isAllow;
    }


    @Column(name="is_verfied")
    public int getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(int isVerified) {
        this.isVerified = isVerified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WalletValidation that = (WalletValidation) o;
        return id == that.id &&
                Objects.equals(createdTime, that.createdTime) &&
                Objects.equals(modifiedTime, that.modifiedTime) &&
                Objects.equals(accountNo, that.accountNo) &&
                Objects.equals(attempt, that.attempt) &&
                Objects.equals(isAllow, that.isAllow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdTime, modifiedTime, accountNo, attempt, isAllow);
    }

}
