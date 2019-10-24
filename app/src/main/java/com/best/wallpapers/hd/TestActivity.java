package com.best.wallpapers.hd;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.io.IOException;

public class TestActivity extends AppCompatActivity {

    private static final String URL = "url";
    Bitmap wallPaperBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ImageView imageView = (ImageView) findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(getIntent().getStringExtra(URL))
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        wallPaperBitmap = resource;
                        int height = wallPaperBitmap.getHeight();
                        int width = wallPaperBitmap.getWidth();
                        if (height > width) {
                            Glide.with(TestActivity.this).load(getIntent().getStringExtra(URL)).into(imageView);
                        }
                        else {
                            RequestOptions options = new RequestOptions().centerCrop();
                            Glide.with(TestActivity.this).load(getIntent().getStringExtra(URL)).apply(options).into(imageView);
                        }
                    }
                });
    }

    public static void start(Context context, String url) {
        Intent intent = new Intent(context, TestActivity.class);
        intent.putExtra(URL, url);
        context.startActivity(intent);
    }

    public void onClick(View view) {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int screenHeight = size.y;

//adjust the aspect ratio of the Image
//this is the main part
        int width = wallPaperBitmap.getWidth();
        width = (width * screenHeight) / wallPaperBitmap.getHeight();
//set the wallpaper
//this may not be the most efficent way but it works
        WallpaperManager myWallpaperManager
                = WallpaperManager.getInstance(getApplicationContext());

        try {
            myWallpaperManager.setBitmap(Bitmap.createScaledBitmap(wallPaperBitmap, width, screenHeight, true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
