package com.joker.test.androidexamples.ch05;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by lambor on 17-2-16.
 */

public class Ch05_2_7DragHelperView extends FrameLayout {

    private static final String TAG = "Ch05_2_7DragHelperView";

    public Ch05_2_7DragHelperView(Context context) {
        this(context,null);
    }

    public Ch05_2_7DragHelperView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Ch05_2_7DragHelperView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private ViewDragHelper mViewDragHelper;
    private View mMenuView,mMainView;
    private int mWidth;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuView = getChildAt(0);
        mMainView = getChildAt(1);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = mMenuView.getMeasuredWidth();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    private void initView() {
        mViewDragHelper = ViewDragHelper.create(this,callback);
    }

    private ViewDragHelper.Callback callback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return mMainView == child;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            Log.e(TAG,"left:"+left);
            return left>0?Math.min(left,mWidth):0;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return 0;
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            if(mMainView.getLeft()<mWidth/2) {
                mViewDragHelper.smoothSlideViewTo(mMainView,0,0);
                ViewCompat.postInvalidateOnAnimation(Ch05_2_7DragHelperView.this);
            } else {
                mViewDragHelper.smoothSlideViewTo(mMainView,mWidth,0);
                ViewCompat.postInvalidateOnAnimation(Ch05_2_7DragHelperView.this);
            }
        }

        @Override
        public int getViewHorizontalDragRange(View child) {
            return mWidth;
        }

    };

    @Override
    public void computeScroll() {
        if(mViewDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }
}
