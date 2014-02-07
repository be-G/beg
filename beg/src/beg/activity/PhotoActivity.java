package beg.activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import beg.widget.ImageViewPhoto;

public class PhotoActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.photo);

        findViewById(R.id.photo_button_gotomap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PhotoActivity.this,MapActivity.class));
                finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (data != null){

            //TODO rifattorizzare

            if(getFirstPhoto().isPhotoSelected()){
                getFirstPhoto().setImageURI(data.getData());
                getFirstPhoto().setPhotoSelected(false);
            }else if(getSecondPhoto().isPhotoSelected()){
                getSecondPhoto().setImageURI(data.getData());
                getSecondPhoto().setPhotoSelected(false);
            }else if((getThirdPhoto()).isPhotoSelected()){
                getThirdPhoto().setImageURI(data.getData());
                getThirdPhoto().setPhotoSelected(false);
            }else if(getFourthPhoto().isPhotoSelected()){
                getFourthPhoto().setImageURI(data.getData());
                getFourthPhoto().setPhotoSelected(false);
            }
        }

    }

    private ImageViewPhoto getFirstPhoto() {
        return ((ImageViewPhoto)findViewById(R.id.photo_image_1));
    }

    private ImageViewPhoto getSecondPhoto() {
        return ((ImageViewPhoto)findViewById(R.id.photo_image_2));
    }

    private ImageViewPhoto getThirdPhoto() {
        return (ImageViewPhoto)findViewById(R.id.photo_image_3);
    }

    private ImageViewPhoto getFourthPhoto() {
        return ((ImageViewPhoto)findViewById(R.id.photo_image_4));
    }
}
