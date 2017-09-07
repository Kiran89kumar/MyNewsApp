package com.kirankumar.mynewsapp.di.components;

import com.kirankumar.mynewsapp.di.modules.NetworkModule;

import dagger.Subcomponent;

/**
 * Created by kiran.kumar on 9/7/17.
 */

@Subcomponent(modules = NetworkModule.class)
interface NetworkComponent {
}
