package com.joker.test.androidexamples.ch05;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lambor on 17-2-16.
 */

public class Ch05_2_3DragView extends TextView {
    public Ch05_2_3DragView(Context context) {
        super(context);
    }

    public Ch05_2_3DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Ch05_2_3DragView(Context context, AttributeSet attrs, int defStyleAttr) {
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
                offsetLayoutParams(offsetX,offsetY);
                lastX = x;
                lastY = y;
                break;
            default:
                return super.onTouchEvent(event);
        }
        return true;
    }

    public void offsetLayoutParams(int offsetX,int offsetY) {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) getLayoutParams();
        lp.leftMargin = getLeft()+offsetX;
        lp.topMargin = getTop()+offsetY;
        setLayoutParams(lp);
    }
}
