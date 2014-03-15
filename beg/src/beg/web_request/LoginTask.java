package beg.web_request;

import org.apache.http.HttpResponse;

public abstract class LoginTask extends AsyncBegTask{

    private String name;
    private String pass;

    public LoginTask (String name, String pass)
    {
        this.name = name;
        this.pass = pass;
    }

    @Override
    protected Object doInBackground(Object[] params) {

        try {

            HttpResponse response = executeHttpGet(baseUrl + "/login" + "?name=" + name + "&password=" + pass);

            String stringResponse = parseResponseToString(response);

            if(isLoginSuccessfull(stringResponse)){
                resp = getJsonObjectFromString(stringResponse);
            }

        } catch (Exception e) {
            onLoginFailure();
        }

        return resp;
    }

    private boolean isLoginSuccessfull(String stringResponse) {
        return null != stringResponse && !"null".equals(stringResponse);
    }



}
