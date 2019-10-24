package com.best.wallpapers.hd.cardviewslider;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import androidx.cardview.widget.CardView;

import com.best.wallpapers.hd.R;


public class ElasticCardView extends CardView {

    private final float RATIO;

    public ElasticCardView(Context context) {
        this(context, null);
    }

    public ElasticCardView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ElasticCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ElasticCardView);
        RATIO = array.getFloat(R.styleable.ElasticCardView_ratio, 1.0f);
        array.recycle();

        setPreventCornerOverlap(true);
        setUseCompatPadding(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        if (RATIO > 0) {
            int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (MeasureSpec.getSize(widthMeasureSpec) * RATIO), MeasureSpec.EXACTLY);
            super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
