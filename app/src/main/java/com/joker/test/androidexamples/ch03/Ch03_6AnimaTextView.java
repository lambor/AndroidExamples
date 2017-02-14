package com.joker.test.androidexamples.ch03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by lambor on 17-2-10.
 */

public class Ch03_6AnimaTextView extends TextView {
    public Ch03_6AnimaTextView(Context context) {
        super(context);
    }

    public Ch03_6AnimaTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Ch03_6AnimaTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private int mViewWidth;
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;
    private float mTranslate;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if(mViewWidth > 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0,0,mViewWidth,0,new int[]{Color.BLUE,0xffffffff,Color.BLUE},null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mGradientMatrix!=null) {
            mTranslate += mViewWidth/5;
            if(mTranslate>2*mViewWidth) {
                mTranslate = -mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate,0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(100);
        }
    }
}
