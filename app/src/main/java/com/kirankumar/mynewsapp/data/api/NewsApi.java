package com.kirankumar.mynewsapp.data.api;

import com.kirankumar.mynewsapp.domain.NewsData;

import java.util.List;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by kiran.kumar on 9/8/17.
 */

public interface NewsApi {

    @GET("v2/top-headlines")
    Observable<Response<NewsData>> getBBCNews(@Query("sources") String source, @Query("apiKey") String apiKey);

}
