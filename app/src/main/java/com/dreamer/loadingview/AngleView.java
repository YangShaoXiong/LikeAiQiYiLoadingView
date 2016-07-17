package com.dreamer.loadingview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ysx on 2016/7/16.
 */
public class AngleView extends View{

    private Paint mPaint;
    private Path mPath;

    private ObjectAnimator mAnimator;

    public AngleView(Context context) {
        this(context, null);
    }

    public AngleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AngleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.parseColor("#60B003"));
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5.0f);
        mPaint.setStrokeCap(Paint.Cap.ROUND);

        mPath = new Path();

        mAnimator = ObjectAnimator.ofFloat(this, "rotation", 0, 360);
        mAnimator.setDuration(2000);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth() - getPaddingLeft() - getPaddingRight();
        int height = getHeight() - getPaddingTop() - getPaddingBottom();
        mPath.moveTo(width / 2 - 35, height / 2 - 50);
        mPath.lineTo(width / 2 + 50, height / 2);
        mPath.lineTo(width / 2 - 35, height / 2 + 50);
        mPath.close();
        canvas.drawPath(mPath, mPaint);
    }

    public void startAnim() {
        mAnimator.start();
    }

}
