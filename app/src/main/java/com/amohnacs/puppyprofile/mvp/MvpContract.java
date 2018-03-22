package com.amohnacs.puppyprofile.mvp;


import com.amohnacs.model.Profile;

import java.util.List;

/**
 * Created by adrianmohnacs on 3/22/18.
 */

public interface MvpContract {

    // TODO: 3/22/18 interactor or provider?
    interface Interactor {

        void getRetrofitStandardProfiles(MvpCallback mvpCallback);

        interface MvpCallback {

            void onProfilesRetrieved(List<Profile> profiles);

            void onRetrievalFailed(String exceptionMessage);
        }
    }

    interface Presenter {
        void loadProfiles();
    }

    interface View {
        void updateProfiles(List<Profile> profileList);

        void showErrorState(String errorMessage);
    }

}
