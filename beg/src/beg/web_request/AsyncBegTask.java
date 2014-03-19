package beg.web_request;


import android.os.AsyncTask;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AsyncBegTask extends AsyncTask {

    protected JSONObject resp = null;

    protected final String baseUrl;

    protected AsyncBegTask() {
        baseUrl = "http://10.0.0.2:9292/";
    }

    public abstract void onFailure();

    protected static HttpClient getHttpClient(){
        return new DefaultHttpClient();
    }

    protected static String parseResponseToString(HttpResponse response) throws IOException {
        return getBufferedReaderFromResponse(response).readLine();
    }

    private static BufferedReader getBufferedReaderFromResponse(HttpResponse response) throws IOException {
        return new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
    }

    private static HttpGet getHttpGet(String uri) {
        return new HttpGet(uri);
    }

    protected static HttpResponse executeHttpGet(String uri) throws IOException {
        return getHttpClient().execute(getHttpGet(uri));
    }

    protected static JSONObject getJsonObjectFromString(String stringResponse) throws JSONException {
        return new JSONObject(new JSONTokener(stringResponse));
    }

    protected static JSONArray getJsonArrayFromString(String stringResponse) throws JSONException {
        return new JSONArray(stringResponse);
    }

}
