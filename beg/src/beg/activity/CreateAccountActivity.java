package beg.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import beg.web_request.CreateAccountTask;
import beg.widget.EditTextValidated;
import beg.widget.TextViewError;
import org.json.JSONException;
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

                    showProgressDialog();

                    new CreateAccountTask(getName(), getMail(), getPassword()) {

                        @Override
                        public void onFailure() {
                            Log.d("Debug", "onFailure");
                            //manageTextViewError(getString(R.string.createaccount_failure));
                            hideProgressDialog();
                        }

                        @Override
                        protected void onPostExecute(Object o) {
                            super.onPostExecute(o);

                            hideProgressDialog();

                            if(o == null){
                                getErrorTextView().manageTextViewError(getString(R.string.createaccount_error));
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

    private TextViewError getErrorTextView() {
        return (TextViewError)findViewById(R.id.createaccount_textview_error);
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

        try {

            editor.putString("MAIL",o.getString("mail")+"");
            editor.putString("DESCRIPTION","new to beg");
            editor.putString("STATE","1");
            editor.putString("NAME",o.getString("name")+"");

        } catch (JSONException e) {
            Log.e("Error","JSONExc in setUserAsLogged");
        }

        editor.commit();

    }

}