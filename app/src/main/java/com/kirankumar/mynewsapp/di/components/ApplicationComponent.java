package com.kirankumar.mynewsapp.di.components;

/**
 * Created by kiran.kumar on 9/7/17.
 */

import android.content.Context;

import com.kirankumar.mynewsapp.di.modules.ActivityModule;
import com.kirankumar.mynewsapp.di.modules.ApplicationModule;
import com.kirankumar.mynewsapp.di.modules.ImageModule;
import com.kirankumar.mynewsapp.di.modules.NetworkModule;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(
        modules = {ApplicationModule.class, NetworkModule.class}
)
public interface ApplicationComponent {

    Context context();

    ActivityComponent plus(ActivityModule activityModule);

    final class Initializer {
        public static ApplicationComponent build(ApplicationModule applicationModule, boolean useMock) {
            return DaggerApplicationComponent.builder()
                    .applicationModule(applicationModule)
                    .build();
        }

        private Initializer() {}
    }
}
