package com.best.wallpapers.hd;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.best.wallpapers.hd.recyclerview.FeatureRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;


public class CustomRecyclerViewAdapter extends FeatureRecyclerViewAdapter<RecyclerView.ViewHolder> {

    private static final int ITEM_TYPE_FEATURED = 0;
    private static final int ITEM_TYPE_DUMMY = 1;

    private List<String> data;
    ArrayList<String> imgList = new ArrayList<>();
    public static Context mContext;
    public static Intent mIntent;

    CustomRecyclerViewAdapter(Context context, Intent intent) {
        mContext = context;
        mIntent = intent;
        imgList.add("https://i.ibb.co/GQxzdXX/nature.jpg");
        imgList.add("https://i.ibb.co/h9JdhYc/auto.jpg");
        imgList.add("https://i.ibb.co/mbCN67g/animals.jpg");
        imgList.add("https://mobimg.b-cdn.net/pic/v2/gallery/preview/igry-lyudi-muzhchiny-44311.jpg");
    }

    public void swapData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateFeaturedViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ITEM_TYPE_FEATURED:
                return new FeaturedViewHolder(
                        LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.layout_featured_item, parent, false));
            case ITEM_TYPE_DUMMY:
            default:
                return new DummyViewHolder(
                        LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.layout_dummy_item, parent, false));
        }
    }

    @Override
    public void onBindFeaturedViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FeaturedViewHolder) {
            FeaturedViewHolder featuredViewHolder = (FeaturedViewHolder) holder;
            Glide.with(holder.itemView.getContext())
                    .load(imgList.get(position))
                    .into(new SimpleTarget<Drawable>() {
                        @Override
                        public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                            featuredViewHolder.ivBackground.setImageDrawable(resource);
                        }
                    });
            featuredViewHolder.tvHeading.setText(data.get(position));
        } else if (holder instanceof DummyViewHolder) {
            //Do nothing
        }
    }

    @Override
    public int getFeaturedItemsCount() {
        return data.size() + 2; /* Return 2 extra dummy items */
    }

    @Override
    public int getItemViewType(int position) {
        return position >= 0 && position < data.size() ? ITEM_TYPE_FEATURED : ITEM_TYPE_DUMMY;
    }

    @Override
    public void onSmallItemResize(RecyclerView.ViewHolder holder, int position, float offset) {
        if (holder instanceof FeaturedViewHolder) {
            FeaturedViewHolder featuredViewHolder = (FeaturedViewHolder) holder;
            featuredViewHolder.tvHeading.setAlpha(offset / 100f);
        }
    }

    @Override
    public void onBigItemResize(RecyclerView.ViewHolder holder, int position, float offset) {
        if (holder instanceof FeaturedViewHolder) {
            FeaturedViewHolder featuredViewHolder = (FeaturedViewHolder) holder;
            featuredViewHolder.tvHeading.setAlpha(offset / 100f);
        }
    }


    static class FeaturedViewHolder extends RecyclerView.ViewHolder {

        ImageView ivBackground;
        TextView tvHeading;

        FeaturedViewHolder(View itemView) {
            super(itemView);

            ivBackground = (ImageView) itemView.findViewById(R.id.iv_background);
            tvHeading = (TextView) itemView.findViewById(R.id.tv_heading);

            ivBackground.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.type = SelectTypeActivity.dummyData.get(getAdapterPosition());
                    CustomRecyclerViewAdapter.mContext.startActivity(mIntent);
                    Log.i("TEXT BY POSITION ", SelectTypeActivity.dummyData.get(getAdapterPosition()));
                }
            });
        }
    }

    static class DummyViewHolder extends RecyclerView.ViewHolder {

        DummyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
