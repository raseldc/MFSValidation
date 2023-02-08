package com.anunad.WalletVerification.helper.Nagad;

import java.util.Date;

public class ValidationResponse {

    private String responseCode;
    private String reason;

    private String wallet;
    private String nid;
    private String disbursement;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responsecode) {
        this.responseCode = responsecode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getDisbursement() {
        return disbursement;
    }

    public void setDisbursement(String disbursement) {
        this.disbursement = disbursement;
    }
}
