package com.anunad.WalletVerification.helper.Nagad;

import com.anunad.WalletVerification.helper.Nagad.AuthorizationResponse;
import com.anunad.WalletVerification.helper.Nagad.NagadAuthData;
import com.anunad.WalletVerification.helper.Nagad.ValidationResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author rasel
 */
public class NagadHTTPRequestUtil {

    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.setDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'").create();

    private static String NAGAD_BASE_URL = "https://api-external.mynagad.com/dowa/wallet-validation/";
    private static String NAGAD_LIVE_USERNAME = "dowauser";
    private static String NAGAD_LIVE_PASSWORD = "dOw@123$#p";
    private static String NAGAD_CLIENT = "Nagad_DoWA_Service";
    private static String NAGAD_CLIENT_SECRET = "W@llet_V@l!d@t!on_Serv!ce";

//    private static String NAGAD_BASE_URL = "https://api-sandbox.mynagad.com/dowa/";
//    private static String NAGAD_LIVE_USERNAME = "qauser";
//    private static String NAGAD_LIVE_PASSWORD = "q@P@$$wOrd13";

    /**
     *
     * @param identifier
     * @return
     */

    public static AuthorizationResponse callNagadAuthAPI( REQUEST_IDENTIFIER identifier){
        System.out.println("Calling auth.......");
        try{
            URL url;
            url = new URL(identifier.toString());
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

            String urlParameters  = "username="+ NAGAD_LIVE_USERNAME +"&password="+ NAGAD_LIVE_PASSWORD +"&grant_type=password";

//            byte[] postData = urlParameters.getBytes( StandardCharsets.UTF_8 );
//            int postDataLength = postData.length;

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("charset", "utf-8");

            con.setDoOutput(true);
            con.setDoInput(true);


            if(identifier.equals(REQUEST_IDENTIFIER.NagadAuth)) {
                String encoded = Base64.getEncoder().encodeToString((NAGAD_CLIENT + ":" + NAGAD_CLIENT_SECRET).getBytes(StandardCharsets.UTF_8));  //Java 8
                con.setRequestProperty("Authorization", "Basic " + encoded);
            }
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();


            int responseCode = con.getResponseCode();
            System.out.println("Reponse Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream(), "utf-8"));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                JSONObject jsonResponse = new JSONObject(response.toString());

                System.out.println(jsonResponse);

                AuthorizationResponse authReponse = gson.fromJson(response.toString(), AuthorizationResponse.class);

                NagadAuthData.access_token = authReponse.getAccess_token();
                NagadAuthData.token_type = authReponse.getToken_type();
                NagadAuthData.refresh_token = authReponse.getRefresh_token();
                NagadAuthData.expires_in = authReponse.getExpires_in();
                NagadAuthData.scope = authReponse.getScope();
                NagadAuthData.responsecode = authReponse.getResponsecode();
                NagadAuthData.expires = authReponse.getExpires();
                NagadAuthData.userName = authReponse.getUserName();
                NagadAuthData.issued = authReponse.getIssued();
                NagadAuthData.client_id = authReponse.getClient_id();
                NagadAuthData.expired_time_in_ms = System.currentTimeMillis() + authReponse.getExpires_in() * 1000;


//                System.out.println(authReponse.getExpires());
//                System.out.println(authReponse.getAccess_token());
//                System.out.println(authReponse.getClient_id());
//                System.out.println(authReponse.getExpires_in());
//                System.out.println(authReponse.getIssued());
//                System.out.println(authReponse.getToken_type());
//                System.out.println(authReponse.getRefresh_token());
//                System.out.println(authReponse.getResponsecode());

                return authReponse;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param identifier
     * @param mobile
     * @param NID
     * @param accessToken
     * @return
     */
    public static ValidationResponse callNagadGetWalletValidation( REQUEST_IDENTIFIER identifier, String mobile, String NID, String accessToken){
        System.out.println("Calling validation.......");
        try{
            URL url = new URL(identifier.toString()+"?nid="+NID+"&mobile="+mobile);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            //System.out.println("url = " + url.toString());
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept-Charset", "UTF-8");
//            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//            con.setDoOutput(false);
//            con.setDoInput(true);

            if(identifier.equals(REQUEST_IDENTIFIER.NagadGetWalletValidation)) {
                con.setRequestProperty("Authorization", "Bearer "+ accessToken);
            }


            int responseCode = con.getResponseCode();
            System.out.println("Reponse Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream(), "utf-8"));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                JSONObject jsonResponse = new JSONObject(response.toString());

                System.out.println(jsonResponse);

                ValidationResponse valid = gson.fromJson(response.toString(), ValidationResponse.class);
//                System.out.println(authReponse.getExpires());
                if(valid.getResponseCode().equalsIgnoreCase("0")){
                    return valid;
                }
                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     *
     */
    public enum REQUEST_IDENTIFIER {

        /*
         * List any new webservice request here with the corresponding request path.
         * */
//        NagadAuth("https://api-sandbox.mynagad.com/dowa/api/token"),
//        NagadChangePassword("https://api-sandbox.mynagad.com/dowa/api/ACSAPIService/ChangeApiPassword"),
//        NagadRefreshToken("https://api-sandbox.mynagad.com/dowa/api/token"),
//        NagadGetWalletValidation("https://api-sandbox.mynagad.com/dowa/api/ACSAPIService/GetClientWalletValidation");

        /**
         *
         */


        NagadAuth(NAGAD_BASE_URL+"api/token"),

        /**
         *
         */
        NagadChangePassword(NAGAD_BASE_URL + "api/ACSAPIService/ChangeApiPassword"),

        /**
         *
         */
        NagadRefreshToken(NAGAD_BASE_URL + "api/token"),

        /**
         *
         */
        NagadGetWalletValidation(NAGAD_BASE_URL + "api/ACSAPIService/GetClientWalletValidation");


        /*
         * Following codes are body of this enum. You don't need to add anything here.
         * */

        private final String name;

        REQUEST_IDENTIFIER(String requestName) {
            name = requestName;
        }

        /**
         *
         * @return
         */
        public String toString() {
            return this.name;
        }

    }
}
