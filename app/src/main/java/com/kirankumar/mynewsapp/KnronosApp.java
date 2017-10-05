package com.kirankumar.mynewsapp;

import android.app.Application;

import com.kirankumar.mynewsapp.di.components.ApplicationComponent;
import com.kirankumar.mynewsapp.di.components.DaggerApplicationComponent;
import com.kirankumar.mynewsapp.di.modules.ApplicationModule;

/**
 * Created by kiran.kumar on 9/7/17.
 */

public class KnronosApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        buildComponents(false);
    }

    void buildComponents(boolean useMock) {
        this.appComponent = DaggerApplicationComponent.Initializer.build(getApplicationModule(), useMock);
    }

    ApplicationModule getApplicationModule() {
        if (applicationModule == null) {
            applicationModule = new ApplicationModule(this);
        }
        return applicationModule;
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }

    private ApplicationComponent appComponent;
    private ApplicationModule applicationModule;
    private static final String TAG = "KnronosApp";
}
