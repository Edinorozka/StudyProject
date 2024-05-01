package com.example.studyproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.studyproject.pattern.Button;
import com.example.studyproject.pattern.Factory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AuthActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        TextView textView = findViewById(R.id.ToolbarTitle);
        textView.setText("Авторизация");

        EditText login = findViewById(R.id.editTextText);
        EditText password = findViewById(R.id.editTextPassword);
        login.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!login.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
                    MessageDigest md5 = null;
                    try {
                        md5 = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                    byte[] bytes = md5.digest(password.getText().toString().getBytes());
                    StringBuilder builder = new StringBuilder();
                    for (byte b: bytes){
                        builder.append(String.format("%02X", b));
                    }
                    user = new User(login.getText().toString(), builder.toString());
                }
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!login.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
                    MessageDigest md5 = null;
                    try {
                        md5 = MessageDigest.getInstance("MD5");
                    } catch (NoSuchAlgorithmException e) {
                        throw new RuntimeException(e);
                    }
                    byte[] bytes = md5.digest(password.getText().toString().getBytes());
                    StringBuilder builder = new StringBuilder();
                    for (byte b: bytes){
                        builder.append(String.format("%02X", b));
                    }
                    user = new User(login.getText().toString(), builder.toString());
                }
            }
        });
    }

    public void ComeInReg(View view) {
        Factory f = new Factory();
        Button button = f.getCurrentButton("ComeInRegButton");
        button.onClick(view, this, null);
    }

    public void Login(View view) {
        EditText login = findViewById(R.id.editTextText);
        EditText password = findViewById(R.id.editTextPassword);
        if(!login.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
            Factory f = new Factory();
            Button button = f.getCurrentButton("LoginButton");
            button.onClick(view, this, user);
        }
    }
}