package com.kirankumar.mynewsapp.data.rest.http;

import java.io.IOException;

/**
 * Created by kiran.kumar on 9/7/17.
 */

public class ConnectivityException extends IOException{
    @Override
    public String getMessage() {
        return "No Connection";
    }
}
