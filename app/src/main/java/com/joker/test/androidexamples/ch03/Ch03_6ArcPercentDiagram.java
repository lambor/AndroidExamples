package com.joker.test.androidexamples.ch03;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by lambor on 17-2-10.
 */

public class Ch03_6ArcPercentDiagram extends View {
    public Ch03_6ArcPercentDiagram(Context context) {
        super(context);
    }

    public Ch03_6ArcPercentDiagram(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Ch03_6ArcPercentDiagram(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private float mRadius;
    private int mCircleXY;
    private Paint mCirclePaint;

    private RectF mArcRectF;
    private int mSweepAngle;
    private Paint mArcPaint;

    private String mShowText = "Android Example";
    private int mShowTextSize = 20;
    private TextPaint mTextPaint;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec),measureHeight(heightMeasureSpec));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int length = Math.min(getMeasuredHeight(),getMeasuredWidth());
        mCircleXY = length/2;
        mRadius = (float)(length*0.5/2);
        mArcRectF = new RectF(
                (float)(length*0.1),
                (float)(length*0.1),
                (float)(length*0.9),
                (float)(length*0.9)
        );

        mSweepAngle = 120;

        mArcPaint = new Paint();
        mArcPaint.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth(40);
        mArcPaint.setAntiAlias(true);

        mCirclePaint = new Paint();
        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mCirclePaint.setAntiAlias(true);

        mTextPaint = new TextPaint();
        mTextPaint.setColor(0xffffffff);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制圆
        canvas.drawCircle(mCircleXY,mCircleXY,mRadius,mCirclePaint);
        //绘制弧线
        canvas.drawArc(mArcRectF,270,mSweepAngle,false,mArcPaint);
        //绘制文字
        canvas.drawText(mShowText,0,mShowText.length(),mCircleXY,mCircleXY+(mShowTextSize/4),mTextPaint);
    }

    private int measureWidth(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if(specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 200;
            if(specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result,specSize);
            }
        }
        return result;
    }

    private int measureHeight(int measureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if(specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else {
            result = 200;
            if(specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result,specSize);
            }
        }
        return result;
    }
}
