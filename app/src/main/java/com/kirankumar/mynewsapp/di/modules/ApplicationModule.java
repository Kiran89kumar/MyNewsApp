package com.kirankumar.mynewsapp.di.modules;

import android.app.Application;
import android.content.Context;

import com.kirankumar.mynewsapp.KnronosApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kiran.kumar on 9/7/17.
 */

@Module
public class ApplicationModule {

    public ApplicationModule(KnronosApp app) {
        this.application = app;
    }

    @Provides
    @Singleton
    Context provideAppContext() {
        return this.application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return this.application;
    }

    private final KnronosApp application;
}
