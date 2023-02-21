package com.anunad.WalletVerification.helper.Upay;

public class UpayValidationResponse {

    public String responsecode;
    public String nid;
    public String smartId;
    public String mobile;
    public String nameEn;
    public Object nameBn;
    public String dateOfBirth;
    public String accountStatus;
    public String accountOpenDate;

    public String getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getSmartId() {
        return smartId;
    }

    public void setSmartId(String smartId) {
        this.smartId = smartId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public Object getNameBn() {
        return nameBn;
    }

    public void setNameBn(Object nameBn) {
        this.nameBn = nameBn;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountOpenDate() {
        return accountOpenDate;
    }

    public void setAccountOpenDate(String accountOpenDate) {
        this.accountOpenDate = accountOpenDate;
    }
}
