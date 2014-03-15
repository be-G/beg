package beg.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import beg.web_request.LoginTask;
import beg.widget.EditTextValidated;
import beg.widget.EditTextValidatedName;
import beg.widget.EditTextValidatedPassword;
import beg.widget.TextViewError;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends BegActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        findViewById(R.id.login_button_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(getPasswordEditText().validate(false) & getNameEditText().validate(false)){
                    login();
                }
            }
        });

        findViewById(R.id.login_createaccount_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,CreateAccountActivity.class));
                finish();
            }
        });

        actionBar.hide();
    }

    private void login() {

        //TODO check connection before, passare hashMap al costruttore LoginTask

        new LoginTask(getNameEditText().getText() + "", getPasswordEditText().getText() + "") {

            @Override
            public void onLoginFailure() {
                Log.d("DEBUG","onLoginFailure");
                //manageTextViewError(getString(R.string.login_failure));
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);

                if(o == null){
                   getErrorTextView().manageTextViewError(getString(R.string.login_error));
                } else {
                   setUserAsLogged((JSONObject) o);
                   finish();
                }
            }
        }.execute();
    }

    private EditTextValidated getPasswordEditText() {
        return (EditTextValidatedPassword)findViewById(R.id.login_editText_password);
    }

    private EditTextValidated getNameEditText() {
        return (EditTextValidatedName)findViewById(R.id.login_editText_name);
    }

    private TextViewError getErrorTextView() {
        return (TextViewError)findViewById(R.id.login_textview_error);
    }

    private void setUserAsLogged(JSONObject resp) {
        SharedPreferences.Editor editor = getSharedPreferences("Preferences", MODE_PRIVATE).edit();
        editor.putString("LOGGED", "YES");

        try {
            editor.putString("MAIL",resp.getString("mail")+"");
            editor.putString("DESCRIPTION",resp.getString("description")+"");
            editor.putString("STATE",resp.getString("state"+""));
            editor.putString("NAME",resp.getString("name")+"");
        } catch (JSONException e) {
            Log.e("Error","JSONExc in setUserAsLogged");
        }


        editor.commit();
    }

}