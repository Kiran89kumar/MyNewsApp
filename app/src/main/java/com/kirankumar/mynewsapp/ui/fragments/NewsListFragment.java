package com.kirankumar.mynewsapp.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kirankumar.mynewsapp.R;
import com.kirankumar.mynewsapp.data.api.NewsApi;
import com.kirankumar.mynewsapp.domain.NewsData;
import com.kirankumar.mynewsapp.ui.adapters.list.NewsListAdapter;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static com.kirankumar.mynewsapp.util.Constant.APIKEY;

/**
 * Created by kiran.kumar on 9/8/17.
 */

public class NewsListFragment extends Fragment {
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
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        adapter = new NewsListAdapter();
        makeApiCall();
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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://beta.newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        NewsApi newsApi = retrofit.create(NewsApi.class);

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


    private RecyclerView recyclerView;
    private NewsListAdapter adapter;
}
