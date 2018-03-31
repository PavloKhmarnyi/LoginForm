package com.pavlo.mainActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.illyahavrulyk.project4.R;
import com.pavlo.registerActivity.RegisterActivity;
import com.pavlo.userInfoActivity.UserInfoActivity;

import database.Database;
import database.DatabaseImpl;
import model.User;

public class MainActivity extends AppCompatActivity implements MainActivityView {

    private final String LOG_TAG = "MainActivity log";

    private EditText loginEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private Button registrationButton;
    private TextView mainActivityErrorMessageTextView;
    private ProgressBar userLoadingProgressBar;

    private IMainPresenter presenter;

    private Intent intent;
    private Database database;

    private String login;
    private String password;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEditText = findViewById(R.id.loginEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        signInButton = findViewById(R.id.signInButton);
        registrationButton = findViewById(R.id.registrationButton);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!areFieldsEmpty()) {
                    login = loginEditText.getText().toString();
                    password = passwordEditText.getText().toString();
                } else {
                    showErrorMessage();
                    return;
                }

                User user = presenter.findUserByLogin(login);

                intent = new Intent(MainActivity.this, UserInfoActivity.class);
                startActivity(intent);
            }
        });

        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        mainActivityErrorMessageTextView = findViewById(R.id.mainActivityErrorMessageTextView);
        userLoadingProgressBar = findViewById(R.id.userLoadingProgressBar);

        presenter = new MainPresenter(MainActivity.this, new DatabaseImpl(MainActivity.this));
    }

    @Override
    public boolean areFieldsEmpty() {
        login = loginEditText.getText().toString();
        password = passwordEditText.getText().toString();

        return login.equals("") && password.equals("");
    }

    @Override
    public void showErrorMessage() {
        mainActivityErrorMessageTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorMessage() {
        mainActivityErrorMessageTextView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showSuccessMessage() {
        Toast.makeText(this, getResources().getString(R.string.success_login_message), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserLoadingProgressBar() {
        userLoadingProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideUserLoadingProgressBar() {
        userLoadingProgressBar.setVisibility(View.INVISIBLE);
    }
}
