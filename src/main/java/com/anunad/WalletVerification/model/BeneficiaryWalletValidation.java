package com.anunad.WalletVerification.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "beneficiary_wallet_validation", schema = "imlma")
public class BeneficiaryWalletValidation {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "is_account_verfied", nullable = false)
    private int isAccountVerfied;

    @Basic
    @Column(name = "modified_time", nullable = false)
    private Timestamp modifiedTime;

    @Basic
    @Column(name = "attempt", nullable = false)
    private int attempt;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "Id", nullable = false)
    private Beneficiary beneficiaryById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getIsAccountVerfied() {
        return isAccountVerfied;
    }

    public void setIsAccountVerfied(int isAccountVerfied) {
        this.isAccountVerfied = isAccountVerfied;
    }


    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeneficiaryWalletValidation that = (BeneficiaryWalletValidation) o;
        return id == that.id &&
                isAccountVerfied == that.isAccountVerfied &&
                attempt == that.attempt &&
                Objects.equals(modifiedTime, that.modifiedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isAccountVerfied, modifiedTime, attempt);
    }

    public Beneficiary getBeneficiaryById() {
        return beneficiaryById;
    }

    public void setBeneficiaryById(Beneficiary beneficiaryById) {
        this.beneficiaryById = beneficiaryById;
    }
}
