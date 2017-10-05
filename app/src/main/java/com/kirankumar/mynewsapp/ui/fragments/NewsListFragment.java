package com.kirankumar.mynewsapp.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kirankumar.mynewsapp.R;
import com.kirankumar.mynewsapp.data.api.NewsApi;
import com.kirankumar.mynewsapp.di.components.NewsActivityComponent;
import com.kirankumar.mynewsapp.domain.NewsData;
import com.kirankumar.mynewsapp.ui.adapters.list.NewsListAdapter;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static com.kirankumar.mynewsapp.util.Constant.APIKEY;

/**
 * Created by kiran.kumar on 9/8/17.
 */

public class NewsListFragment extends BaseFragment {
    public NewsListFragment() {
        // Required empty public constructor
    }

    public static NewsListFragment newInstance() {
        NewsListFragment fragment = new NewsListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_main);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), LinearLayout.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getComponent(NewsActivityComponent.class).inject(this);
        adapter = new NewsListAdapter(picasso);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onStart() {
        super.onStart();
        if(recyclerView.getAdapter() == null)
            recyclerView.setAdapter(adapter);

        makeApiCall();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void makeApiCall(){

        Observable<Response<NewsData>> newsListObservable = newsApi.getBBCNews("bbc-news",APIKEY);

        newsListObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Response<NewsData>>() {
                    @Override
                    public void call(Response<NewsData> newsDataResponse) {
                        Log.d("Kiran","Response --------------"+newsDataResponse.body().getArticles().length);
                        adapter.refactorItems(newsDataResponse.body().getArticles());
                    }
                });
    }

    @Inject
    Picasso picasso;

    @Inject
    NewsApi newsApi;

    private RecyclerView recyclerView;
    private NewsListAdapter adapter;
}
