package com.joker.test.androidexamples.ch03;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lambor on 17-2-8.
 * ch03_2 example
 */

public class Ch03_2View extends View {
    public Ch03_2View(Context context) {
        super(context);
    }

    public Ch03_2View(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Ch03_2View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
            result = 200;
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
            result = 200;
            if(specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result,specSize);
            }
        }
        return result;
    }
}

