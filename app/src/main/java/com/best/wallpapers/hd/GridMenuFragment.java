package com.best.wallpapers.hd;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.best.wallpapers.hd.CustomRecyclerViewAdapter;
import com.best.wallpapers.hd.MainActivity;
import com.best.wallpapers.hd.R;
import com.best.wallpapers.hd.recyclerview.FeatureLinearLayoutManager;
import com.best.wallpapers.hd.recyclerview.FeaturedRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katsuyagoto on 15/06/04.
 */
public class GridMenuFragment extends Fragment {

    public static List<String> dummyData = new ArrayList<>();
    FeaturedRecyclerView featuredRecyclerView;
    View view;


    public static GridMenuFragment newInstance() {
        GridMenuFragment gridMenuFragment = new GridMenuFragment();
        Bundle args = new Bundle();
        return gridMenuFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_grid_menu, null);

        initViews();

        return view;
    }

    private void initViews () {
        createDummyDataList();

        featuredRecyclerView = (FeaturedRecyclerView) view.findViewById(R.id.featured_recycler_view);

        FeatureLinearLayoutManager layoutManager = new FeatureLinearLayoutManager(getContext());
        featuredRecyclerView.setLayoutManager(layoutManager);

        CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter(getContext(), new Intent(getContext(), MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        adapter.swapData(dummyData);

        featuredRecyclerView.setAdapter(adapter);
    }

    private void createDummyDataList() {
        dummyData.clear();
        dummyData.add("Природа");
        dummyData.add("Автомобили");
        dummyData.add("Животные");
        dummyData.add("Игры");
        dummyData.add("Абстракция");
        dummyData.add("Архитектура");
    }
}