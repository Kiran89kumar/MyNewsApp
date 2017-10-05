package com.kirankumar.mynewsapp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.kirankumar.mynewsapp.di.HasComponent;

/**
 * Created by kiran.kumar on 10/5/17.
 */

public abstract class BaseFragment extends Fragment{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    protected final <T> T getComponent(Class<T> componenentType) {
        //noinspection unchecked
        return componenentType.cast(((HasComponent<T>) getActivity()).getComponent());
    }
}
