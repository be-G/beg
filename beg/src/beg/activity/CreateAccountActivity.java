package beg.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import beg.web_request.CreateAccountTask;
import beg.widget.EditTextValidated;
import org.json.JSONObject;

public class CreateAccountActivity extends BegActivity {

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.create_account);

        actionBar.hide();

        findViewById(R.id.account_createaccount_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isPasswordConfirmed() & getEditTextValidatedName().validate(false) & getEditTextValidatedEmail().validate(false)) {

                    //TODO check connection before, passare hashmap al costruttore CreateAccountTask

                    new CreateAccountTask(getName(), getMail(), getPassword()) {

                        @Override
                        public void onLoginFailure() {
                            Log.d("Debug","onLoginFailure");
                            //manageTextViewError(getString(R.string.createaccount_failure));
                        }

                        @Override
                        protected void onPostExecute(Object o) {
                            super.onPostExecute(o);

                            if(o == null){
                                manageTextViewError(getString(R.string.createaccount_error));
                            } else {
                                setUserAsLogged((JSONObject) o);
                                goToWelcomeActivity();
                                finish();
                            }
                        }
                    }.execute();

                }
            }
        });

    }

    //TODO Generalizzare in un widget di errore cosi da togliere la duplicazione nella login
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
        return (TextView)findViewById(R.id.createaccount_textview_error);
    }

    private void goToWelcomeActivity() {
        startActivity(new Intent(this,WelcomeActivity.class));
    }

    public boolean isPasswordConfirmed() {

        if(!getEditTextValidatedPassword().validate(false) | !isConfirmPasswordEqualsThanPassword()){
            getEditTextValidatedConfirmPassword().setError(getString(R.string.account_confirmpassword_error));
            return false;
        }

        return true;
    }

    private boolean isConfirmPasswordEqualsThanPassword() {

        return getConfirmPassword().equals(getPassword());
    }

    private String getName() {
        return getEditTextValidatedName().getText()+"";
    }

    public String getMail() {
        return getEditTextValidatedEmail().getText()+"";
    }

    private String getPassword() {
        return getEditTextValidatedPassword().getText()+"";
    }

    private String getConfirmPassword() {
        return getEditTextValidatedConfirmPassword().getText()+"";
    }

    private EditTextValidated getEditTextValidatedName(){
        return getEditTextValidetedById(R.id.account_editText_name);
    }

    private EditTextValidated getEditTextValidatedConfirmPassword() {
        return getEditTextValidetedById(R.id.account_editText_confirmpassword);
    }


    private EditTextValidated getEditTextValidatedEmail() {
        return getEditTextValidetedById(R.id.account_editText_email);
    }

    private EditTextValidated getEditTextValidatedPassword() {

        return getEditTextValidetedById(R.id.account_editText_password);
    }

    private EditTextValidated getEditTextValidetedById(int id) {
        return (EditTextValidated)findViewById(id);
    }

    //TODO codice duplicato
    private void setUserAsLogged(JSONObject o) {
        SharedPreferences.Editor editor = getSharedPreferences("Preferences", MODE_PRIVATE).edit();
        editor.putString("LOGGED", "YES");
        editor.putString("MAIL","");
        editor.putString("DESCRIPTION","");
        editor.putString("STATE","");
        editor.putString("NAME","");
        editor.commit();
    }

}