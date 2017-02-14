package com.joker.test.androidexamples.ch03;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by lambor on 17-2-14.
 */

public class Ch03_8FrameB extends FrameLayout {

    private static final String TAG = "Ch03_8FrameB";

    public Ch03_8FrameB(Context context) {
        super(context);
    }

    public Ch03_8FrameB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Ch03_8FrameB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG,"onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"onTouchEvent");
        return super.onTouchEvent(event);
    }
}
