/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anunad.WalletVerification.model;


import javax.persistence.*;
import java.util.Objects;

/**
 *
 * @author Munim at Anunad Solution
 */
@Entity
@Table(name = "mobile_banking_provider")
public class MobileBankingProvider  implements java.io.Serializable{

    @Id
    @GeneratedValue
    @Column(columnDefinition = "tinyint unsigned")
    private Integer id;

    @Column(name = "name_in_bangla", length = 255, unique = true, nullable = false)
    private String nameInBangla;

    @Column(name = "name_in_english", length = 255, unique = true, nullable = false)
    private String nameInEnglish;

    @Column(name = "code", columnDefinition = "char(4)", unique = true, nullable = false)
    private String code;

    @Column(name = "routing_number", columnDefinition = "bit(1) default false")
    private String routingNumber;

    @Column(name = "active", columnDefinition = "bit(1)", nullable = false)
    private boolean active;

    @Column(name = "is_deleted", columnDefinition = "bit(1) default false")
    private boolean deleted;

    @Column(name = "account_no_length", nullable = false)
    private int accountNoLength;

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNameInBangla() {
        return nameInBangla;
    }

    /**
     *
     * @param nameInBangla
     */
    public void setNameInBangla(String nameInBangla) {
        this.nameInBangla = nameInBangla;
    }

    /**
     *
     * @return
     */
    public String getNameInEnglish() {
        return nameInEnglish;
    }

    /**
     *
     * @param nameInEnglish
     */
    public void setNameInEnglish(String nameInEnglish) {
        this.nameInEnglish = nameInEnglish;
    }

    /**
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     */
    public String getRoutingNumber() {
        return routingNumber;
    }

    /**
     *
     * @param routingNumber
     */
    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    /**
     *
     * @return
     */
    public boolean isActive() {
        return active;
    }

    /**
     *
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     *
     * @return
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     *
     * @param deleted
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MobileBankingProvider other = (MobileBankingProvider) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public int getAccountNoLength() {
        return accountNoLength;
    }

    /**
     *
     * @param accountNoLength
     */
    public void setAccountNoLength(int accountNoLength) {
        this.accountNoLength = accountNoLength;
    }
}
