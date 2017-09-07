package com.kirankumar.mynewsapp.di.components;

/**
 * Created by kiran.kumar on 9/7/17.
 */

import android.content.Context;
import com.kirankumar.mynewsapp.di.modules.ApplicationModule;
import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(
        dependencies = NetworkComponent.class,
        modules = ApplicationModule.class
)
public interface ApplicationComponent {

    Context context();

    final class Initializer {
        public static ApplicationComponent build(ApplicationModule applicationModule, boolean useMock) {
            return DaggerApplicationComponent.builder()
                    .applicationModule(applicationModule)
                    .build();
        }

        private Initializer() {}
    }
}
