package beg.web_request;

import org.json.JSONArray;

public abstract class UsersTask extends AsyncBegTask{

    @Override
    protected Object doInBackground(Object[] params) {

        JSONArray resp = null;

        try {

            String stringResponse = parseResponseToString(executeHttpGet(baseUrl + "/users"));

            if(isUsersSuccessfull(stringResponse)){
                resp = getJsonArrayFromString(stringResponse);
            }

        } catch (Exception e) {
            onFailure();
        }

        return resp;
    }

    private boolean isUsersSuccessfull(String stringResponse) {
        return null != stringResponse && !"null".equals(stringResponse);
    }

}
