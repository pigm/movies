package com.core.data.remote;

import com.core.NetworkInterceptorFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiServiceFactory {

    public static <T> T build(Class<T> serviceClass, String urlBase) {
        OkHttpClient httpClient = new NetworkInterceptorFactory().getOkHttpClient();

        String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";
        Gson gson = new GsonBuilder().setDateFormat(dateFormat).create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlBase)
                .client(httpClient)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }
}