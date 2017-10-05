package com.kirankumar.mynewsapp.ui.activities;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import com.kirankumar.mynewsapp.R;
import com.kirankumar.mynewsapp.di.components.ActivityComponent;
import com.kirankumar.mynewsapp.di.components.NewsActivityComponent;
import com.kirankumar.mynewsapp.ui.fragments.NewsListFragment;

public class LauncherActivity extends BaseActivity<NewsActivityComponent>{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment();
    }

    private void addFragment(){
        NewsListFragment blankFragment = NewsListFragment.newInstance();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_container, blankFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected NewsActivityComponent createComponent(ActivityComponent activityComponent) {
        NewsActivityComponent comp = activityComponent.plus();
        comp.inject(this);
        return comp;
    }

}
