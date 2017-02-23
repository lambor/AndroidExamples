package com.joker.test.androidexamples.ch06;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-2-8.
 */

public class Ch06_5_2Activity extends AppCompatActivity implements View.OnClickListener {

    public static void start(Context context) {
        context.startActivity(new Intent(context,Ch06_5_2Activity.class));
    }


    private Bitmap orignalBm;



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change:
                getMatrix();
                setImageMatrix();
                break;
            case R.id.reset:
                initMatrix();
                getMatrix();
                setImageMatrix();
                break;
        }
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
    private GridLayout mGroup;
    private EditText[] mEdts;
    private Button btnChange,btnReset;


    private int mEditWidth;
    private int mEditHeight;

    private float[] mColorMatrix = new float[20];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch06_5_2);

        bitmapImg = (ImageView) findViewById(R.id.bitmapImg);
        orignalBm = ((BitmapDrawable) bitmapImg.getDrawable()).getBitmap();

        mGroup = (GridLayout) findViewById(R.id.group);
        mGroup.post(new Runnable() {
            @Override
            public void run() {
                Log.e("Ch06_5_2Activity","width:"+mGroup.getWidth()+" height:"+mGroup.getHeight());
                mEditWidth = mGroup.getWidth()/5;
                mEditHeight = mGroup.getHeight()/4;
                addEdts();
                initMatrix();
            }
        });

        btnChange = (Button) findViewById(R.id.change);
        btnReset = (Button) findViewById(R.id.reset);
        btnChange.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    private void addEdts() {
        mEdts = new EditText[20];
        for(int i=0;i<20;i++) {
            EditText editText = new EditText(Ch06_5_2Activity.this);
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            mEdts[i] = editText;
            mGroup.addView(editText,mEditWidth,mEditHeight);
        }
    }

    private void initMatrix() {
        for(int i=0;i<20;i++) {
            if(i%6 == 0) {
                mEdts[i].setText(String.valueOf(1));
            } else {
                mEdts[i].setText(String.valueOf(0));
            }
        }
    }

    private void getMatrix() {
        for(int i=0;i<20;i++) {
            mColorMatrix[i] = Float.valueOf(mEdts[i].getText().toString());
        }
    }

    private void setImageMatrix() {
        Bitmap bitmap = Bitmap.createBitmap(orignalBm.getWidth(),orignalBm.getHeight(),Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(mColorMatrix);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(orignalBm,0,0,paint);
        bitmapImg.setImageBitmap(bitmap);
    }
}
