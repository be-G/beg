package beg.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class ImageViewProfile extends ImageView{

    public ImageViewProfile(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                    //TODO ingrandisci immagine
            }
        });

    }

}
