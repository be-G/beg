package beg.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class ImageViewPhoto extends ImageView{
    private boolean isPhotoSelected = false;

    public ImageViewPhoto(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                isPhotoSelected = true;

                ((Activity) getContext()).startActivityForResult(new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 1);
            }
        });

    }


    public boolean isPhotoSelected(){
        return isPhotoSelected;
    }

    public void setPhotoSelected(boolean photoSelected) {
        this.isPhotoSelected = photoSelected;
    }

}
