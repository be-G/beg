package beg.web_request;


import android.os.AsyncTask;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public abstract class LoginTask extends AsyncTask{

    private String name;
    private String pass;

    public LoginTask (String name, String pass )
    {
        super();
        this.name = name;
        this.pass = pass;
    }

    @Override
    protected Object doInBackground(Object[] params) {
        String resp;

        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://10.0.0.4:9292//login"+"?name="+name+"&?password="+pass);

        try {

            HttpResponse response = httpclient.execute(httpGet);

            resp = response.getStatusLine().getReasonPhrase();

            if(resp == "OK"){
                onLoginSuccess();
            } else {
                onLoginError();
            }


        } catch (Exception e) {
            resp = "KO";
            onLoginFailure();
        }

        return resp;
    }

    protected abstract void onLoginError();
    public abstract void onLoginSuccess();
    public abstract void onLoginFailure();

}
