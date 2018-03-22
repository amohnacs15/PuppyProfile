package com.amohnacs.puppyprofile.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by adrianmohnacs on 3/22/18.
 */

/**
 * If we would like to expand on our application and include a number of other APIs or endpoints then
 * we need a long term way to do that.  By passing in the class of the Client we reduce boilerplate code
 * and can easily build variations of our Retrofit Clients.
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
        gsonBuilder.serializeNulls();

        Gson myGson = gsonBuilder.create();

        return GsonConverterFactory.create(myGson);
    }
}
