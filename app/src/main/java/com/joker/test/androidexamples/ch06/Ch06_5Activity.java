package com.joker.test.androidexamples.ch06;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-2-8.
 */

public class Ch06_5Activity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    public static void start(Context context) {
        context.startActivity(new Intent(context,Ch06_5Activity.class));
    }

    private float mHue;
    private float mSaturation;
    private float mLum;

    private Bitmap orignalBm;

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seekHue:
                mHue = (progress - 50) * 1.0F/50*180;
                break;
            case R.id.seekSaturation:
                mSaturation = progress * 1.0F/50;
                break;
            case R.id.seekLum:
                mLum = progress * 1.0f/50;
                break;
        }
        bitmapImg.setImageBitmap(ImageHelper.handleImageEffect(orignalBm,mHue,mSaturation,mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    static class ImageHelper {
        public static Bitmap handleImageEffect(Bitmap bm,float hue,float saturation, float lum) {
            Bitmap bmp = Bitmap.createBitmap(bm.getWidth(),bm.getHeight(),Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bmp);
            Paint paint = new Paint();

            ColorMatrix hueMatrix = new ColorMatrix();
            hueMatrix.setRotate(0,hue);
            hueMatrix.setRotate(1,hue);
            hueMatrix.setRotate(2,hue);

            ColorMatrix saturationMatrix = new ColorMatrix();
            saturationMatrix.setSaturation(saturation);

            ColorMatrix lumMatrix = new ColorMatrix();
            lumMatrix.setScale(lum,lum,lum,1);

            ColorMatrix imageMatrix = new ColorMatrix();
            imageMatrix.postConcat(hueMatrix);
            imageMatrix.postConcat(saturationMatrix);
            imageMatrix.postConcat(lumMatrix);

            paint.setColorFilter(new ColorMatrixColorFilter(imageMatrix));
            canvas.drawBitmap(bm,0,0,paint);
            return bmp;
        }
    }

    private ImageView bitmapImg;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch06_5);

        bitmapImg = (ImageView) findViewById(R.id.bitmapImg);
        orignalBm = ((BitmapDrawable) bitmapImg.getDrawable()).getBitmap();

        ((SeekBar) findViewById(R.id.seekHue)).setOnSeekBarChangeListener(this);
        ((SeekBar) findViewById(R.id.seekSaturation)).setOnSeekBarChangeListener(this);
        ((SeekBar) findViewById(R.id.seekLum)).setOnSeekBarChangeListener(this);
    }
}
