package beg.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WelcomeActivity extends BegActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.welcome);

        findViewById(R.id.welcome_button_gotomap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.welcome_button_addphotos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this,PhotoActivity.class));
                finish();
            }
        });

        actionBar.hide();

    }

}