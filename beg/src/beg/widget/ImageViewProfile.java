package beg.widget;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;

public abstract class ImageViewProfile extends ImageView {

    private static Context context;

    public ImageViewProfile(Context context) {
        super(context);

        this.context = context;

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isEmpty()) {
                    pickPhoto();
                }
            }
        });
    }

    protected abstract void pickPhoto();

    private boolean isEmpty() {
        return this.getDrawable() == null;
    }
}
