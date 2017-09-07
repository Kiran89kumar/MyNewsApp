package com.kirankumar.mynewsapp.data.rest.http;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by kiran.kumar on 9/7/17.
 */

public class HeaderInterceptor implements Interceptor {

    public HeaderInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request());
    }


}
