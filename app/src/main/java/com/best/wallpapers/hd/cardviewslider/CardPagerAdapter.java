package com.best.wallpapers.hd.cardviewslider;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

import static com.best.wallpapers.hd.cardviewslider.CardViewPager.CACHE_COUNT;


class CardPagerAdapter extends FragmentStatePagerAdapter {

    private final int MAX_VALUE;

    private static final int DIFF_COUNT = CACHE_COUNT / 2;

    private List<CardItem> mCardItems;
    private boolean mIsLoop;

    CardPagerAdapter(FragmentManager fm, List<CardItem> cardItems, boolean isLoop) {
        super(fm);
        mCardItems = cardItems;
        MAX_VALUE = getRealCount() * 3;
        mIsLoop = isLoop;
    }

    void setCardMode(@CardViewPager.TransformerMode int mode) {
        if (mCardItems == null || mCardItems.isEmpty()) {
            return;
        }
        for (CardItem cardItem : mCardItems) {
            cardItem.currentMode = mode;
        }
    }

    @Override
    public Fragment getItem(int position) {
        return mCardItems.get(position);
    }

    @Override
    public int getCount() {
        final int realCount = getRealCount();
        if (realCount == 0) {
            return 0;
        }
        return mIsLoop ? MAX_VALUE : realCount;
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final int j = position % getRealCount();
        return super.instantiateItem(container, mIsLoop ? j : position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (mIsLoop) {
            CardViewPager viewPager = (CardViewPager) container;
            int pos = viewPager.getCurrentItem();
            int i = pos % getRealCount();
            int j = position % getRealCount();
            if (Math.abs(i - j) != DIFF_COUNT && !viewPager.isNotify) {
                return;
            }
            super.destroyItem(container, j, object);
            return;
        }
        super.destroyItem(container, position, object);
    }

    @Override
    public void startUpdate(ViewGroup container) {
        super.startUpdate(container);
        final int realCount = getRealCount();
        if (realCount == 0) {
            return;
        }
        if (mIsLoop) {
            CardViewPager viewPager = (CardViewPager) container;
            int position = viewPager.getCurrentItem();
            if (position == 0) {
                position = getFirstItem();
            } else if (position == getCount() - 1) {
                position = getLastItem(position % realCount);
            }
            viewPager.setCurrentItem(position, false);
        }
    }

    private int getRealCount() {
        return mCardItems == null ? 0 : mCardItems.size();
    }

    private int getFirstItem() {
        final int realCount = getRealCount();
        return MAX_VALUE / realCount / 2 * realCount;
    }

    int getLastItem(int index) {
        final int realCount = getRealCount();
        return MAX_VALUE / realCount / 2 * realCount + index;
    }
}
