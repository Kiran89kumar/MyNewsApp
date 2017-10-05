package com.kirankumar.mynewsapp.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by kiran.kumar on 10/5/17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {}
