package beg.web_request;

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

            String stringResponse = parseResponseToString(executeHttpGet(baseUrl + "/login" + "?name=" + name + "&password=" + pass));

            if(isLoginSuccessfull(stringResponse)){
                resp = getJsonObjectFromString(stringResponse);
            }

        } catch (Exception e) {
            onFailure();
        }

        return resp;
    }

    private boolean isLoginSuccessfull(String stringResponse) {
        return null != stringResponse && !"null".equals(stringResponse);
    }



}
