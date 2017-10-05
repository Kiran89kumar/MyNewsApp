package com.kirankumar.mynewsapp.di.modules;

import com.kirankumar.mynewsapp.data.api.NewsApi;
import com.kirankumar.mynewsapp.di.PerActivity;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kiran.kumar on 10/5/17.
 */

@Module
public class NewsModule {

    @Provides
    @PerActivity
    NewsApi provideRestNewsService(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://beta.newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(NewsApi.class);
    }
}
