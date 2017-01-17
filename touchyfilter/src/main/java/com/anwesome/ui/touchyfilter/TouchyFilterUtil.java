package com.anwesome.ui.touchyfilter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import java.util.HashMap;

/**
 * Created by anweshmishra on 17/01/17.
 */
public class TouchyFilterUtil {
    private static HashMap<ImageView,Boolean> runningMap = new HashMap<>();
    public static void applyFilter(final Activity activity, final ImageView imageView, final TouchyFilterMode touchyFilterMode) {
        if(imageView!=null && (!runningMap.containsKey(imageView))) {
            runningMap.put(imageView,true);
            final Bitmap imageViewBitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
            final int h = imageViewBitmap.getHeight();
            final int max_w = imageViewBitmap.getWidth();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int w = 0,k=max_w/20;

                    while(true) {
                        final int w1 = w;
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Bitmap bitmap = Bitmap.createBitmap(imageViewBitmap.getWidth(),imageViewBitmap.getHeight(), Bitmap.Config.ARGB_8888);
                                Canvas canvas = new Canvas(bitmap);
                                int r = 0,g=0,b=0;
                                switch (touchyFilterMode) {
                                    case GREEN:
                                        g = 255;
                                        break;
                                    case RED:
                                        r = 255;
                                        break;
                                    case BLUE:
                                        b = 255;
                                        break;
                                    default:
                                        break;
                                }

                                Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
                                canvas.drawBitmap(imageViewBitmap,0,0,paint);
                                paint.setColor(Color.argb(100,r,g,b));
                                canvas.drawRect(new RectF(0,0,w1,h),paint);
                                imageView.setImageBitmap(bitmap);
                            }

                        });
                        if(w >= max_w) {
                            k = -1*Math.abs(k);
                            w = max_w;
                        }
                        else if(w <= 0 && k<0) {
                            runningMap.remove(imageView);
                            break;
                        }
                        w+=k;
                        try {
                            Thread.sleep(50);
                        }
                        catch (Exception ex) {

                        }
                    }
                }
            }).start();
        }
    }
}
