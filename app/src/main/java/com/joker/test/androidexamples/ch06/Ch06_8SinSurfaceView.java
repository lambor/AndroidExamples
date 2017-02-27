package com.joker.test.androidexamples.ch06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by lambor on 17-2-27.
 */

public class Ch06_8SinSurfaceView extends SurfaceView implements SurfaceHolder.Callback,Runnable {

    private SurfaceHolder mHolder;
    private Canvas mCanvas;
    private boolean mIsDrawing;

    private Path mPath;
    private Paint mPaint;

    public Ch06_8SinSurfaceView(Context context) {
        this(context,null);
    }

    public Ch06_8SinSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Ch06_8SinSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mHolder = getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setKeepScreenOn(true);

        mPath = new Path();
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mIsDrawing = true;
        new Thread(this).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;
    }

    int x=0;
    int y;
    @Override
    public void run() {
        while(mIsDrawing) {
            draw();
            x+=1;
            y= (int) (100*Math.sin(x*2*Math.PI/180)+400);
            mPath.lineTo(x,y);
        }
    }

    private void draw() {
        try {
            mCanvas = mHolder.lockCanvas();
            mCanvas.drawColor(Color.WHITE);
            mCanvas.drawPath(mPath,mPaint);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(mCanvas != null) {
                mHolder.unlockCanvasAndPost(mCanvas);
                mCanvas = null;
            }
        }

    }
}
