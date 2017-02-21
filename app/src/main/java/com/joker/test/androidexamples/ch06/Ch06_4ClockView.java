package com.joker.test.androidexamples.ch06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lambor on 17-2-21.
 */

public class Ch06_4ClockView extends View {
    public Ch06_4ClockView(Context context) {
        this(context,null);
    }

    public Ch06_4ClockView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Ch06_4ClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initDraw();
    }

    private Paint mPaintCircle;
    private Paint mPaintDegree;

    private Paint mPaintHour;
    private Paint mPaintMinute;

    private void initDraw() {
        mPaintCircle = new Paint();
        mPaintCircle.setStyle(Paint.Style.STROKE);
        mPaintCircle.setAntiAlias(true);
        mPaintCircle.setStrokeWidth(5);

        mPaintDegree = new Paint();

        mPaintHour = new Paint();
        mPaintHour.setStrokeWidth(20);
        mPaintMinute = new Paint();
        mPaintMinute.setStrokeWidth(10);
    }


    /**
     * mWidth <= mHeight
     */
    private int mWidth;
    private int mHeight;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mWidth/2,mHeight/2,mWidth/2,mPaintCircle);

        mPaintDegree.setStrokeWidth(3);
        for(int i=0;i<24;i++) {
            if(i == 0 || i == 6 || i == 12 || i == 18) {
                mPaintDegree.setStrokeWidth(5);
                mPaintDegree.setTextSize(30);
                canvas.drawLine(mWidth/2,mHeight/2-mWidth/2,mWidth/2,mHeight/2-mWidth/2+60,mPaintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree,mWidth/2-mPaintDegree.measureText(degree)/2,mHeight/2-mWidth/2+90,mPaintDegree);
            } else {
                mPaintDegree.setStrokeWidth(3);
                mPaintDegree.setTextSize(15);
                canvas.drawLine(mWidth/2,mHeight/2-mWidth/2,mWidth/2,mHeight/2-mWidth/2+30,mPaintDegree);
                String degree = String.valueOf(i);
                canvas.drawText(degree,mWidth/2-mPaintDegree.measureText(degree)/2,mHeight/2-mWidth/2+60,mPaintDegree);
            }
            canvas.rotate(15,mWidth/2,mHeight/2);
        }

        canvas.save();
        canvas.translate(mWidth/2,mHeight/2);
        canvas.drawLine(0,0,100,100,mPaintHour);
        canvas.drawLine(0,0,100,200,mPaintMinute);
        canvas.restore();
    }
}
