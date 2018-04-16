package com.pavlo.mainActivity;

import database.Database;
import model.User;

/**
 * Created by pavlo on 3/10/2018.
 */

public class MainPresenter implements IMainPresenter {
    private final String LOG_TAG = "MainPresenter log";

    private MainActivityView view;
    private Database database;

    private User user;

    public MainPresenter(MainActivityView view, Database database) {
        this.view = view;
        this.database = database;
    }

    @Override
    public User findUserByLogin(String login) {
        user = database.findUser(login);
        if (user == null) {
            view.showErrorMessage();
            return null;
        }

        if (!isPasswordCorrect(user.getPassword())) {
            view.showErrorMessage();
        }
        return user;
    }

    @Override
    public boolean isPasswordCorrect(String password) {
        return user.getPassword() == password;
    }
}
