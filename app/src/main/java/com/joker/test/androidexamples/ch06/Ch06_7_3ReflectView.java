package com.joker.test.androidexamples.ch06;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-2-27.
 */

public class Ch06_7_3ReflectView extends View {
    public Ch06_7_3ReflectView(Context context) {
        this(context,null);
    }

    public Ch06_7_3ReflectView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Ch06_7_3ReflectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    Bitmap mSrcBitmap,mRefBitmap;
    Paint mPaint;
    PorterDuffXfermode mXfermode;

    private void init(Context context) {
        mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Matrix matrix = new Matrix();
        matrix.setScale(1F,-1F);
        mRefBitmap = Bitmap.createBitmap(mSrcBitmap,0,0,mSrcBitmap.getWidth(),mSrcBitmap.getHeight(),matrix,true);
        mPaint = new Paint();
        mPaint.setShader(new LinearGradient(0,mSrcBitmap.getHeight(),
                0,mSrcBitmap.getHeight()+mSrcBitmap.getHeight()/4,0XDDFFFFFF,0X10FFFFFF, Shader.TileMode.CLAMP));
        mXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(mSrcBitmap,0,0,null);
        int layerId = canvas.saveLayer(0,mSrcBitmap.getHeight(),mRefBitmap.getWidth(),mSrcBitmap.getHeight()*2,null,Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(mRefBitmap,0,mSrcBitmap.getHeight(),null);
        mPaint.setXfermode(mXfermode);
        canvas.drawRect(0,mSrcBitmap.getHeight(),mRefBitmap.getWidth(),mSrcBitmap.getHeight()*2,mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }
}
