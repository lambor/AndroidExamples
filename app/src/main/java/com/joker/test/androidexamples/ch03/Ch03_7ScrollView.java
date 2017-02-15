package com.joker.test.androidexamples.ch03;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import com.joker.test.androidexamples.Utils;

/**
 * Created by lambor on 17-2-13.
 */

public class Ch03_7ScrollView extends ViewGroup {

    private int mScreenHeight;

    public Ch03_7ScrollView(Context context) {
        this(context,null);
    }

    public Ch03_7ScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Ch03_7ScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScreenHeight = Utils.screenHeight((Activity) getContext());
        mScroller = new Scroller(context);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        mlp.height = mScreenHeight*childCount;
        setLayoutParams(mlp);
        for(int i=0;i<childCount;i++) {
            View child = getChildAt(i);
            if(child.getVisibility() != GONE) {
                child.layout(l,i*mScreenHeight,r,(i+1)*mScreenHeight);
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //因为宽高都为match_parent,所以使用super.onMeasure就行
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for(int i=0;i<count;i++) {
            View childView = getChildAt(i);
            measureChild(childView,widthMeasureSpec,heightMeasureSpec);
        }
    }

    float mLastY;
    float mStart;
    float mEnd;
    Scroller mScroller;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float y = event.getY();

        switch (event.getAction()) {
            /**
             * 内容随手势上下滑动
             */
            case MotionEvent.ACTION_DOWN:
                mLastY = y;
                mStart = getScrollY();
                break;
            case MotionEvent.ACTION_MOVE:
                if(!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                int dy = (int) (mLastY - y);
                //getScrollY 返回的是最上边(top edge)超出显示框(frame)的长度
                //下拉到头
                if(getScrollY()<0) {
                    setScrollY(0);
                    dy = 0;
                }
                //上拉到头
                if(getScrollY()>getHeight()-mScreenHeight) {
                    setScrollY(getHeight()-mScreenHeight);
                    dy = 0;
                }
                scrollBy(0,dy);
                mLastY = y;
                break;

            /**
             * 内容黏性滑动,
             * 在停止手势后,根据自己所处的位置,进行向上或者向下的滑动,而将一个子内容完全显示
             */
            case MotionEvent.ACTION_UP:
                mEnd = getScrollY();
                int dScrollY = (int) (mEnd - mStart);
                if(dScrollY>0) { //上拉
                    if(dScrollY<mScreenHeight/3) { //上拉太少
                        mScroller.startScroll(0,getScrollY(),0,-dScrollY);
                    } else {
                        mScroller.startScroll(0,getScrollY(),0,mScreenHeight - dScrollY);
                    }
                } else { //下拉
                    if(-dScrollY<mScreenHeight/3) {//下拉太少
                        mScroller.startScroll(0,getScrollY(),0,-dScrollY);
                    } else {
                        mScroller.startScroll(0,getScrollY(),0,-mScreenHeight-dScrollY);
                    }
                }
                break;

            default:
                return super.onTouchEvent(event);
        }
        postInvalidate();
        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.computeScrollOffset()) {
            scrollTo(0,mScroller.getCurrY());
            postInvalidate();
        }
    }
}
