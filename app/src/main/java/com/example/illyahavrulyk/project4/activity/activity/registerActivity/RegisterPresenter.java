package com.example.illyahavrulyk.project4.activity.activity.registerActivity;

import database.Database;
import model.User;

/**
 * Created by pavlo on 3/10/2018.
 */

public class RegisterPresenter implements IRegisterPresenter {
    private RegisterView view;
    private Database database;

    public RegisterPresenter(RegisterView view, Database database) {
        this.view = view;
        this.database = database;
    }

    @Override
    public void saveUser(User user) {
        database.saveUser(user);
    }

    @Override
    public boolean isUserExist(String login) {
        User user = database.findUser(login);

        return user != null;
    }
}
