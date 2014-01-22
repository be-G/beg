package beg.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MapActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!isLogged()){
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        }

        setContentView(R.layout.main);

    }

    //TODO think to move to another class
    private boolean isLogged() {

        SharedPreferences pref = getSharedPreferences("Preferences",MODE_PRIVATE);
        String foo = pref.getString("LOGGED", "NO");
        return "YES".equals(foo);
    }
}