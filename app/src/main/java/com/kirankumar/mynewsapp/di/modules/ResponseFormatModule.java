package com.kirankumar.mynewsapp.di.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okio.GzipSource;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kiran.kumar on 9/7/17.
 */

@Module
public class ResponseFormatModule {

    @Provides
    Gson provideGson(){
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    Converter.Factory provideGsonConverter(Gson gson) {
        return GsonConverterFactory.create(gson);
    }
}
