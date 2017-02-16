package com.joker.test.androidexamples.ch05;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;

import com.joker.test.androidexamples.Utils;

/**
 * Created by lambor on 17-2-16.
 */

public class Ch05_2_1DragView extends TextView {
    public Ch05_2_1DragView(Context context) {
        super(context);
    }

    public Ch05_2_1DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Ch05_2_1DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    int lastX;
    int lastY;

    int touchSlop;

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
                if(Math.abs(offsetX)<touchSlop) offsetX = 0;
                if(Math.abs(offsetY)<touchSlop) offsetY = 0;
                layout(getLeft()+offsetX,getTop()+offsetY,
                        getRight()+offsetX,getBottom()+offsetY);
                lastX = x;
                lastY = y;
                break;
            default:
                return super.onTouchEvent(event);
        }
        return true;
    }
}
