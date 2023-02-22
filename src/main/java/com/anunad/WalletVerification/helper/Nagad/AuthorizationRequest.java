package com.anunad.WalletVerification.helper.Nagad;

/**
 *
 * @author rasel
 */
public class AuthorizationRequest {
    private String username;
    private String password;
    private String grant_type;

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getGrant_type() {
        return grant_type;
    }

    /**
     *
     * @param grant_type
     */
    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }
}
