package com.pavlo.userInfoActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.illyahavrulyk.project4.R;
import com.pavlo.util.Const;

import database.DatabaseImpl;
import model.User;

/**
 * Created by Illya Havrulyk on 2/26/2018.
 */

public class UserInfoActivity extends AppCompatActivity implements UserInfoView {
    private final String LOG_TAG = "UserInfoActivity log";

    private TextView loginTextView;
    private TextView firstNameTextView;
    private TextView lastNameTextView;
    private TextView passwordTextView;

    private Intent intent;
    private IUserInfoPresenter presenter;

    private String login = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info_activity);

        loginTextView = findViewById(R.id.loginTextView);
        firstNameTextView = findViewById(R.id.firstNameTextView);
        lastNameTextView = findViewById(R.id.lastNameTextView);
        passwordTextView = findViewById(R.id.passwordTextView);

        intent = getIntent();
        login = intent.getStringExtra(Const.USER_LOGIN);

        presenter = new UserInfoPresenter(UserInfoActivity.this, new DatabaseImpl(UserInfoActivity.this));
        presenter.getUserFromDatabase(login);
    }

    @Override
    public void showUserData(User user) {
        loginTextView.setText(user.getLogin());
        firstNameTextView.setText(user.getFirstName());
        lastNameTextView.setText(user.getLastName());
        passwordTextView.setText(user.getPassword());
    }
}
