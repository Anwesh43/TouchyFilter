package com.anwesome.ui.touchyfilter;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by anweshmishra on 17/01/17.
 */
public class TouchyFilter {
    private Activity activity;
    private ImageView imageView;
    private FilterAnimationCompleteListener filterAnimationCompleteListener;
    private TouchyFilter(Activity activity, ImageView imageView) {
        this.activity = activity;
        this.imageView = imageView;
    }
    public void setOnFilterAnimationCompleteListener(FilterAnimationCompleteListener filterAnimationCompleteListener) {
        this.filterAnimationCompleteListener = filterAnimationCompleteListener;
    }
    public void applyFilter(final TouchyFilterMode touchyFilterMode) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TouchyFilterUtil.applyFilter(activity,imageView,touchyFilterMode);
            }
        });
    }
    public interface FilterAnimationCompleteListener {
        void onComplete();
    }
}
