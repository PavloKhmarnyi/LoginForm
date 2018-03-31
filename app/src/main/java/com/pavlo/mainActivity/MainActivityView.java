package com.pavlo.mainActivity;

/**
 * Created by pavlo on 3/10/2018.
 */

public interface MainActivityView {
    boolean areFieldsEmpty();
    void showErrorMessage();
    void hideErrorMessage();
    void showSuccessMessage();
    void showUserLoadingProgressBar();
    void hideUserLoadingProgressBar();
}
