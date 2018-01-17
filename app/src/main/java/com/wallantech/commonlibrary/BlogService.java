package com.wallantech.commonlibrary;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by likainian on 2017/11/10.
 */

public interface BlogService {
    @GET("blog/{id}")
    Observable<HttpJSONResult<String>> getBlog(@Path("id") int id);
}
