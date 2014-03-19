package beg.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;


public class BegActivity extends Activity {

    protected ActionBar actionBar;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setBackgroundDrawable(null);

    }

    protected void hideProgressDialog(){
        runOnUiThread(new Runnable() {
            public void run() {
                progressDialog.hide();
            }});
    }

    protected void showProgressDialog() {
        runOnUiThread(new Runnable() {
            public void run() {
                progressDialog = ProgressDialog.show(BegActivity.this,"",getString(R.string.progress_dialog_text));
            }});
    }
}
