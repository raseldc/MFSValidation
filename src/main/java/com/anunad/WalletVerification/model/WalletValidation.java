package com.anunad.WalletVerification.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author rasel
 */
@Entity
@Table(name = "wallet_validation")
public class WalletValidation implements java.io.Serializable {

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
    /**
     *
     * @return
     */
    @Basic
    @Column(name = "mobile_bank_provider_id", nullable = true)
    public Integer getMobileBankingProviderId() {
        return mobileBankingProviderId;
    }

    /**
     *
     * @param mobileBankingProviderId
     */
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
    /**
     *
     * @return
     */
    @Basic
    @Column(name = "beneficiary_id", nullable = true)
    public Integer getBeneficiaryId() {
        return beneficiaryId;
    }

    /**
     *
     * @param beneficiaryId
     */
    public void setBeneficiaryId(Integer beneficiaryId) {
        this.beneficiaryId = beneficiaryId;
    }

    /**
     *
     * @return
     */
    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Basic
    @Column(name = "created_time", nullable = true)
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    /**
     *
     * @param createdTime
     */
    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    /**
     *
     * @return
     */
    @Basic
    @Column(name = "modified_time", nullable = true)
    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    /**
     *
     * @param modifiedTime
     */
    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     *
     * @return
     */
    @Basic
    @Column(name = "account_no", nullable = true, length = 50)
    public String getAccountNo() {
        return accountNo;
    }

    /**
     *
     * @param accountNo
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     *
     * @return
     */
    @Basic
    @Column(name = "attempt", nullable = true)
    public Integer getAttempt() {
        return attempt;
    }

    /**
     *
     * @param attempt
     */
    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    /**
     *
     * @return
     */
    @Basic
    @Column(name = "is_allow", nullable = true)
    public Integer getIsAllow() {
        return isAllow;
    }

    /**
     *
     * @param isAllow
     */
    public void setIsAllow(Integer isAllow) {
        this.isAllow = isAllow;
    }

    /**
     *
     * @return
     */
    @Column(name = "is_verfied")
    public int getIsVerified() {
        return isVerified;
    }

    /**
     *
     * @param isVerified
     */
    public void setIsVerified(int isVerified) {
        this.isVerified = isVerified;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WalletValidation that = (WalletValidation) o;
        return id == that.id
                && Objects.equals(createdTime, that.createdTime)
                && Objects.equals(modifiedTime, that.modifiedTime)
                && Objects.equals(accountNo, that.accountNo)
                && Objects.equals(attempt, that.attempt)
                && Objects.equals(isAllow, that.isAllow);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, createdTime, modifiedTime, accountNo, attempt, isAllow);
    }

}
