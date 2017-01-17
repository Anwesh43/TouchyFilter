package com.anwesome.ui.touchyfilterdemo;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.anwesome.ui.touchyfilter.TouchyFilter;
import com.anwesome.ui.touchyfilter.TouchyFilterMode;
import com.anwesome.ui.touchyfilter.TouchyFilterUtil;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView = (ImageView) findViewById(R.id.im_view);
        TouchyFilter touchyFilter = TouchyFilter.newInstance(this, imageView);
        touchyFilter.setOnFilterAnimationCompleteListener(new TouchyFilter.FilterAnimationCompleteListener() {
            @Override
            public void onComplete() {
                Toast.makeText(MainActivity.this,"Green filter",Toast.LENGTH_SHORT).show();
            }
        });
        touchyFilter.applyFilter(TouchyFilterMode.GREEN);
    }
}
