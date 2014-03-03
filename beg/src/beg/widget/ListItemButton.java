package beg.widget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import beg.activity.LoginActivity;
import beg.activity.UserActivity;
import beg.model.User;

public class ListItemButton extends Button {

    private Context context;
    private User userData;

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


        Intent intent = new Intent(this.context, UserActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("User", userData);

        intent.putExtras(bundle);
        this.context.startActivity(intent);

    }

    private void goToLogin() {
        this.context.startActivity(new Intent(this.context, LoginActivity.class));
    }

    private boolean isLogged() {

        SharedPreferences pref = context.getSharedPreferences("Preferences", context.MODE_PRIVATE);
        String foo = pref.getString("LOGGED", "NO");
        return "YES".equals(foo);
    }

    public void configureButton(User user) {
        userData = user;
        this.setBackgroundResource(user.getState());
    }
}
