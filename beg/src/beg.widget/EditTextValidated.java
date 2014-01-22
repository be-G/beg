package beg.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

public abstract class EditTextValidated extends EditText {

    protected Context context;

    public EditTextValidated(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;

        this.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View view, boolean b) {

                validate((EditTextValidated) view, b);
            }
        });

    }


    public abstract boolean validate(EditTextValidated view, boolean b);

}
