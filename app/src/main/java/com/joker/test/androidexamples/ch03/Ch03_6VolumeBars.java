package com.joker.test.androidexamples.ch03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.MalformedJsonException;
import android.view.View;

/**
 * Created by lambor on 17-2-10.
 */

public class Ch03_6VolumeBars extends View {

    private int mRectCount = 5;

    private int mWidth;
    private int mHeight;

    private int mRectWidth;
    private int mRectHeight;

    int offset = 2;

    private LinearGradient mLinearGradient;
    private Paint mPaint;

    public Ch03_6VolumeBars(Context context) {
        super(context);
    }

    public Ch03_6VolumeBars(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Ch03_6VolumeBars(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(int i=0;i<mRectCount;i++) {
            float currentHeight = (float) (mRectHeight* Math.random());
            canvas.drawRect(
                    (float)(mWidth*0.4/2+mRectWidth*i+offset),
                    currentHeight,
                    (float) (mWidth*0.4/2+mRectWidth*(i+1)),
                    mRectHeight,
                    mPaint
            );
        }

        postInvalidateDelayed(300);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();

        mRectHeight = mHeight;
        mRectWidth = (int) ((mWidth-2*mWidth*0.4/2+offset)/mRectCount);

        mLinearGradient = new LinearGradient(
                0,
                0,
                mRectWidth,
                mRectHeight,
                Color.YELLOW,
                Color.BLUE,
                Shader.TileMode.CLAMP
                );
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setShader(mLinearGradient);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec),measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if(specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 400;
            if(specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result,specSize);
            }
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if(specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 400;
            if(specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result,specSize);
            }
        }
        return result;
    }
}
