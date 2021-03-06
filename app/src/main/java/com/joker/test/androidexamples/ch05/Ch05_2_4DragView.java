package com.joker.test.androidexamples.ch05;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lambor on 17-2-16.
 */

public class Ch05_2_4DragView extends TextView {
    public Ch05_2_4DragView(Context context) {
        super(context);
    }

    public Ch05_2_4DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Ch05_2_4DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    int lastX;
    int lastY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                ((View) getParent()).scrollBy(-offsetX,-offsetY);
                Log.e("3535","left:"+getLeft());
                lastX = x;
                lastY = y;
                break;
            default:
                return super.onTouchEvent(event);
        }
        return true;
    }

}
