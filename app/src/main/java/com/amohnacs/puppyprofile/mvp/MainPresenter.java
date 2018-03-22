package com.amohnacs.puppyprofile.mvp;

import android.content.Context;

import com.amohnacs.common.BasePresenter;
import com.amohnacs.common.Utils;
import com.amohnacs.model.Profile;
import com.amohnacs.puppyprofile.domain.ProfileInteractor;

import java.util.List;


/**
 * Created by adrianmohnacs on 3/22/18.
 */

public class MainPresenter extends BasePresenter<MvpContract.View> implements MvpContract.Presenter, MvpContract.Interactor.MvpCallback {
    private static final String TAG = MainPresenter.class.getSimpleName();

    private static volatile MainPresenter instance;

    private Context context;
    private ProfileInteractor interactor;

    private MainPresenter(Context context) {
        this.context = context;
        interactor = ProfileInteractor.getInstance(context);
    }

    public static MainPresenter getInstance(Context context) {
        if (instance == null) {
            synchronized (MainPresenter.class) {
                if (instance == null) {
                    instance = new MainPresenter(context);
                }
            }
        }
        return instance;
    }

    @Override
    public void loadProfiles() {
        interactor.getRetrofitStandardProfiles(this);
    }

    /**
     * Response has been returned and formatted from our interactor
     * @param profiles
     */
    @Override
    public void onProfilesRetrieved(List<Profile> profiles) {
        if(!Utils.isEmpty(profiles)) {
            if (isViewAttached()) {
                getMvpView().updateProfiles(profiles);
            }
        } else {
            if (isViewAttached()) {
                getMvpView().showErrorState("profiles is null or empty");
            }
        }
    }

    /**
     * Response failed from our interceptor
     * @param exceptionMessage
     */
    @Override
    public void onRetrievalFailed(String exceptionMessage) {
        if (isViewAttached()) {
            getMvpView().showErrorState(exceptionMessage);
        }
    }
}
