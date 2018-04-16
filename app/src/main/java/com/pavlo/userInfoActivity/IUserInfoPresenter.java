package com.pavlo.userInfoActivity;

import model.User;

/**
 * Created by pavlo on 3/10/2018.
 */

public interface IUserInfoPresenter {
    User getUserFromDatabase(String login);
}
