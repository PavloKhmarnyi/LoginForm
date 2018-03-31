package com.pavlo.registerActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.illyahavrulyk.project4.R;
import com.pavlo.userInfoActivity.UserInfoActivity;
import com.pavlo.util.Const;

import database.DatabaseImpl;
import model.User;

public class RegisterActivity extends AppCompatActivity implements RegisterView {
    private final String LOG_TAG = "RegisterActivity log";

    private TextView registerTitleTextView;
    private TextView errorRegisterTextView;
    private EditText loginRegisterEditText;
    private EditText firstNameRegisterEditText;
    private EditText lastNameRegisterEditText;
    private EditText passwordRegisterEditText;
    private EditText passwordConfirmRegisterEditText;
    private Button registerButton;

    private IRegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerTitleTextView = findViewById(R.id.registerTitleTextView);
        errorRegisterTextView = findViewById(R.id.errorRegisterTextView);
        loginRegisterEditText = findViewById(R.id.loginRegisterEditText);
        firstNameRegisterEditText = findViewById(R.id.firstNameRegisterEditText);
        lastNameRegisterEditText = findViewById(R.id.lastNameRegisterEditText);
        passwordRegisterEditText = findViewById(R.id.passwordRegisterEditText);
        passwordConfirmRegisterEditText = findViewById(R.id.passwordConfirmRegisterEditText);

        registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = loginRegisterEditText.getText().toString();
                String firstName = firstNameRegisterEditText.getText().toString();
                String lastName = lastNameRegisterEditText.getText().toString();
                String password = passwordRegisterEditText.getText().toString();
                String confirmPassword = passwordConfirmRegisterEditText.getText().toString();

                if(!presenter.areFieldsEmpty(login,firstName,lastName,password,confirmPassword) && presenter.isPasswordConfirm(password,confirmPassword)){
                    User user = new User(firstName,lastName,password,login,"Male");
                    presenter.saveUser(user);
                    Intent intent = new Intent(RegisterActivity.this, UserInfoActivity.class);
                    intent.putExtra(Const.USER_LOGIN, login);
                    startActivity(intent);
                }else {
                    hideRegisterTitleTextView();
                    showErrorRegisterTextView();
                    return;
                }
            }
        });

        presenter = new RegisterPresenter(this, new DatabaseImpl(this));
    }

    @Override
    public void showRegisterTitleTextView() {
        registerTitleTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRegisterTitleTextView() {
        registerTitleTextView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showErrorRegisterTextView() {
        errorRegisterTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideErrorRegisterTextView() {
        errorRegisterTextView.setVisibility(View.INVISIBLE);
    }
}
