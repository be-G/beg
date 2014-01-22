package beg.widget;

import android.content.Context;
import android.util.AttributeSet;
import beg.activity.R;

public class EditTextValidatedPassword extends EditTextValidated {


    public EditTextValidatedPassword(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean validate(EditTextValidated editTextValidatePassword, boolean b) {

        if(editTextValidatePassword.getText().toString().length() == 0 && !b){
            editTextValidatePassword.setError(context.getString(R.string.login_name_emptyerror));
            return false;
        } else if(editTextValidatePassword.getText().toString().length() < 5 && !b){
            editTextValidatePassword.setError(context.getString(R.string.login_name_shorterror));
            return false;
        }

        return true;
    }
}
