package com.anunad.WalletVerification.helper.Upay;


import com.anunad.WalletVerification.helper.WalletStatus;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

/**
 *
 * @author rasel
 */
public class UpayVerificationHelper {

    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.create();

    /**
     *
     * @param nid
     * @param mobile
     * @return
     */
    public static WalletStatus getUpayWalletValidation(String nid, String mobile) {
        UpayAuthResponse authResponse = new UpayAuthResponse();
        if(UpayAuthData.access_token==null){
            authResponse = UpayHTTPRequestUtil.callUpayAuthAPI(UpayHTTPRequestUtil.REQUEST_IDENTIFIER.UpayAuth);
        }
//        else if(UpayAuthData.expires.getTime()<=new Date().getTime()){
//            authResponse = UpayHTTPRequestUtil.callUpayAuthAPI(UpayHTTPRequestUtil.REQUEST_IDENTIFIER.UpayAuth);
//        }
        else if(UpayAuthData.expired_time_in_ms <= System.currentTimeMillis() ){
            authResponse = UpayHTTPRequestUtil.callUpayAuthAPI(UpayHTTPRequestUtil.REQUEST_IDENTIFIER.UpayAuth);
        }

//        System.out.println("access_token: "+UpayAuthData.access_token);
//        WalletStatus walletStatus = new WalletStatus();

        return checkUpayAccount(authResponse, nid, mobile);

    }

    private static WalletStatus checkUpayAccount(UpayAuthResponse authResponse, String nid, String mobile){
        WalletStatus walletStatus = new WalletStatus();
        UpayValidationResponse validationResponse = UpayHTTPRequestUtil.callUpayGetWalletValidation(UpayHTTPRequestUtil.REQUEST_IDENTIFIER.UpayGetWalletValidation,mobile,nid, UpayAuthData.access_token);

        if(validationResponse == null){
            authResponse = UpayHTTPRequestUtil.callUpayAuthAPI(UpayHTTPRequestUtil.REQUEST_IDENTIFIER.UpayAuth);
            //System.out.println("access_token: "+authorizationResponse.getAccess_token());
            if(authResponse!=null && authResponse.getResponsecode().equalsIgnoreCase("0"))
            {
                validationResponse = UpayHTTPRequestUtil.callUpayGetWalletValidation(UpayHTTPRequestUtil.REQUEST_IDENTIFIER.UpayGetWalletValidation,mobile,nid, UpayAuthData.access_token);
            }else{
                walletStatus.setError(true);
                walletStatus.setValid(false);
                walletStatus.setResponse("Upay authorization failed");
                return walletStatus;

            }

        }

        if(validationResponse !=null && validationResponse.getResponsecode().equalsIgnoreCase("0")) {

            if(validationResponse.getAccountStatus().equalsIgnoreCase("Active")){
                walletStatus.setError(false);
                walletStatus.setValid(true);
                walletStatus.setResponse("Eligible for Payment");
            }else{
                walletStatus.setError(false);
                walletStatus.setValid(false);
                walletStatus.setResponse("Not eligible for Payment");
            }
            // walletStatus.setResponse("Need to Check");
            return walletStatus;
        }else{
            walletStatus.setError(true);
            walletStatus.setValid(false);
            walletStatus.setResponse("Upay validation failed");
            return walletStatus;
        }
    }
}
