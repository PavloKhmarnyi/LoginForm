package com.pavlo.registerActivity;

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
    public boolean areFieldsEmpty(String login, String lastName, String firstName, String password, String confirmPassword) {
        return login.equals("") &&
                firstName.equals("") &&
                lastName.equals("") &&
                password.equals("") &&
                confirmPassword.equals("");
    }

    @Override
    public boolean isPasswordConfirm(String password, String confirmPassword) {
        return password.equals(confirmPassword);
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
