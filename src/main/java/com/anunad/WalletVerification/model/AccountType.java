package com.anunad.WalletVerification.model;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

/**
 *
 * @author rasel
 */
@Entity
@Table(name = "account_type")
public class AccountType implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", columnDefinition = "tinyint unsigned")
    private Integer id;

    @Column(name = "name_in_bangla", length = 255, unique = true, nullable = false)
    private String nameInBangla;

    @Column(name = "name_in_english", length = 255, unique = true, nullable = false)
    private String nameInEnglish;

    @Column(name = "code", columnDefinition = "char(16)", unique = true, nullable = false)
    private String code;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "active", columnDefinition = "bit(1)", nullable = false)
    private boolean active;

    @Column(name = "is_deleted", columnDefinition = "bit(1) default false")
    private boolean deleted;

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
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
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

}
