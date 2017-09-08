package com.kirankumar.mynewsapp.domain;

/**
 * Created by kiran.kumar on 9/8/17.
 */

public class NewsData {

    private Articles[] articles;

    private String status;

    public Articles[] getArticles ()
    {
        return articles;
    }

    public void setArticles (Articles[] articles)
    {
        this.articles = articles;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "NewsData [articles = "+articles+", status = "+status+"]";
    }

}
