package com.kirankumar.mynewsapp.di.modules;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by kiran.kumar on 9/7/17.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    @Retention(RetentionPolicy.SOURCE)
    @StringDef({FLAGS, GENERAL})
    @interface Type{}
    String GENERAL  = "general";
    String FLAGS    = "flags";
    String value();
}
