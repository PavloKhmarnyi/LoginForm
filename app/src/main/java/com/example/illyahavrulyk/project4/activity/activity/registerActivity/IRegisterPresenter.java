package com.example.illyahavrulyk.project4.activity.activity.registerActivity;

import model.User;

/**
 * Created by pavlo on 3/10/2018.
 */

public interface IRegisterPresenter {
    void saveUser(User user);
    boolean isUserExist(String login);
}
