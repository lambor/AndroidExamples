package com.joker.test.androidexamples.ch03;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by lambor on 17-2-14.
 */

public class Ch03_8View extends View {

    private static final String TAG = "Ch03_8View";

    public Ch03_8View(Context context) {
        super(context);
    }

    public Ch03_8View(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Ch03_8View(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"onTouchEvent");
        return super.onTouchEvent(event);
    }
}
