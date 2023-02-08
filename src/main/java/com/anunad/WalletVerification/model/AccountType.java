package com.anunad.WalletVerification.model;

import javax.persistence.*;

@Entity
@Table(name = "account_type")
public class AccountType {
    @Id
    @GeneratedValue
    @Column(name = "id", columnDefinition = "tinyint unsigned")
    private Integer id;


    @Column(name = "name_in_bangla", length = 255, unique = true, nullable = false)
    private String nameInBangla;


    @Column(name = "name_in_english", length = 255, unique = true, nullable = false)
    private String nameInEnglish;


    @Column(name = "code",columnDefinition = "char(16)", unique = true,nullable = false)
    private String code;


    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "active", columnDefinition = "bit(1)", nullable = false)
    private boolean active;

    @Column(name="is_deleted", columnDefinition = "bit(1) default false")
    private boolean deleted;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getNameInBangla()
    {
        return nameInBangla;
    }

    public void setNameInBangla(String nameInBangla)
    {
        this.nameInBangla = nameInBangla;
    }

    public String getNameInEnglish()
    {
        return nameInEnglish;
    }

    public void setNameInEnglish(String nameInEnglish)
    {
        this.nameInEnglish = nameInEnglish;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }


    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }


}
