package com.joker.test.androidexamples.ch04;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by lambor on 17-2-15.
 */

public class Ch04_2OverScrollListView extends ListView {
    public Ch04_2OverScrollListView(Context context) {
        super(context);
    }

    public Ch04_2OverScrollListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Ch04_2OverScrollListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private int mMaxOverDistance = 5;

    /**
     * 弹性效果仍有问题,尤其是fling时,不会回弹.
     */
    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX, int scrollY, int scrollRangeX, int scrollRangeY, int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX, scrollRangeY, maxOverScrollX, mMaxOverDistance , isTouchEvent);
    }
}
