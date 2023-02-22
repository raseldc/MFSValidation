package com.anunad.WalletVerification.helper.Upay;

/**
 *
 * @author rasel
 */
public class UpayValidationResponse {

    /**
     *
     */
    public String responsecode;

    /**
     *
     */
    public String nid;

    /**
     *
     */
    public String smartId;

    /**
     *
     */
    public String mobile;

    /**
     *
     */
    public String nameEn;

    /**
     *
     */
    public Object nameBn;

    /**
     *
     */
    public String dateOfBirth;

    /**
     *
     */
    public String accountStatus;

    /**
     *
     */
    public String accountOpenDate;

    /**
     *
     * @return
     */
    public String getResponsecode() {
        return responsecode;
    }

    /**
     *
     * @param responsecode
     */
    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode;
    }

    /**
     *
     * @return
     */
    public String getNid() {
        return nid;
    }

    /**
     *
     * @param nid
     */
    public void setNid(String nid) {
        this.nid = nid;
    }

    /**
     *
     * @return
     */
    public String getSmartId() {
        return smartId;
    }

    /**
     *
     * @param smartId
     */
    public void setSmartId(String smartId) {
        this.smartId = smartId;
    }

    /**
     *
     * @return
     */
    public String getMobile() {
        return mobile;
    }

    /**
     *
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     *
     * @return
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     *
     * @param nameEn
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    /**
     *
     * @return
     */
    public Object getNameBn() {
        return nameBn;
    }

    /**
     *
     * @param nameBn
     */
    public void setNameBn(Object nameBn) {
        this.nameBn = nameBn;
    }

    /**
     *
     * @return
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     *
     * @param dateOfBirth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     *
     * @return
     */
    public String getAccountStatus() {
        return accountStatus;
    }

    /**
     *
     * @param accountStatus
     */
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     *
     * @return
     */
    public String getAccountOpenDate() {
        return accountOpenDate;
    }

    /**
     *
     * @param accountOpenDate
     */
    public void setAccountOpenDate(String accountOpenDate) {
        this.accountOpenDate = accountOpenDate;
    }
}
