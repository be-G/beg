package beg.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import beg.widget.EditTextValidated;
import beg.widget.EditTextValidatedName;
import beg.widget.EditTextValidatedPassword;

public class LoginActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        findViewById(R.id.login_button_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getPasswordEditText().validate(getPasswordEditText(),false) & getNameEditText().validate(getNameEditText(),false)){
                    Log.d("DEBUG!!", "validation ok");

                    login();
                }
            }
        });

    }

    private EditTextValidated getPasswordEditText() {
        return (EditTextValidatedPassword)findViewById(R.id.login_editText_password);
    }

    private EditTextValidated getNameEditText() {
        return (EditTextValidatedName)findViewById(R.id.login_editText_name);
    }

    private void login() {

        //TODO to implement login to web service
        setUserAsLogged();
        startActivity(new Intent(this,MapActivity.class));
        finish();
    }

    private void setUserAsLogged() {
        SharedPreferences.Editor editor = getSharedPreferences("Preferences",MODE_PRIVATE).edit();
        editor.putString("LOGGED", "YES");
        editor.commit();
    }


}