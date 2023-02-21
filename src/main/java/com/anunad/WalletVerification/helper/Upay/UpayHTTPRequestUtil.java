package com.anunad.WalletVerification.helper.Upay;

import com.anunad.WalletVerification.helper.Nagad.AuthorizationResponse;
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

public class UpayHTTPRequestUtil {

    private static GsonBuilder builder = new GsonBuilder();
    private static Gson gson = builder.setDateFormat("EEE, dd MMM yyyy HH:mm:ss 'UTC'").create();

    private static String UPAY_BASE_URL = "https://uat-api.upay.systems/igdm/";
    private static String UPAY_LIVE_USERNAME = "mcbp";
    private static String UPAY_LIVE_PASSWORD = "A5u9d9C6YwQa";
    private static String UPAY_CLIENT = "xbOfWyGp80fYk7ttJloCNQm05hede2S4Fn0Q9ii3";
    private static String UPAY_CLIENT_SECRET = "aQvFkYAdsp96BSuW5WjJFNTVIMm6aAqql0XhrMxS9UdxszxxCRgOhkrfdZfRK6KB8lmOxdy56sJxXnb6wQ8KGnWAlr8OM0MgmoKnHtSBgitVoSh7WhFZfQmJYLKIOftc";
    private static String AuthKey = "eGJPZld5R3A4MGZZazd0dEpsb0NOUW0wNWhlZGUyUzRGbjBROWlpMzphUXZGa1lBZHNwOTZCU3VXNVdqSkZOVFZJTW02YUFxcWwwWGhyTXhTOVVkeHN6eHhDUmdPaGtyZmRaZlJLNktCOGxtT3hkeTU2c0p4WG5iNndROEtHbldBbHI4T00wTWdtb0tuSHRTQmdpdFZvU2g3V2hGWmZRbUpZTEtJT2Z0Yw==";


    public static UpayAuthResponse callUpayAuthAPI(REQUEST_IDENTIFIER identifier){
        System.out.println("Calling auth.......");
        try{
            URL url;
            url = new URL(identifier.toString());
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();

            String urlParameters  = "username="+ UPAY_LIVE_USERNAME +"&password="+ UPAY_LIVE_PASSWORD +"&grant_type=password";

//            byte[] postData = urlParameters.getBytes( StandardCharsets.UTF_8 );
//            int postDataLength = postData.length;

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36");
            //con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
            con.setConnectTimeout(100000);
            con.setInstanceFollowRedirects(false);
            con.setReadTimeout(100000);
//            con.addRequestProperty();
//            con.setRequestProperty("charset", "utf-8");

            con.setDoOutput(true);
            con.setDoInput(true);


            if(identifier.equals(REQUEST_IDENTIFIER.UpayAuth)) {
                String encoded = Base64.getEncoder().encodeToString((UPAY_CLIENT + ":" + UPAY_CLIENT_SECRET).getBytes(StandardCharsets.UTF_8));  //Java 8
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

                UpayAuthResponse authReponse = gson.fromJson(response.toString(), UpayAuthResponse.class);

                UpayAuthData.access_token = authReponse.getAccess_token();
                UpayAuthData.token_type = authReponse.getToken_type();
                UpayAuthData.refresh_token = authReponse.getRefresh_token();
                UpayAuthData.expires_in = authReponse.getExpires_in();
                UpayAuthData.responsecode = authReponse.getResponsecode();
                UpayAuthData.expires = authReponse.getExpires();
                UpayAuthData.userName = authReponse.getUserName();
                UpayAuthData.issued = authReponse.getIssued();
                UpayAuthData.client_id = authReponse.getClient_id();
                UpayAuthData.expired_time_in_ms = System.currentTimeMillis() + authReponse.getExpires_in() * 1000;

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


    public static UpayValidationResponse callUpayGetWalletValidation(REQUEST_IDENTIFIER identifier, String mobile, String NID, String accessToken){
        System.out.println("Calling validation.......");
        try{
//            URL url = new URL(identifier.toString()+"?nid="+NID+"&mobile="+mobile);
            URL url = new URL(identifier.toString()+"?mobile="+mobile);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

            //System.out.println("url = " + url.toString());
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept-Charset", "UTF-8");
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36");
//            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
//            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//            con.setDoOutput(false);
//            con.setDoInput(true);

            if(identifier.equals(REQUEST_IDENTIFIER.UpayGetWalletValidation)) {
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

                UpayValidationResponse valid = gson.fromJson(response.toString(), UpayValidationResponse.class);
//                System.out.println(authReponse.getExpires());
                if(valid.getResponsecode().equalsIgnoreCase("0")){
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


    public enum REQUEST_IDENTIFIER {

        /*
         * List any new webservice request here with the corresponding request path.
         * */
//        NagadAuth("https://api-sandbox.mynagad.com/dowa/api/token"),
//        NagadChangePassword("https://api-sandbox.mynagad.com/dowa/api/ACSAPIService/ChangeApiPassword"),
//        NagadRefreshToken("https://api-sandbox.mynagad.com/dowa/api/token"),
//        NagadGetWalletValidation("https://api-sandbox.mynagad.com/dowa/api/ACSAPIService/GetClientWalletValidation");


        UpayAuth(UPAY_BASE_URL+"api/token"),
        UpayChangePassword(UPAY_BASE_URL + "api/ACSAPIService/ChangeApiPassword"),
        UpayRefreshToken(UPAY_BASE_URL + "api/token"),
        UpayGetWalletValidation(UPAY_BASE_URL + "api/ACSAPIService/GetMFSClientInfo");


        /*
         * Following codes are body of this enum. You don't need to add anything here.
         * */

        private final String name;

        REQUEST_IDENTIFIER(String requestName) {
            name = requestName;
        }

        public String toString() {
            return this.name;
        }

    }
}
