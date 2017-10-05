package com.kirankumar.mynewsapp.ui.adapters.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kirankumar.mynewsapp.R;
import com.kirankumar.mynewsapp.domain.Articles;
import com.kirankumar.mynewsapp.domain.NewsData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kiran.kumar on 9/8/17.
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder>{

    private Picasso picasso;

    public NewsListAdapter(Picasso picasso){

        this.picasso = picasso;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        picasso.load(articles.get(position).getUrlToImage()).into(holder.thumbnail);
        holder.storyType.setText(articles.get(position).getAuthor());
        holder.headline.setText(articles.get(position).getTitle());
        holder.detail.setText(articles.get(position).getDescription());
        holder.age.setText(articles.get(position).getPublishedAt());
    }

    public void refactorItems(Articles[] items) {
        articles.clear();
        articles.addAll(Arrays.asList(items));
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView storyType,headline,age, detail;
        private ImageView thumbnail;
        public ViewHolder(View view) {
            super(view);

            storyType = (TextView)view.findViewById(R.id.txt_storycontext);
            headline = (TextView)view.findViewById(R.id.txt_heading);
            age = (TextView)view.findViewById(R.id.txt_timeago);
            detail = (TextView)view.findViewById(R.id.txt_details);
            thumbnail = (ImageView) view.findViewById(R.id.img_news);
        }
    }

    private List<Articles> articles = new ArrayList<>();
}
