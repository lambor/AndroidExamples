package com.joker.test.androidexamples.ch05;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.Scroller;
import android.widget.TextView;

/**
 * Created by lambor on 17-2-16.
 */

public class Ch05_2_5FlingView extends TextView {

    private static final String TAG = "Ch05_2_5FlingView";

    public Ch05_2_5FlingView(Context context) {
        this(context,null);
    }

    public Ch05_2_5FlingView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Ch05_2_5FlingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    int lastX;
    int lastY;


    VelocityTracker vTracker = null;
    Scroller scroller;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                if(!scroller.isFinished()) {
                    scroller.abortAnimation();
                }

                lastX = x;
                lastY = y;

                if(vTracker == null) {
                    vTracker = VelocityTracker.obtain();
                } else {
                    vTracker.clear();
                }
                vTracker.addMovement(event);
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;
                ((View) getParent()).scrollBy(-offsetX,-offsetY);
                lastX = x;
                lastY = y;

                vTracker.addMovement(event);
                break;

            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                vTracker.addMovement(event);
                vTracker.computeCurrentVelocity(1000);
                float vx = vTracker.getXVelocity();
                float vy = vTracker.getYVelocity();
                startFling(vx,vy);
                vTracker.recycle();
                vTracker = null;
                break;
            default:
                return super.onTouchEvent(event);
        }
        /**
         * computeScroll invoked in view redraw
         * and invalide() triggles redraw
         */
        invalidate();
        return true;
    }

    void startFling(float vx, float vy) {
        Log.e(TAG,"startFling");
        Log.e(TAG,"width:"+getWidth()+" height:"+getHeight());
        Log.e(TAG,"left:"+getLeft()+" top:"+getTop());
        int parentWidth = ((View) getParent()).getWidth();
        int parentHeight = ((View) getParent()).getHeight();
        int startX = getLeft() - ((View)getParent()).getScrollX();
        int startY = getTop() - ((View)getParent()).getScrollY();

        Log.e(TAG,"startX:"+startX+" startY:"+startY);
        scroller.fling(startX,startY,(int)vx,(int)vy,0,parentWidth-getWidth(),0,parentHeight-getHeight());
    }

    private void init() {
        scroller = new Scroller(getContext());
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(scroller.computeScrollOffset()) {
            Log.e(TAG,"x:"+scroller.getCurrX()+" y:"+scroller.getCurrY());
            Log.e(TAG,"V:"+scroller.getCurrVelocity());
            ((View) getParent()).scrollTo(-scroller.getCurrX(),-scroller.getCurrY());
            invalidate();
        }
    }
}
