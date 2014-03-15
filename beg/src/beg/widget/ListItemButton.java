package beg.widget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import beg.activity.LoginActivity;
import beg.activity.UserDetailActivity;
import beg.model.User;

import java.util.ArrayList;

public class ListItemButton extends Button {

    private Context context;
    private ArrayList<User> userData;
    private int position;

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

        Intent intent = new Intent(this.context, UserDetailActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("Users", userData);
        bundle.putInt("ItemPos",position);

        intent.putExtras(bundle);
        this.context.startActivity(intent);

    }

    private void goToLogin() {
        this.context.startActivity(new Intent(this.context, LoginActivity.class));
    }

    private boolean isLogged() {

        SharedPreferences pref = context.getSharedPreferences("Preferences", context.MODE_PRIVATE);
        return "YES".equals(pref.getString("LOGGED", "NO"));
    }

    public void configureButton(ArrayList<User> users, int pos) {
        this.userData = users;
        this.position = pos;
        this.setBackgroundResource(users.get(pos).getState());
    }
}
