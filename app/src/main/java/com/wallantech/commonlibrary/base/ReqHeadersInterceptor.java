package com.wallantech.commonlibrary.base;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by likainian on 2017/12/5.
 */

public class ReqHeadersInterceptor implements Interceptor {
    private HashMap<String, String> headers;

    public ReqHeadersInterceptor(HashMap<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        builder.header("","");

        return chain.proceed(builder.build());
    }
}
