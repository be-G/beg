package beg.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;


public class BegActivity extends Activity {

    protected ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setBackgroundDrawable(null);

    }
}
