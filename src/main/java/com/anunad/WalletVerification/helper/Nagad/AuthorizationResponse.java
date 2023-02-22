package com.anunad.WalletVerification.helper.Nagad;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author rasel
 */
public class AuthorizationResponse {
    private  String access_token;
    private  String token_type;
    private  String refresh_token;
    private  int expires_in;
    private  String scope;
    private  String responsecode;

//    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date expires;
    private String userName;

//    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date issued;
    private String client_id;

    /**
     *
     * @return
     */
    public String getAccess_token() {
        return access_token;
    }

    /**
     *
     * @param access_token
     */
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    /**
     *
     * @return
     */
    public String getToken_type() {
        return token_type;
    }

    /**
     *
     * @param token_type
     */
    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    /**
     *
     * @return
     */
    public String getRefresh_token() {
        return refresh_token;
    }

    /**
     *
     * @param refresh_token
     */
    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    /**
     *
     * @return
     */
    public int getExpires_in() {
        return expires_in;
    }

    /**
     *
     * @param expires_in
     */
    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    /**
     *
     * @return
     */
    public String getScope() {
        return scope;
    }

    /**
     *
     * @param scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

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
    public Date getExpires() {
        return expires;
    }

    /**
     *
     * @param expires
     */
    public void setExpires(Date expires) {
        this.expires = expires;
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    public Date getIssued() {
        return issued;
    }

    /**
     *
     * @param issued
     */
    public void setIssued(Date issued) {
        this.issued = issued;
    }

    /**
     *
     * @return
     */
    public String getClient_id() {
        return client_id;
    }

    /**
     *
     * @param client_id
     */
    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }


}
