package com.elisacapololo.androidnetworking;

import android.content.Context;

import com.elisacapololo.androidnetworking.data.DataSource;
import com.elisacapololo.androidnetworking.data.RemoteDataSource;

public class Injection {

    public static DataSource provideDataSource(Context context){
        return new RemoteDataSource(BuildConfig.POSTS_URL);
    }
}
