package com.best.wallpapers.hd;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.best.wallpapers.hd.recyclerview.FeatureLinearLayoutManager;
import com.best.wallpapers.hd.recyclerview.FeaturedRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SelectTypeActivity extends AppCompatActivity {

    public static List<String> dummyData = new ArrayList<>();
    FeaturedRecyclerView featuredRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type);

        createDummyDataList();

        featuredRecyclerView = (FeaturedRecyclerView) findViewById(R.id.featured_recycler_view);

        FeatureLinearLayoutManager layoutManager = new FeatureLinearLayoutManager(this);
        featuredRecyclerView.setLayoutManager(layoutManager);

        CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter(this, new Intent(this, MainActivity.class));
        adapter.swapData(dummyData);

        featuredRecyclerView.setAdapter(adapter);
    }

    private void createDummyDataList() {
        dummyData.add("Природа");
        dummyData.add("Автомобили");
        dummyData.add("Животные");
        dummyData.add("Игры");
    }
}
