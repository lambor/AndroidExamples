package com.joker.test.androidexamples.ch07;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by lambor on 17-3-1.
 */

public class Ch07_5TvShutdownAnimation extends Animation {

    float mCenterX;
    float mCenterY;

    public Ch07_5TvShutdownAnimation(float centerX, float centerY) {
        super();
        mCenterX = centerX;
        mCenterY = centerY;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final Matrix matrix = t.getMatrix();
        matrix.preScale(1,1-interpolatedTime,mCenterX,mCenterY);
    }
}
