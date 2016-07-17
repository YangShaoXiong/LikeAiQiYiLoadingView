package com.dreamer.loadingview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by ysx on 2016/7/16.
 */
public class LoadingView extends RelativeLayout{


    private CircleView mCircleView;
    private AngleView mAngleView;

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mCircleView = new CircleView(context);
        addView(mCircleView,new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));

        mAngleView = new AngleView(context);
        mCircleView.setAngleView(mAngleView);
        addView(mAngleView, new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));
    }
}
