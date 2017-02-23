package com.joker.test.androidexamples.ch06;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by lambor on 17-2-23.
 */

public class Ch06_6WaveImageView extends ImageView {
    public Ch06_6WaveImageView(Context context) {
        this(context,null);
    }

    public Ch06_6WaveImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Ch06_6WaveImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    Bitmap orignalBitmap;

    final int WIDTH = 20;
    final int HEIGHT = 20;

    float[] orig;
    float[] verts;

    private void init() {
        orignalBitmap = ((BitmapDrawable) getDrawable()).getBitmap();
        k=0;

        orig = new float[2*(HEIGHT+1)*(WIDTH+1)];
        verts= new float[2*(HEIGHT+1)*(WIDTH+1)];

        final int bitmapHeight = orignalBitmap.getHeight();
        final int bitmapWidth = orignalBitmap.getWidth();
        int index = 0;
        for(int y=0;y<=HEIGHT;y++) {
            float fy = bitmapHeight * y/HEIGHT;
            for(int x=0;x<=WIDTH;x++) {
                float fx = bitmapWidth * x/WIDTH;
                orig[index * 2 + 0] = verts[index * 2 + 0] = fx;
                orig[index * 2 + 1] = verts[index * 2 + 1] = fy+100;
                index += 1;
            }
        }
    }


    private float k;
    final float A = 0.5f;
    private void flagWave() {
        for(int j=0;j<=HEIGHT;j++) {
            for(int i=0;i<=WIDTH;i++) {
                verts[(j*(WIDTH+1)+i)*2+0] += 0;
                float offsetY = (float)Math.sin((float)i/WIDTH*2*Math.PI + Math.PI * k);
                verts[(j*(WIDTH+1)+i)*2+1] += offsetY*A;
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        flagWave();
        k+=0.1f;
        canvas.drawBitmapMesh(orignalBitmap,WIDTH,HEIGHT,verts,0,null,0,null);
        postInvalidateDelayed(5);
    }
}
