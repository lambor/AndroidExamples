package com.joker.test.androidexamples.ch06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lambor on 17-2-27.
 */

public class Ch06_7_3DashLineView extends View {
    public Ch06_7_3DashLineView(Context context) {
        this(context,null);
    }

    public Ch06_7_3DashLineView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Ch06_7_3DashLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    Path mPath;

    private void init() {
        mPath = new Path();
        mPath.moveTo(0,0);
        for(int i=0;i<=30;i++) {
            mPath.lineTo(i*35, (float) (Math.random()*100));
        }

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
    }


    PathEffect mEffects[] = new PathEffect[6];
    Paint mPaint;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mEffects[0] = null;
        mEffects[1] = new CornerPathEffect(30);
        mEffects[2] = new DiscretePathEffect(3.0f,5.0f);
        mEffects[3] = new DashPathEffect(new float[]{20,10,5,10},0);
        Path path = new Path();
        path.addRect(0,0,8,8,Path.Direction.CCW);
        mEffects[4] = new PathDashPathEffect(path,12,0,PathDashPathEffect.Style.ROTATE);
        mEffects[5] = new ComposePathEffect(mEffects[3],mEffects[1]);
        for(int i=0;i<mEffects.length;i++) {
            mPaint.setPathEffect(mEffects[i]);
            canvas.drawPath(mPath,mPaint);
            canvas.translate(0,200);
        }
    }
}
