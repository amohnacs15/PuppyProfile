package com.amohnacs.puppyprofile.domain;

import android.content.Context;
import android.util.Log;

import com.amohnacs.model.ProfileItems;
import com.amohnacs.puppyprofile.mvp.MvpContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by adrianmohnacs on 3/21/18.
 */

public class ProfileInteractor implements MvpContract.Interactor {
    private static final String TAG = ProfileInteractor.class.getSimpleName();

    private static final String defaultVersion = "2.2";
    public static final String defaultSite = "stackoverflow";

    private static volatile ProfileInteractor instance;

    private Context context;
    private StackExchangeClient stackExchangeClient;

    private ProfileInteractor(Context context) {
        this.context = context;
        stackExchangeClient = RetrofitClientGenerator.generateClient(StackExchangeClient.class);
    }

    public static ProfileInteractor getInstance(Context context) {
        if (instance == null) {
            synchronized (ProfileInteractor.class) {
                if (instance == null) {
                    instance = new ProfileInteractor(context);
                }
            }
        }
        return instance;
    }

    @Override
    public void getRetrofitStandardProfiles(final MvpCallback presenterMvpCallback) {

        Call<ProfileItems> retrofitWebServerCall = stackExchangeClient
                .getRetroProfiles(defaultVersion, defaultSite);

        //execute asynchonously
        retrofitWebServerCall.enqueue(new Callback<ProfileItems>() {
            @Override
            public void onResponse(Call<ProfileItems> call, Response<ProfileItems> response) {

                if (response.isSuccessful()) {

                    if (presenterMvpCallback != null) {
                        presenterMvpCallback.onProfilesRetrieved(response.body().getItems());
                    }
                } else {
                    Log.e(TAG, String.valueOf(response.errorBody()));
                    if (presenterMvpCallback != null) {
                        presenterMvpCallback.onRetrievalFailed(String.valueOf(response.errorBody()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ProfileItems> call, Throwable t) {
                t.printStackTrace();
                if (presenterMvpCallback != null) {
                    presenterMvpCallback.onRetrievalFailed(t.getMessage());
                }
            }
        });
    }
}
