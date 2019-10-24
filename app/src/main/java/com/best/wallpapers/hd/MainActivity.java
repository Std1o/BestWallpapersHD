package com.best.wallpapers.hd;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.best.wallpapers.hd.cardviewslider.CardViewPager;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;


public class MainActivity extends AppCompatActivity {

    private CardViewPager viewPager;

    public static String type = "Люди";
    private ImageView mainBG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (CardViewPager) findViewById(R.id.viewpager);
        mainBG = (ImageView) findViewById(R.id.main_bg);

        viewPager.bind(getSupportFragmentManager(), new MyCardHandler(), filterList());
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.d("MainActivity", "position:" + position);
                Glide.with(MainActivity.this)
                        .load(filterList().get(position))
                        .apply(new RequestOptions()
                                .transform(new BlurTransformation(5)))
                        .into(new SimpleTarget<Drawable>() {
                            @Override
                            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                                mainBG.setImageDrawable(resource);
                            }
                        });
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("MainActivity", "state:" + state);
            }
        });
    }

    private List <DataModel> getData() {
        final List <DataModel> list = new ArrayList<>();
        list.clear();
        list.add(new DataModel("https://i.ibb.co/MfnWDmn/nature1.jpg", "Природа"));
        list.add(new DataModel("https://i.ibb.co/9rr8gmS/nature2.jpg", "Природа"));
        list.add(new DataModel("https://i.ibb.co/C9z1dhq/nature3.jpg", "Природа"));
        list.add(new DataModel("https://i.ibb.co/41CPQGF/nature4.jpg", "Природа"));
        list.add(new DataModel("https://i.ibb.co/ckDTXnc/nature5.jpg", "Природа"));
        list.add(new DataModel("https://i.ibb.co/j3PsqZH/nature6.jpg", "Природа"));
        list.add(new DataModel("https://i.ibb.co/b6Vwqg3/nature7.jpg", "Природа"));
        list.add(new DataModel("https://i.ibb.co/TWjNWhV/nature8.jpg", "Природа"));
        list.add(new DataModel("https://i.ibb.co/wYhxpTq/nature9.jpg", "Природа"));
        list.add(new DataModel("https://i.ibb.co/hVQ4bb8/nature10.jpg", "Природа"));
        list.add(new DataModel("https://i.ibb.co/VjvFJH4/nature11.jpg", "Природа"));
        list.add(new DataModel("https://i.ibb.co/xDW7KYm/nature12.jpg", "Природа"));
        list.add(new DataModel("https://i.ibb.co/Bw5YbNH/nature13.jpg", "Природа"));
        list.add(new DataModel("https://i.ibb.co/5GNhb9p/nature14.jpg", "Природа"));
        list.add(new DataModel("https://i.ibb.co/QfR22Vb/nature15.jpg", "Природа"));

        list.add(new DataModel("https://i.ibb.co/m8qP2jM/auto1.jpg", "Автомобили"));
        list.add(new DataModel("https://i.ibb.co/J5xPGYZ/auto2.jpg", "Автомобили"));
        list.add(new DataModel("https://i.ibb.co/Pw1jnKF/auto3.jpg", "Автомобили"));
        list.add(new DataModel("https://i.ibb.co/V3WYPwG/auto4.jpg", "Автомобили"));
        list.add(new DataModel("https://i.ibb.co/R7YKtM6/auto5.jpg", "Автомобили"));
        list.add(new DataModel("https://i.ibb.co/gzNJYF5/auto6.jpg", "Автомобили"));
        list.add(new DataModel("https://i.ibb.co/NsRHJSs/auto7.jpg", "Автомобили"));
        list.add(new DataModel("https://i.ibb.co/N6nykXZ/auto8.jpg", "Автомобили"));
        list.add(new DataModel("https://i.ibb.co/Q601cs2/auto9.jpg", "Автомобили"));
        list.add(new DataModel("https://i.ibb.co/ng48Gfb/auto10.jpg", "Автомобили"));
        list.add(new DataModel("https://i.ibb.co/cYssByy/auto11.jpg", "Автомобили"));
        list.add(new DataModel("https://i.ibb.co/ZxFq0q2/auto12.jpg", "Автомобили"));
        list.add(new DataModel("https://i.ibb.co/3198Qx2/auto13.jpg", "Автомобили"));
        list.add(new DataModel("https://i.ibb.co/Yb2xrh6/auto14.jpg", "Автомобили"));
        list.add(new DataModel("https://i.ibb.co/0tpnNMH/auto15.jpg", "Автомобили"));

        list.add(new DataModel("https://i.ibb.co/D15NsKS/animals1.jpg", "Животные"));
        list.add(new DataModel("https://i.ibb.co/9ZbN9Jh/animals2.jpg", "Животные"));
        list.add(new DataModel("https://i.ibb.co/PNrxJq0/animals3.jpg", "Животные"));
        list.add(new DataModel("https://i.ibb.co/TRPVcqx/animals4.jpg", "Животные"));
        list.add(new DataModel("https://i.ibb.co/FYTB0dx/animals5.jpg", "Животные"));
        list.add(new DataModel("https://i.ibb.co/7Q1k9sL/animals6.jpg", "Животные"));
        list.add(new DataModel("https://i.ibb.co/W2GP8wP/animals7.jpg", "Животные"));
        list.add(new DataModel("https://i.ibb.co/QfkzJXr/animals8.jpg", "Животные"));
        list.add(new DataModel("https://i.ibb.co/4d9D3TV/animals9.jpg", "Животные"));
        list.add(new DataModel("https://i.ibb.co/hBdDs1F/animals10.jpg", "Животные"));
        list.add(new DataModel("https://i.ibb.co/k4Z345Q/animals11.jpg", "Животные"));
        list.add(new DataModel("https://i.ibb.co/YhrKny2/animals12.jpg", "Животные"));
        list.add(new DataModel("https://i.ibb.co/vq3VRX3/animals13.jpg", "Животные"));
        list.add(new DataModel("https://i.ibb.co/Pmf4mH1/animals14.jpg", "Животные"));
        list.add(new DataModel("https://i.ibb.co/L992Jj1/animals15.jpg", "Животные"));

        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/igry-lyudi-muzhchiny-44311.jpg", "Игры"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/avto-igry-risunki-transport-42782.jpg", "Игры"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/fon-igry-logotipy-the_elder_scrolls-18496.jpg", "Игры"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/igry-kredo_ubijcy_assassins_creed-35962.jpg", "Игры"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/ajnkraft_minecraft-fon-igry-18103.jpg", "Игры"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/igry-39805.jpg", "Игры"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/igry-stalker_stalker-12001.jpg", "Игры"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/drakony-igry-logotipy-mortal_kombat_mortal_kombat-ogon-16515.jpg", "Игры"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/call_of_duty_cod-igry-11716.jpg", "Игры"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/far_cry_2-igry-38620.jpg", "Игры"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/igry-risunki-42179.jpg", "Игры"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/igry-kredo_ubijcy_assassins_creed-muzhchiny-22408.jpg", "Игры"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/igry-kredo_ubijcy_assassins_creed-2130.jpg", "Игры"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/igry-ir_ankov_world_of_tanks-tanki-15045.jpg", "Игры"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/igry-zhazhda_skorosti_need_for_speed-38642.jpg", "Игры"));

        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/abstrakciya-fon-20149.jpg", "Абстракция"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/abstrakciya-fon-41314.jpg", "Абстракция"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/abstrakciya-fon-33946.jpg", "Абстракция"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/abstrakciya-fon-40169.jpg", "Абстракция"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/abstrakciya-fon-40418.jpg", "Абстракция"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/abstrakciya-fon-15876.jpg", "Абстракция"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/abstrakciya-fon-zory-27968.jpg", "Абстракция"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/abstrakciya-fon-41100.jpg", "Абстракция"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/abstrakciya-fon-raduga-19742.jpg", "Абстракция"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/abstrakciya-fon-31096.jpg", "Абстракция"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/abstrakciya-fon-zory-28625.jpg", "Абстракция"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/abstrakciya-fon-37676.jpg", "Абстракция"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/abstrakciya-fon-40658.jpg", "Абстракция"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/abstrakciya-fon-6876.jpg", "Абстракция"));
        list.add(new DataModel("https://mobimg.b-cdn.net/pic/v2/gallery/preview/abstrakciya-fon-37430.jpg", "Абстракция"));

        return list;
    }

    private List filterList() {
        final List list = new ArrayList();
        list.clear();
        for (int i = 0; i < getData().size(); i++) {
            if (type.equals(getData().get(i).type)) {
                list.add(getData().get(i).imageUrl);
            }
        }
        return list;
    }

}
