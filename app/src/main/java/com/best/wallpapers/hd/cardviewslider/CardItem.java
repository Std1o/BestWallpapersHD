package com.best.wallpapers.hd.cardviewslider;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import java.io.Serializable;


public class CardItem<T extends Serializable> extends BaseCardItem<T> {

    @SuppressWarnings("unchecked")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        CardHandler<T> handler = (CardHandler<T>) bundle.getSerializable(ARGUMENTS_HANDLER);
        T data = (T) bundle.getSerializable(ARGUMENTS_DATA);
        int position = bundle.getInt(ARGUMENTS_POSITION, 0);
        if (handler == null) {
            throw new RuntimeException("please bind the handler !");
        }
        final Context context = getContext();
        return handler.onBind(context, data, position, currentMode);
    }

    void bindData(T data, int position) {
        Bundle bundle = getArguments();
        if (bundle == null) {
            bundle = new Bundle();
            setArguments(bundle);
        }
        bundle.putSerializable(ARGUMENTS_DATA, data);
        bundle.putInt(ARGUMENTS_POSITION, position);
    }

}
