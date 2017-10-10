package com.kirankumar.mynewsapp.di.components;

import com.kirankumar.mynewsapp.di.PerActivity;
import com.kirankumar.mynewsapp.di.modules.ImageModule;
import com.kirankumar.mynewsapp.di.modules.NewsModule;
import com.kirankumar.mynewsapp.ui.activities.LauncherActivity;
import com.kirankumar.mynewsapp.ui.fragments.NewsListFragment;

import dagger.Subcomponent;

/**
 * Created by kiran.kumar on 10/5/17.
 */

@PerActivity
@Subcomponent(modules = {NewsModule.class, ImageModule.class})
public interface NewsActivityComponent extends InjectableComponent{

    void inject(NewsListFragment newsListFragment);

    void inject(LauncherActivity launcherActivity);
}
