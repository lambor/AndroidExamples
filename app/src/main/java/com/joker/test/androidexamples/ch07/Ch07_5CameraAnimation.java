package com.joker.test.androidexamples.ch07;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.Transformation;

/**
 * Created by lambor on 17-3-1.
 */

public class Ch07_5CameraAnimation extends Animation {

    private float mCenterX;
    private float mCenterY;
    private Camera mCamera;

    private int mRotateY = 50;

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        setDuration(2000);
        setFillAfter(true);
        setInterpolator(new BounceInterpolator());
        mCenterX = width/2;
        mCenterY = height/2;
        mCamera = new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final Matrix matrix = t.getMatrix();
        mCamera.save();
        mCamera.rotateY(mRotateY*interpolatedTime);
        mCamera.getMatrix(matrix);
        mCamera.restore();
        matrix.preTranslate(-mCenterX,-mCenterY);
        matrix.postTranslate(mCenterX,mCenterY);
    }
}
