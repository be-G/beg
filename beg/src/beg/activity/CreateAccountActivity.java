package beg.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import beg.widget.EditTextValidated;

public class CreateAccountActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_account);

        findViewById(R.id.account_createaccount_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isPasswordConfirmed() & getEditTextValidatedName().validate(false) & getEditTextValidatedEmail().validate(false)) {
                    //TODO registro l'utente sul server
                    setUserAsLogged();
                    goToWelcomeActivity();
                    finish();
                }
            }
        });

    }

    private void goToWelcomeActivity() {
        startActivity(new Intent(this,WelcomeActivity.class));
    }

    private EditTextValidated getEditTextValidatedName(){
        return (EditTextValidated)findViewById(R.id.account_editText_name);
    }

    public boolean isPasswordConfirmed() {

        if(!getEditTextValidatedPassword().validate(false) | !isConfirmPasswordEqualsThanPassword()){
            getEditTextValidatedConfirmPassword().setError(getString(R.string.account_confirmpassword_error));
            return false;
        }

        return true;
    }

    private boolean isConfirmPasswordEqualsThanPassword() {

        Log.d("DEBUG!!"," Pass "+getEditTextValidatedPassword().getText()+" conf pass " +getEditTextValidatedConfirmPassword().getText()+" equal? "+(getEditTextValidatedConfirmPassword().getText()+"").equals(getEditTextValidatedPassword().getText()+""));

        return (getEditTextValidatedConfirmPassword().getText()+"").equals(getEditTextValidatedPassword().getText()+"");
    }

    private EditTextValidated getEditTextValidatedConfirmPassword() {
        return (EditTextValidated)findViewById(R.id.account_editText_confirmpassword);
    }


    private EditTextValidated getEditTextValidatedEmail() {
        return (EditTextValidated)findViewById(R.id.account_editText_email);
    }

    private EditTextValidated getEditTextValidatedPassword() {

        return (EditTextValidated)findViewById(R.id.account_editText_password);
    }

    //TODO codice duplicato
    private void setUserAsLogged() {
        SharedPreferences.Editor editor = getSharedPreferences("Preferences", MODE_PRIVATE).edit();
        editor.putString("LOGGED", "YES");
        editor.commit();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this,MapActivity.class));
    }
}