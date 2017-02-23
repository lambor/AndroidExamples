package com.joker.test.androidexamples.ch06;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-2-23.
 */

public class Ch06_7XfermodeView extends View {
    public Ch06_7XfermodeView(Context context) {
        this(context,null);
    }

    public Ch06_7XfermodeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Ch06_7XfermodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setSrcPaintXfermode(Xfermode mode) {
        mPaint.setXfermode(mode);
    }

    private Bitmap mBgBitmap,mFgBitmap;
    private Paint mPaint;
    private Canvas mCanvas;
    private Path mPath;

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(0xeeff0000);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(50);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPath = new Path();
        mBgBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher,new BitmapFactory.Options());
        mFgBitmap = Bitmap.createBitmap(mBgBitmap.getWidth(),mBgBitmap.getHeight(),Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mFgBitmap);
        mCanvas.drawColor(Color.GRAY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                mPath.moveTo(event.getX(),event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                mPath.lineTo(event.getX(),event.getY());
                break;
        }
        mCanvas.drawPath(mPath,mPaint);
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBgBitmap,0,0,null);
        canvas.drawBitmap(mFgBitmap,0,0,null);
    }
}
