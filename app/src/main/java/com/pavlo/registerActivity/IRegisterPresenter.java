package com.pavlo.registerActivity;

import model.User;

/**
 * Created by pavlo on 3/10/2018.
 */

public interface IRegisterPresenter {
    boolean areFieldsEmpty(String login,String lastName,String firstName,String password,String confirmPassword);
    boolean isPasswordConfirm(String password,String confirmPassword);
    void saveUser(User user);
    boolean isUserExist(String login);
}
