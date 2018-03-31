package com.pavlo.userInfoActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.illyahavrulyk.project4.R;

/**
 * Created by Illya Havrulyk on 2/26/2018.
 */

public class UserInfoActivity extends AppCompatActivity implements UserInfoView {
    private final String LOG_TAG = "UserInfoActivity log";

    private TextView loginTextView;
    private TextView firstnameTextView;
    private TextView passwordTextView;
    private TextView loginShow;
    private TextView firstnameShow;
    private TextView passwordShow;

    private Intent intent;

    private String login = "";
    private String password = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info_activity);

        loginTextView = findViewById(R.id.loginEditText);
        firstnameTextView = findViewById(R.id.firstnameShow);
        passwordTextView = findViewById(R.id.passwordTextView);
        loginShow = findViewById(R.id.loginShow);
        firstnameShow = findViewById(R.id.firstnameShow);
        passwordShow = findViewById(R.id.passwordShow);

        intent = getIntent();

        login = intent.getStringExtra(getResources().getString(R.string.login));
        loginShow.setText(login);

        password = intent.getStringExtra(getResources().getString(R.string.password));
        passwordShow.setText(password);
    }
}
