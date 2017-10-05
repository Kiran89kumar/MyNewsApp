package com.kirankumar.mynewsapp.ui.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kirankumar.mynewsapp.KnronosApp;
import com.kirankumar.mynewsapp.di.HasComponent;
import com.kirankumar.mynewsapp.di.components.ActivityComponent;
import com.kirankumar.mynewsapp.di.components.ApplicationComponent;
import com.kirankumar.mynewsapp.di.components.InjectableComponent;
import com.kirankumar.mynewsapp.di.modules.ActivityModule;

/**
 * Created by kiran.kumar on 10/5/17.
 */

public abstract class BaseActivity<C extends InjectableComponent> extends AppCompatActivity implements HasComponent<C> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initiateComponent();
    }

    final void initiateComponent() {
        activityComponent =
                createComponent(getApplicationComponent()
                        .plus(new ActivityModule(this)));
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((KnronosApp) getApplication()).getAppComponent();
    }

    protected abstract C createComponent(ActivityComponent activityComponent);

    @Override
    public final C getComponent() {
        return activityComponent;
    }

    private C activityComponent;
}
