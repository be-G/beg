package beg.activity;


import android.os.Bundle;
import android.widget.TextView;
import beg.model.User;

public class UserActivity extends BegActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.user);

        User user = (User) getIntent().getExtras().getSerializable("User");

        ((TextView) findViewById(R.id.user_name_text)).setText(user.getName());
        ((TextView) findViewById(R.id.user_description_text)).setText(user.getDescription());
        findViewById(R.id.user_marble_imageView).setBackgroundResource(user.getColor());
        ((TextView) findViewById(R.id.user_distance_text)).setText(user.getDistance()+" m");

    }
}
