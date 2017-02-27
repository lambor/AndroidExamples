package com.joker.test.androidexamples.ch06;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-2-27.
 */

public class Ch06_7BitmapShaderView extends View {
    public Ch06_7BitmapShaderView(Context context) {
        this(context,null);
    }

    public Ch06_7BitmapShaderView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Ch06_7BitmapShaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    Bitmap mBitmap;
    Shader mBitmapShader;
    Paint mPaint;

    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        mBitmapShader = new BitmapShader(mBitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP);
        mPaint = new Paint();
        mPaint.setShader(mBitmapShader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(100,100,100,mPaint);
    }
}
