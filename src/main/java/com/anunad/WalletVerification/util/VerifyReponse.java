package com.anunad.WalletVerification.util;

/**
 *
 * @author rasel
 */
public class VerifyReponse {
    private boolean isError;
    private boolean isValid;
    private String response;

    /**
     *
     * @return
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     *
     * @param valid
     */
    public void setValid(boolean valid) {
        isValid = valid;
    }

    /**
     *
     * @return
     */
    public String getResponse() {
        return response;
    }

    /**
     *
     * @param response
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     *
     * @return
     */
    public boolean isError() {
        return isError;
    }

    /**
     *
     * @param error
     */
    public void setError(boolean error) {
        isError = error;
    }
}
