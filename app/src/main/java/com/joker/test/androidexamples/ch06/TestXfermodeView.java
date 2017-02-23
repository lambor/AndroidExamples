package com.joker.test.androidexamples.ch06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lambor on 17-2-23.
 */

public class TestXfermodeView extends View {
    public TestXfermodeView(Context context) {
        this(context,null);
    }

    public TestXfermodeView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestXfermodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private Paint mDestPaint;
    private Paint mSrcPaint;

    private void initPaint() {
        mDestPaint = new Paint();
        mDestPaint.setStyle(Paint.Style.FILL);
        mDestPaint.setColor(Color.RED);

        mSrcPaint = new Paint();
        mSrcPaint.setStyle(Paint.Style.STROKE);
        mSrcPaint.setColor(Color.BLACK);
        mSrcPaint.setStrokeWidth(30);
        mSrcPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        int layerId = canvas.saveLayer(0, 0, canvasWidth, canvasHeight, null, Canvas.ALL_SAVE_FLAG);
        canvas.drawCircle(getWidth()/2,getHeight()/2,100,mDestPaint);
        canvas.drawCircle(getWidth()/2+50,getHeight()/2+50,80,mSrcPaint);
        canvas.restoreToCount(layerId);
    }
}
