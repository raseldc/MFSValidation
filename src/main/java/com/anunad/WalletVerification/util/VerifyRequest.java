package com.anunad.WalletVerification.util;

/**
 *
 * @author rasel
 */
public class VerifyRequest {

    private String mfs;
    private String nid;
    private String accountNo;

    /**
     *
     * @return
     */
    public String getMfs() {
        return mfs;
    }

    /**
     *
     * @param mfs
     */
    public void setMfs(String mfs) {
        this.mfs = mfs;
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
}
