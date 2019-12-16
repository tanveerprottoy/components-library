package com.tanveershafeeprottoy.componentslibrary.networkutils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class NetUtils {
    private static final long TIMEOUT = 60L;
    private static NetUtils netUtils;
    private Retrofit retrofit;

    // private constructor for singleton
    private NetUtils(String baseUrl) throws RuntimeException {
        // Prevent form the reflection api.
        if(retrofit != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
        else {
            buildRetrofit(baseUrl);
        }
    }

    public static NetUtils getInstance(String baseUrl) {
        // lazy initialization
        // Double check locking method
        // check first time
        if(netUtils == null) {
            synchronized(NetUtils.class) {
                // check second time
                if(netUtils == null) {
                    netUtils = new NetUtils(baseUrl);
                }
            }
        }
        return netUtils;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    private void buildRetrofit(String baseUrl) {
        retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                                         .client(
                                             new OkHttpClient.Builder()
                                                 .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                                                 .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                                                 .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                                                 .addInterceptor(
                                                     new HttpLoggingInterceptor().setLevel(
                                                         HttpLoggingInterceptor.Level.BODY
                                                     )
                                                 )
                                                 .build()
                                         )
                                         .addConverterFactory(MoshiConverterFactory.create())
                                         .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                         .build();
    }
}
