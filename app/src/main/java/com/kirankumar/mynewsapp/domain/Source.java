package com.kirankumar.mynewsapp.domain;

/**
 * Created by kiran.kumar on 9/8/17.
 */

public class Source {
    private String id;

    private String name;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "MyNews [id = "+id+", name = "+name+"]";
    }
}
