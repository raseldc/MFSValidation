package com.anunad.WalletVerification.helper.Nagad;

import java.util.Date;

public class NagadAuthData {

    public static String access_token;
    public static  String token_type;
    public static  String refresh_token;
    public static  int expires_in;
    public static  String scope;
    public static  String responsecode;

    //    @JsonDeserialize(using = CustomDateDeserializer.class)
    public static Date expires;
    public static String userName;

    //    @JsonDeserialize(using = CustomDateDeserializer.class)
    public static Date issued;
    public static String client_id;
}
