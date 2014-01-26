package beg.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class WelcomeActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.welcome);

        findViewById(R.id.welcome_button_addphoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickPhoto();
            }
        });
    }

    private void pickPhoto() {
        startActivityForResult(new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null)
            getImageView().setImageURI(data.getData());
    }

    public ImageView getImageView() {
        return (ImageView)findViewById(R.id.welcome_imageView_photo);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //TODO resize save photo on DB if you got it
        startActivity(new Intent(this,MapActivity.class));
        finish();
    }
}