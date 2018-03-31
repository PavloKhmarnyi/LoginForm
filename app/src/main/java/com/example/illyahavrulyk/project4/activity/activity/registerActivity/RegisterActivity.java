package com.example.illyahavrulyk.project4.activity.activity.registerActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.illyahavrulyk.project4.R;

public class RegisterActivity extends AppCompatActivity implements RegisterView {
    private final String LOG_TAG = "RegisterActivity log";

    private EditText loginRegisterEditText;
    private EditText firstNameRegisterEditText;
    private EditText lastNameRegisterEditText;
    private EditText passwordRegisterEditText;
    private EditText passwordConfirmRegisterEditText;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginRegisterEditText = findViewById(R.id.loginRegisterEditText);
        firstNameRegisterEditText = findViewById(R.id.firstNameRegisterEditText);
        lastNameRegisterEditText = findViewById(R.id.lastNameRegisterEditText);
        passwordRegisterEditText = findViewById(R.id.passwordRegisterEditText);
        passwordConfirmRegisterEditText = findViewById(R.id.passwordConfirmRegisterEditText);

        registerButton = findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public boolean areFieldsEmpty() {
        String login = loginRegisterEditText.getText().toString();
        String firstName = firstNameRegisterEditText.getText().toString();
        String lastName = lastNameRegisterEditText.getText().toString();
        String password = passwordRegisterEditText.getText().toString();
        String confirmPassword = passwordConfirmRegisterEditText.getText().toString();

        return login.equals("") &&
                firstName.equals("") &&
                lastName.equals("") &&
                password.equals("")&&
                confirmPassword.equals("");
    }

    @Override
    public void showErrorMessage() {

    }
}
