package com.example.illyahavrulyk.project4.activity.activity.mainActivity;

import model.User;

/**
 * Created by pavlo on 3/10/2018.
 */

public interface IMainPresenter {
    User findUserByLogin(String login);
    boolean isPasswordCorrect(String password);
}
