package com.anwesome.ui.touchyfilterdemo;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.anwesome.ui.touchyfilter.TouchyFilterMode;
import com.anwesome.ui.touchyfilter.TouchyFilterUtil;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imageView = (ImageView)findViewById(R.id.im_view);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TouchyFilterUtil.applyFilter(MainActivity.this,imageView, TouchyFilterMode.RED);
            }
        });
    }
}
