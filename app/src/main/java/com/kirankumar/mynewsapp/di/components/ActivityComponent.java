package com.kirankumar.mynewsapp.di.components;

import com.kirankumar.mynewsapp.di.PerActivity;
import com.kirankumar.mynewsapp.di.modules.ActivityModule;

import dagger.Subcomponent;

/**
 * Created by kiran.kumar on 10/5/17.
 */

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    NewsActivityComponent plus();
}
