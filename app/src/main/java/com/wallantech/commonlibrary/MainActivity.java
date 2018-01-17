package com.wallantech.commonlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.gson.GsonBuilder;

import cn.jzvd.JZVideoPlayerStandard;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JZVideoPlayerStandard jzVideoPlayerStandard = findViewById(R.id.videoplayer);
        jzVideoPlayerStandard.setUp("https://wander.wallan-tech.com:1443/media-app/file/download/5a014bd661e29e7e8788d882"
                , JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "饺子闭眼睛");
//        jzVideoPlayerStandard.thumbImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
        Glide.with(this).load("https://wander.wallan-tech.com:1443/media-app/file/download/5a014bd761e29e7e8788d8a4").into(jzVideoPlayerStandard.thumbImageView);



    }
}
