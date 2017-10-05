package com.kirankumar.mynewsapp.di.modules;

import android.app.Activity;
import android.content.Context;

import com.kirankumar.mynewsapp.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kiran.kumar on 10/5/17.
 */

@Module
public class ActivityModule {

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }

    @Provides
    @PerActivity
    @Named("ActivityContext")
    Context context() {
        return this.activity;
    }

    private final Activity activity;
}
