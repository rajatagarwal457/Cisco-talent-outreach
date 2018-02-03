<<<<<<< HEAD
package ambulane.example.ambulane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.lang.Boolean;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;
public class ServiceHandler {

    static InputStream is = null;
    static String response = null;
    public final static int GET = 1;
    public final static int POST = 2;
    public static boolean NotificationCheck;

    public ServiceHandler() {
    }

    public String makeServiceCall(String url, int method) {
        return this.makeServiceCall(url, method, null);
    }


    public String makeServiceCall(String url, int method,
                                  List<NameValuePair> params) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;

            Log.d("inside","ServiceHandler");

            if (method == POST) {
                HttpPost httpPost = new HttpPost(url);

                if (params != null) {
                    httpPost.setEntity(new UrlEncodedFormEntity(params));
                }

                httpResponse = httpClient.execute(httpPost);

            } else if (method == GET) {

                if (params != null) {
                    String paramString = URLEncodedUtils
                            .format(params, "utf-8");
                    url += "?" + paramString;
                }
                HttpGet httpGet = new HttpGet(url);

                httpResponse = httpClient.execute(httpGet);

            }
            httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "UTF-8"), 8);
            //StringBuilder sb = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                //sb.append(line + "\n");
                response += line;
            }
            is.close();

            //Gson g = new Gson();
            //String ResponseGson = g.toJson(response);

            //response = sb.toString();
            Log.d("inside", "<response>" + response + "</response>");

            //JSONObject json = new JSONObject(response);
            //String responseValue = json.getString("NotificationCheck");

            //Gets the value of "NotificationCheck" from string Response;
            String responseValue = response.substring(response.lastIndexOf(':') + 2, response.lastIndexOf('"'));

            NotificationCheck = Boolean.parseBoolean(responseValue);

            Log.d("NotifVar = ", responseValue);

        } catch (Exception e) {
            Log.e("Buffer Error", "Error: " + e.toString());
        }
        return response;
    }
    public boolean getNotificationCheck(){
        return NotificationCheck;
    }
=======
package ambulane.example.ambulane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.lang.Boolean;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;
public class ServiceHandler {

    static InputStream is = null;
    static String response = null;
    public final static int GET = 1;
    public final static int POST = 2;
    public static boolean NotificationCheck;

    public ServiceHandler() {
    }

    public String makeServiceCall(String url, int method) {
        return this.makeServiceCall(url, method, null);
    }


    public String makeServiceCall(String url, int method,
                                  List<NameValuePair> params) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;

            Log.d("inside","ServiceHandler");

            if (method == POST) {
                HttpPost httpPost = new HttpPost(url);

                if (params != null) {
                    httpPost.setEntity(new UrlEncodedFormEntity(params));
                }

                httpResponse = httpClient.execute(httpPost);

            } else if (method == GET) {

                if (params != null) {
                    String paramString = URLEncodedUtils
                            .format(params, "utf-8");
                    url += "?" + paramString;
                }
                HttpGet httpGet = new HttpGet(url);

                httpResponse = httpClient.execute(httpGet);

            }
            httpEntity = httpResponse.getEntity();
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "UTF-8"), 8);
            //StringBuilder sb = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                //sb.append(line + "\n");
                response += line;
            }
            is.close();

            //Gson g = new Gson();
            //String ResponseGson = g.toJson(response);

            //response = sb.toString();
            Log.d("inside", "<response>" + response + "</response>");

            //JSONObject json = new JSONObject(response);
            //String responseValue = json.getString("NotificationCheck");

            //Gets the value of "NotificationCheck" from string Response;
            String responseValue = response.substring(response.lastIndexOf(':') + 2, response.lastIndexOf('"'));

            NotificationCheck = Boolean.parseBoolean(responseValue);

            Log.d("NotifVar = ", responseValue);

        } catch (Exception e) {
            Log.e("Buffer Error", "Error: " + e.toString());
        }
        return response;
    }
    public boolean getNotificationCheck(){
        return NotificationCheck;
    }
>>>>>>> 76c10b4b0a8129cada86eb3e78ad559335656ccc
}