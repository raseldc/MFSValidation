package com.anunad.WalletVerification.helper.Nagad;

import com.anunad.WalletVerification.helper.WalletStatus;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

/**
 *
 * @author rasel
 */
public class NagadVerificationHelper {

    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.create();

    /**
     *
     * @param nid
     * @param mobile
     * @return
     */
    public static WalletStatus getNagadWalletValidation(String nid, String mobile) {
        AuthorizationResponse authorizationResponse = new AuthorizationResponse();
        if(NagadAuthData.access_token==null){
            authorizationResponse = NagadHTTPRequestUtil.callNagadAuthAPI(NagadHTTPRequestUtil.REQUEST_IDENTIFIER.NagadAuth);
        }
//        else if(NagadAuthData.expires.getTime()<=new Date().getTime()){
//            authorizationResponse = NagadHTTPRequestUtil.callNagadAuthAPI(NagadHTTPRequestUtil.REQUEST_IDENTIFIER.NagadAuth);
//        }
        else if(NagadAuthData.expired_time_in_ms <= System.currentTimeMillis() ){
            authorizationResponse = NagadHTTPRequestUtil.callNagadAuthAPI(NagadHTTPRequestUtil.REQUEST_IDENTIFIER.NagadAuth);
        }

//        System.out.println("access_token: "+NagadAuthData.access_token);
//        WalletStatus walletStatus = new WalletStatus();

        return checkNagadAccount(authorizationResponse, nid, mobile);

    }

    private static WalletStatus checkNagadAccount(AuthorizationResponse authorizationResponse, String nid, String mobile){
        WalletStatus walletStatus = new WalletStatus();
        ValidationResponse validationResponse = NagadHTTPRequestUtil.callNagadGetWalletValidation(NagadHTTPRequestUtil.REQUEST_IDENTIFIER.NagadGetWalletValidation,mobile,nid, NagadAuthData.access_token);

        if(validationResponse == null){
            authorizationResponse = NagadHTTPRequestUtil.callNagadAuthAPI(NagadHTTPRequestUtil.REQUEST_IDENTIFIER.NagadAuth);
            //System.out.println("access_token: "+authorizationResponse.getAccess_token());
            if(authorizationResponse!=null && authorizationResponse.getResponsecode().equalsIgnoreCase("0"))
            {
                validationResponse = NagadHTTPRequestUtil.callNagadGetWalletValidation(NagadHTTPRequestUtil.REQUEST_IDENTIFIER.NagadGetWalletValidation,mobile,nid, NagadAuthData.access_token);
            }else{
                walletStatus.setError(true);
                walletStatus.setValid(false);
                walletStatus.setResponse("Nagad authorization failed");
                return walletStatus;

            }

        }

        if(validationResponse !=null && validationResponse.getResponseCode().equalsIgnoreCase("0")) {

            if(validationResponse.getDisbursement().equalsIgnoreCase("Eligible")){
                walletStatus.setError(false);
                walletStatus.setValid(true);
                walletStatus.setResponse("Eligible for Payment");
            }else{
                walletStatus.setError(false);
                walletStatus.setValid(false);
                walletStatus.setResponse("Not eligible for Payment");
            }
            return walletStatus;
        }else{
            walletStatus.setError(true);
            walletStatus.setValid(false);
            walletStatus.setResponse("Nagad validation failed");
            return walletStatus;
        }
    }
}
