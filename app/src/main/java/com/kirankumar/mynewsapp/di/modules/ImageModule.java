package com.kirankumar.mynewsapp.di.modules;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.kirankumar.mynewsapp.di.PerActivity;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by kiran.kumar on 10/5/17.
 */

@Module
public class ImageModule {

    @Provides
    @PerActivity
    static Picasso provideDefaultPicasso(Context context,
                                         OkHttpClient client) {
        return buildPicasso(context, client, null);
    }

    private static Picasso buildPicasso(Context context,
                                        OkHttpClient client,
                                        Picasso.Listener errorListener) {

        Picasso.Builder picassoBuilder = new Picasso.Builder(context);
        /*picassoBuilder.indicatorsEnabled(BuildConfig.CB_DEBUG_IMAGES);
        picassoBuilder.loggingEnabled(BuildConfig.CB_DEBUG_IMAGES);*/
        if (isLowMemoryDevice(context)){
            picassoBuilder.defaultBitmapConfig(Bitmap.Config.RGB_565);
        }
        picassoBuilder.downloader(new OkHttp3Downloader(client));
        if (errorListener != null) {
            picassoBuilder.listener(errorListener);
        }
        return picassoBuilder.build();
    }

    private static boolean isLowMemoryDevice(Context context) {
        //return Build.VERSION.SDK_INT >= 19 && ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).isLowRamDevice();
        return ((ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE)).isLowRamDevice();
    }
}
