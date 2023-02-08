package com.anunad.WalletVerification.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "beneficiary")
public class Beneficiary  {

    @Id
    @GeneratedValue
    private Integer Id;

    @Column(name = "nick_name", nullable = true)
    private String nickName;

    @Column(name = "nid", nullable = false, length = 17)
    private BigInteger nid;

    @Column(name = "date_of_birth", nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Calendar dateOfBirth;


    @Column(name = "father_name", nullable = true)
    private String fatherName;

    @Column(name = "mother_name", nullable = true)
    private String motherName;

    @Column(name = "spouse_name", nullable = true)
    private String spouseName;

    @Column(name = "mobile_number", nullable = true, length = 11)
    private Integer mobileNo;

    @Column(name = "is_lm_mis_exist", nullable = true, length = 11)
    private Integer isLMMISExist;


//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "batch_id", nullable = false)
//    private Batch batch;
    // Address Info    
    @Column(name = "permanent_addressline1", nullable = false)
    private String permanentAddressLine1;

    @Column(name = "permanent_addressline2")
    private String permanentAddressLine2;


    @Column(name = "permanent_ward_no", nullable = true)
    private String permanentWardNo;

    @Column(name = "permanent_postcode", columnDefinition = "char(4)", nullable = false)
    private String permanentPostCode;

    @Column(name = "present_addressline1", nullable = false)
    private String presentAddressLine1;

    @Column(name = "present_addressline2")
    private String presentAddressLine2;



    @Column(name = "present_ward_no", nullable = true)
    private String presentWardNo;

    @Column(name = "present_postcode", columnDefinition = "char(4)", nullable = false)
    private String presentPostCode;


    @Column(name = "mobile_banking_provider_id", nullable = true)
    private Integer mobileBankingProvider;

    @Column(name = "account_type_id", columnDefinition = "tinyint unsigned", nullable = true)
    private Integer accountType;

    @Column(name = "account_name", nullable = true)
    private String accountName;

    @Column(name = "account_no", nullable = true, length = 17)
    private String accountNo;




//    @Formula(value = "concat(concat(first_name_in_english, ' ', case when middle_name_in_english is null then '' else middle_name_in_english end), ' ', last_name_in_english)")
    @Column(name = "full_name_in_english", nullable = false)
    private String fullNameInEnglish;

//    @Formula(value = "concat(concat(first_name_in_bangla, ' ', case when middle_name_in_bangla is null then '' else middle_name_in_bangla end), ' ', last_name_in_bangla)")
    @Column(name = "full_name_in_bangla", nullable = false)
    private String fullNameInBangla;


    @Column(name = "incident_date", nullable = true)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar incidentDate;

    @Column(name = "deactivation_comment", nullable = true)
    private String deactivationComment;

    @Column(name = "attachment_path")
    private String attachmentPath;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "enrollment_date", nullable = false)
    private Calendar enrollmentDate;

    @Column(name="is_account_verfied")
    private int isAccountVerified;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "Id", nullable = false)
    private BeneficiaryWalletValidation beneficiaryWalletValidation;

    @Transient
    private List<Integer> attachmentRemoveList;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public BigInteger getNid() {
        return nid;
    }

    public void setNid(BigInteger nid) {
        this.nid = nid;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public Integer getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(Integer mobileNo) {
        this.mobileNo = mobileNo;
    }


    public String getPermanentAddressLine1() {
        return permanentAddressLine1;
    }

    public void setPermanentAddressLine1(String permanentAddressLine1) {
        this.permanentAddressLine1 = permanentAddressLine1;
    }

    public String getPermanentAddressLine2() {
        return permanentAddressLine2;
    }

    public void setPermanentAddressLine2(String permanentAddressLine2) {
        this.permanentAddressLine2 = permanentAddressLine2;
    }

    public String getPermanentWardNo() {
        return permanentWardNo;
    }

    public void setPermanentWardNo(String permanentWardNo) {
        this.permanentWardNo = permanentWardNo;
    }

    public String getPermanentPostCode() {
        return permanentPostCode;
    }

    public void setPermanentPostCode(String permanentPostCode) {
        this.permanentPostCode = permanentPostCode;
    }

    public String getPresentAddressLine1() {
        return presentAddressLine1;
    }

    public void setPresentAddressLine1(String presentAddressLine1) {
        this.presentAddressLine1 = presentAddressLine1;
    }

    public String getPresentAddressLine2() {
        return presentAddressLine2;
    }

    public void setPresentAddressLine2(String presentAddressLine2) {
        this.presentAddressLine2 = presentAddressLine2;
    }


    public String getPresentWardNo() {
        return presentWardNo;
    }

    public void setPresentWardNo(String presentWardNo) {
        this.presentWardNo = presentWardNo;
    }

    public String getPresentPostCode() {
        return presentPostCode;
    }

    public void setPresentPostCode(String presentPostCode) {
        this.presentPostCode = presentPostCode;
    }


    public Integer getMobileBankingProvider() {
        return mobileBankingProvider;
    }

    public void setMobileBankingProvider(Integer mobileBankingProvider) {
        this.mobileBankingProvider = mobileBankingProvider;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }


    public String getFullNameInEnglish() {
        return fullNameInEnglish;
    }

    public void setFullNameInEnglish(String fullNameInEnglish) {
        this.fullNameInEnglish = fullNameInEnglish;
    }

    public String getFullNameInBangla() {
        return fullNameInBangla;
    }

    public void setFullNameInBangla(String fullNameInBangla) {
        this.fullNameInBangla = fullNameInBangla;
    }

    public Calendar getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(Calendar incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getDeactivationComment() {
        return deactivationComment;
    }

    public void setDeactivationComment(String deactivationComment) {
        this.deactivationComment = deactivationComment;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public int getIsAccountVerified() {
        return isAccountVerified;
    }

    public void setIsAccountVerified(int isAccountVerified) {
        this.isAccountVerified = isAccountVerified;
    }

    //    public Batch getBatch()
//    {
//        return batch;
//    }
//
//    public void setBatch(Batch batch)
//    {
//        this.batch = batch;
//    }
    public List<Integer> getAttachmentRemoveList() {
        return attachmentRemoveList;
    }

    public void setAttachmentRemoveList(List<Integer> attachmentRemoveList) {
        this.attachmentRemoveList = attachmentRemoveList;
    }

    public Calendar getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Calendar enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Id == null) ? 0 : Id.hashCode());
        return result;
    }

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
        Beneficiary other = (Beneficiary) obj;
        if (Id == null) {
            if (other.Id != null) {
                return false;
            }
        } else if (!Id.equals(other.Id)) {
            return false;
        }
        return true;
    }

    public Integer getIsLMMISExist() {        
        return isLMMISExist;
    }

    public void setIsLMMISExist(Integer isLMMISExist) {
        this.isLMMISExist = isLMMISExist;
    }

    public BeneficiaryWalletValidation getBeneficiaryWalletValidation() {
        return beneficiaryWalletValidation;
    }

    public void setBeneficiaryWalletValidation(BeneficiaryWalletValidation beneficiaryWalletValidation) {
        this.beneficiaryWalletValidation = beneficiaryWalletValidation;
    }
}
