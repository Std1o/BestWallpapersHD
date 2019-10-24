package com.best.wallpapers.hd;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.best.wallpapers.hd.cardviewslider.CardHandler;
import com.best.wallpapers.hd.cardviewslider.CardViewPager;
import com.best.wallpapers.hd.cardviewslider.ElasticCardView;


public class MyCardHandler implements CardHandler<String> {

    @Override
    public View onBind(final Context context, final String data, final int position, @CardViewPager.TransformerMode int mode) {
        View view = View.inflate(context, R.layout.item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        ElasticCardView cardView = (ElasticCardView) view.findViewById(R.id.cardview);
        final boolean isCard = mode == CardViewPager.MODE_CARD;
        cardView.setPreventCornerOverlap(isCard);
        cardView.setUseCompatPadding(isCard);
        Glide.with(context).load(data).apply(new RequestOptions().dontAnimate()).into(imageView);
        view.setOnClickListener(v -> {
            //Toast.makeText(context, "data:" + data + "position:" + position, Toast.LENGTH_SHORT).show();
            TestActivity.start(context, data);
        });
        return view;
    }
}
