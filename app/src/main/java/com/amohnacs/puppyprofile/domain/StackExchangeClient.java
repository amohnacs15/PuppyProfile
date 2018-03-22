package com.amohnacs.puppyprofile.domain;


import com.amohnacs.model.ProfileItems;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by adrianmohnacs on 3/22/18.
 */

public interface StackExchangeClient {

    @GET("{version}/users")
    Call<ProfileItems> getRetroProfiles(
            @Path("version") String majorMinorPatch,
            @Query("site") String siteString
    );
}
