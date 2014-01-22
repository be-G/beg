package beg.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MapActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(isLogged()){
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        }

        setContentView(R.layout.main);

    }

    //TODO think to move to another class
    private boolean isLogged() {
        return getSharedPreferences("Preferences", Context.MODE_PRIVATE).getBoolean("LOGGED", false);
    }
}