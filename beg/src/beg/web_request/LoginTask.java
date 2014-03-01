package beg.web_request;


import android.os.AsyncTask;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class LoginTask extends AsyncTask{

    private String name;
    private String pass;
    private final String baseUrl = "http://10.0.0.2:9292/";

    public LoginTask (String name, String pass )
    {
        super();
        this.name = name;
        this.pass = pass;
    }

    @Override
    protected Object doInBackground(Object[] params) {

        JSONObject resp = null;

        HttpClient httpclient = new DefaultHttpClient();

        try {

            HttpResponse response = httpclient.execute(new HttpGet(baseUrl+"/login"+"?name="+name+"&password="+pass));

            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
            String result = reader.readLine();

            if(null != resp && !"null".equals(resp)){
                resp = new JSONObject(new JSONTokener(result));
            }

        } catch (Exception e) {
            onLoginFailure();
        }

        return resp;
    }

    public abstract void onLoginFailure();

}
