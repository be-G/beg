package beg.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import beg.widget.EditTextValidated;
import beg.widget.EditTextValidatedName;
import beg.widget.EditTextValidatedPassword;

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
        //TODO to implement login to web service
        setUserAsLogged();
        finish();
    }

    //TODO codice duplicato è un bel casino eliminare questo tipo di duplicazione
    private void setUserAsLogged() {
        SharedPreferences.Editor editor = getSharedPreferences("Preferences", MODE_PRIVATE).edit();
        editor.putString("LOGGED", "YES");
        editor.commit();
    }
}