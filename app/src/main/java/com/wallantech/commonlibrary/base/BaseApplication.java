package com.wallantech.commonlibrary.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by likainian on 2017/11/22.
 */

public class BaseApplication extends Application {
    public static final String baseUrl = "http://www.baidu.com/";
    protected List<Activity> openedActivities = new ArrayList();
    private Retrofit retrofit;


    public Retrofit getRetrofit(){
        return retrofit;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new BaseApplication.AlcAdapter() {
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                openedActivities.add(activity);
            }

            public void onActivityDestroyed(Activity activity) {
                openedActivities.remove(activity);
            }
        });
        HashMap<String,String> httpHeaders = new HashMap();
        httpHeaders.put("WALLAN-TOKEN", "ffbcea46b05b31a834f57f27ec1937e8");
        httpHeaders.put("WALLAN-DEVICENUM", "e87d4adf-3c58-47aa-bfa5-129242525a67");
        retrofit = new Retrofit.Builder()
                .client(new OkHttpClient.Builder()
                        .connectTimeout(15, TimeUnit.SECONDS)
                        .readTimeout(15, TimeUnit.SECONDS)
                        .writeTimeout(15, TimeUnit.SECONDS)
                        .addInterceptor(new ReqHeadersInterceptor(httpHeaders))
                        .build())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    class AlcAdapter implements ActivityLifecycleCallbacks {
        AlcAdapter() {
        }

        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        public void onActivityDestroyed(Activity activity) {
        }
    }
}
