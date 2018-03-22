package com.amohnacs.puppyprofile.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adrianmohnacs on 3/21/18.
 */

public class RetrofitClientGenerator {
    private static final String TAG = RetrofitClientGenerator.class.getSimpleName();

    public static final String STACKOVERFLOW_USERS_ENDPOINT = "https://api.stackexchange.com/";

    static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(STACKOVERFLOW_USERS_ENDPOINT)
            .addConverterFactory(
                    buildGsonConverter()
            );

    public static <C> C generateClient(Class<C> clientsClass) {
        Retrofit retrofitClient = retrofitBuilder.client(
                buildLogginHttpBuilder().build()
        ).build();

        return retrofitClient.create(clientsClass);
    }

    private static OkHttpClient.Builder buildLogginHttpBuilder() {
        //logger
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor);
    }

    private static GsonConverterFactory buildGsonConverter() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        //gsonBuilder.registerTypeAdapter(ProfileItems.class, new ProfileItemDeserializer())
            //.setDateFormat("yyyy-MM-dd'T'HH:mm:ssz")
            gsonBuilder.serializeNulls();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
    }
}
