package com.pavlo.userInfoActivity;

import database.Database;
import model.User;

/**
 * Created by pavlo on 3/10/2018.
 */

public class UserInfoPresenter implements IUserInfoPresenter {
    private UserInfoView view;
    private Database database;

    public UserInfoPresenter(UserInfoView view, Database database) {
        this.view = view;
        this.database = database;
    }

    @Override
    public User getUserFromDatabase(String login) {
        User user = database.findUser(login);
        if (user != null) {
            view.showUserData(user);
        }

        return user;
    }
}
