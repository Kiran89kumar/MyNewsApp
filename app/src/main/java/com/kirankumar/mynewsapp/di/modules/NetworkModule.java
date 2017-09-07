package com.kirankumar.mynewsapp.di.modules;

import android.content.Context;
import android.support.annotation.Nullable;

import com.kirankumar.mynewsapp.data.rest.http.HeaderInterceptor;
import com.kirankumar.mynewsapp.data.rest.http.HttpClientBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Created by kiran.kumar on 9/7/17.
 */

@Module(
        includes = {HttpModule.class, ResponseFormatModule.class}
)
public class NetworkModule {

    public NetworkModule(){

    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(Context context, Interceptor networkInterceptor,
                                      @Named("LOGGING") Interceptor loggingInterceptor,
                                      HeaderInterceptor headerInterceptor){
        return buildOkHttpClient(context,
                Cache.GENERAL,
                50,
                networkInterceptor,
                loggingInterceptor,
                headerInterceptor);
    }


    private OkHttpClient buildOkHttpClient(Context context,
                                           String cacheName,
                                           int cacheSize,
                                           @Nullable Interceptor networkInterceptor,
                                           @Nullable Interceptor loggingInterceptor,
                                           @Nullable Interceptor headerInterceptor) {
        HttpClientBuilder builder =
                new HttpClientBuilder(context)
                        .setTimeouts(30)
                        .setCache(cacheName, cacheSize)
                        .setNetworkInterceptor(networkInterceptor)
                        .setLoggingInterceptor(loggingInterceptor)
                        .setWireFormatHeaderInterceptor(headerInterceptor)
                        .enableSocketLog(true);

        return builder.build();
    }
}
