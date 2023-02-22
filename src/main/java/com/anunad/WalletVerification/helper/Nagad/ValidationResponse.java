package com.anunad.WalletVerification.helper.Nagad;

import java.util.Date;

/**
 *
 * @author rasel
 */
public class ValidationResponse {

    private String responseCode;
    private String reason;

    private String wallet;
    private String nid;
    private String disbursement;

    /**
     *
     * @return
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     *
     * @param responsecode
     */
    public void setResponseCode(String responsecode) {
        this.responseCode = responsecode;
    }

    /**
     *
     * @return
     */
    public String getReason() {
        return reason;
    }

    /**
     *
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     *
     * @return
     */
    public String getWallet() {
        return wallet;
    }

    /**
     *
     * @param wallet
     */
    public void setWallet(String wallet) {
        this.wallet = wallet;
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
    public String getDisbursement() {
        return disbursement;
    }

    /**
     *
     * @param disbursement
     */
    public void setDisbursement(String disbursement) {
        this.disbursement = disbursement;
    }
}
