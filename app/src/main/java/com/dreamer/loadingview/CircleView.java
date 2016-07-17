package com.dreamer.loadingview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ysx on 2016/7/16.
 */
public class CircleView extends View {

    private Paint mPaint;
    private int mDegree;
    private int mFlag = 1;

    private AngleView mAngleView;
    private ValueAnimator mAnimator;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#60B003"));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5.0f);

        mAnimator = ValueAnimator.ofInt(0, 360);
        mAnimator.setDuration(2000);
        mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mDegree = (int) animation.getAnimatedValue();
                postInvalidate();
                if (mDegree == 360) {
                    mDegree = 0;
                    mFlag ++;
                }
            }
        });
    }

    public void setAngleView(AngleView angleView) {
        mAngleView = angleView;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth() - getPaddingLeft() - getPaddingRight();
        int height = getHeight() - getPaddingTop() - getPaddingBottom();
        RectF rf = new RectF(width / 2 - 100, height / 2 - 100,
                width / 2 + 100, height / 2 + 100);

        if (mFlag % 2 == 0) {
            canvas.drawArc(rf, 270, -(360 - mDegree), false, mPaint);
        } else {
            canvas.drawArc(rf, 270, mDegree, false, mPaint);
        }

        if (mFlag % 2 == 0 && !mAnimator.isRunning()) {
            mAngleView.startAnim();
            mAnimator.start();
        }

        if (mFlag % 2 != 0 && !mAnimator.isRunning()) {
            mAnimator.start();
        }

    }

}
