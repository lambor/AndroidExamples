package com.joker.test.androidexamples.ch05;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.solver.widgets.ConstraintWidget;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joker.test.androidexamples.Utils;

import java.lang.reflect.Field;

/**
 * Created by lambor on 17-2-16.
 */

public class Ch05_2_1DragView extends TextView {

    private static final String TAG = "Ch05_2_1DragView";

    public Ch05_2_1DragView(Context context) {
        this(context,null);
    }

    public Ch05_2_1DragView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Ch05_2_1DragView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.e(TAG,"on constructor.");
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Log.e(TAG,"onFinishInflate.");
        init();
    }

    private void init() {
        touchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if(layoutParams instanceof  ConstraintLayout.LayoutParams) {
//            lp = (ConstraintLayout.LayoutParams) layoutParams;
        }
    }

    int lastX;
    int lastY;

    int posX;
    int posY;

    int touchSlop;

    /**
     * BUG?
     * 在Ch05_2_3DragView使用setLayoutParams改变自己位置,导致本View恢复到原来的位置
     *
     * 原因:
     * setLayoutParams导致parent groupview---ConstraintLayout 重新layout child view.
     * 然而本view的拖动实现并没有影响到自己的layout params,所以在重新layout时,仍以未变的layoutparam.
     */

//    ConstraintLayout.LayoutParams lp;

//    private void updateSelfLP() throws NoSuchFieldException, IllegalAccessException {
//        if(lp != null) {
//            Field field = ConstraintLayout.LayoutParams.class.getField("widget");
//            field.setAccessible(true);
//            ConstraintWidget widget = (ConstraintWidget) field.get(lp);
//            widget.setDrawX(lastX);
//            widget.setDrawY(lastY);
//            field.set(lp,widget);
//        }
//    }

//    @Override
//    public void layout(int l, int t, int r, int b) {
//        if(selfLayout !=null && !selfLayout) {
//            r = posX + (r - l);
//            b = posY + (b - t);
//            l = posX;
//            t = posY;
//        }
//        super.layout(l, t, r, b);
//    }

//    private Boolean selfLayout = null;

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
//                selfLayout = true;
                posX = getLeft()+offsetX;
                posY = getTop()+offsetY;
                layout(getLeft()+offsetX,getTop()+offsetY,
                        getRight()+offsetX,getBottom()+offsetY);
//                selfLayout = false;
                lastX = x;
                lastY = y;

//                try {
//                    updateSelfLP();
//                } catch (NoSuchFieldException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
                break;
            default:
                return super.onTouchEvent(event);
        }
        return true;
    }
}
