package com.amohnacs.common;

import android.support.annotation.NonNull;

/**
 * Every presenter in the app must either implement this interface or extend BasePresenter
 * indicating the MvpView type that wants to be attached with.
 */
public interface MvpPresenter<V> {

    void subscribe(@NonNull V mvpView);

    void unsubscribe(@NonNull V view);
}
