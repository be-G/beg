package beg.web_request;

import org.apache.http.HttpResponse;

public abstract class CreateAccountTask extends AsyncBegTask{

    private String name;
    private String mail;
    private String password;
    private String standardDescription = "new%20to%20beg";

    public CreateAccountTask(String name, String mail, String password) {
        this.name = name;
        this.mail = mail;
        this.password = password;
    }

    @Override
    protected Object doInBackground(Object[] params) {

        try {


            HttpResponse response = executeHttpGet(baseUrl + "/createaccount"+"?name="+name + "&password=" +password + "&mail=" + mail + "&description="+standardDescription+"&state=1");
            String stringResponse = parseResponseToString(response);

            if(isCreateAccountSuccessfull(stringResponse)){
                resp = getJsonObjectFromString(stringResponse);
            }

        } catch (Exception e) {
            onLoginFailure();
        }

        return resp;
    }

    private boolean isCreateAccountSuccessfull(String stringResponse) {
        return null != stringResponse && !"null".equals(stringResponse);
    }
}
