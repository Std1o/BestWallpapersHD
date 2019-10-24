package com.best.wallpapers.hd.cardviewslider;

import android.content.Context;
import android.view.View;

import java.io.Serializable;


@FunctionalInterface
public interface CardHandler<T> extends Serializable {

    View onBind(Context context, T data, int position, @CardViewPager.TransformerMode int mode);
}
