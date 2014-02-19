package beg.widget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import beg.activity.LoginActivity;
import beg.activity.UserActivity;

public class ListItemButton extends Button {

    private Context context;

    public ListItemButton(Context context, AttributeSet attrs) {
        super(context,attrs);

        this.context = context;

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isLogged()) {
                    goToLogin();
                } else {
                    goToUserDetail();
                }
            }
        });

    }

    private void goToUserDetail() {
        this.context.startActivity(new Intent(this.context, UserActivity.class));
    }

    private void goToLogin() {
        this.context.startActivity(new Intent(this.context, LoginActivity.class));
    }

    private boolean isLogged() {

        SharedPreferences pref = context.getSharedPreferences("Preferences", context.MODE_PRIVATE);
        String foo = pref.getString("LOGGED", "NO");
        return "YES".equals(foo);
    }

}
