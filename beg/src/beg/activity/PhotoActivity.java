package beg.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import beg.widget.ImageViewProfile;

public class PhotoActivity extends Activity{

    private ImageView imageViewToPopulate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.photo);

        ((LinearLayout)findViewById(R.id.photos_layoutimage_1)).addView(new ImageViewProfile(this) {
            @Override
            protected void pickPhoto() {
                PhotoActivity.this.pickPhoto(this);

            }
        });

        ((LinearLayout)findViewById(R.id.photos_layoutimage_2)).addView(new ImageViewProfile(this) {
            @Override
            protected void pickPhoto() {
                PhotoActivity.this.pickPhoto(this);
            }
        });

        ((LinearLayout)findViewById(R.id.photos_layoutimage_3)).addView(new ImageViewProfile(this) {
            @Override
            protected void pickPhoto() {
                PhotoActivity.this.pickPhoto(this);
            }
        });

        ((LinearLayout)findViewById(R.id.photos_layoutimage_4)).addView(new ImageViewProfile(this) {
            @Override
            protected void pickPhoto() {
                PhotoActivity.this.pickPhoto(this);
            }
        });

        findViewById(R.id.photo_button_gotomap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PhotoActivity.this,MapActivity.class));
                finish();
            }
        });

    }

    private void pickPhoto(ImageView view) {

        imageViewToPopulate = view;

        startActivityForResult(new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null){
            imageViewToPopulate.setImageURI(data.getData());
        }

        imageViewToPopulate = null;

    }

}
