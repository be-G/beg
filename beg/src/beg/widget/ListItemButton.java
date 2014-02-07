package beg.widget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import beg.activity.LoginActivity;

public class ListItemButton extends Button {

    private Context context;

    public ListItemButton(Context context, AttributeSet attrs) {
        super(context,attrs);

        this.context = context;

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
            }
        });

    }

    private void checkLogin(){
        if (!isLogged()) {
            context.startActivity(new Intent(context, LoginActivity.class));
        }
    }

    private boolean isLogged() {

        SharedPreferences pref = context.getSharedPreferences("Preferences", context.MODE_PRIVATE);
        String foo = pref.getString("LOGGED", "NO");
        return "YES".equals(foo);
    }

}
