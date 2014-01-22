package beg.widget;

import android.content.Context;
import android.util.AttributeSet;
import beg.activity.R;

public class EditTextValidatedName extends EditTextValidated {


    public EditTextValidatedName(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean validate(EditTextValidated editTextValidateName, boolean b) {

        if(editTextValidateName.getText().toString().length() == 0 && !b){
            editTextValidateName.setError(context.getString(R.string.login_name_emptyerror));
            return false;
        }

        return true;

    }
}
