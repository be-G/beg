package beg.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import beg.web_request.LoginTask;
import beg.widget.EditTextValidated;
import beg.widget.EditTextValidatedName;
import beg.widget.EditTextValidatedPassword;
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

    private EditTextValidated getPasswordEditText() {
        return (EditTextValidatedPassword)findViewById(R.id.login_editText_password);
    }

    private EditTextValidated getNameEditText() {
        return (EditTextValidatedName)findViewById(R.id.login_editText_name);
    }

    private void login() {

        //TODO check connection before

        new LoginTask(getNameEditText().getText() + "", getPasswordEditText().getText() + "") {

            @Override
            public void onLoginFailure() {
                manageTextViewError("onLoginFailure");
            }

            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);

                if(o == null){
                   manageTextViewError("onLoginError");
                } else {
                   setUserAsLogged((JSONObject) o);
                   startActivity(new Intent(LoginActivity.this,CreateAccountActivity.class));
                   finish();
                }
            }
        }.execute();
    }

    private void manageTextViewError(final String msg) {
                setErrorTextViewVisibility(true);
                setErrorTextViewText(msg);
    }

    private void setErrorTextViewText(String msg) {
        getErrorTextView().setText(msg);
    }

    private void setErrorTextViewVisibility(boolean isVisible) {

        getErrorTextView().setVisibility(isVisible?View.VISIBLE:View.GONE);
    }

    private TextView getErrorTextView() {
        return (TextView)findViewById(R.id.login_textview_error);
    }

    private void setUserAsLogged(JSONObject resp) {
        SharedPreferences.Editor editor = getSharedPreferences("Preferences", MODE_PRIVATE).edit();
        editor.putString("LOGGED", "YES");
        editor.putString("MAIL","");
        editor.putString("DESCRIPTION","");
        editor.putString("STATE","");
        editor.putString("NAME","");

        editor.commit();
    }

}