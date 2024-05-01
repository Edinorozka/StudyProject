package com.example.studyproject;

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

public class RegActivity extends AppCompatActivity {

    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        TextView textView = findViewById(R.id.ToolbarTitle);
        textView.setText("Регистрация");

        EditText login = findViewById(R.id.Login);
        login.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                EditText password = findViewById(R.id.Password);
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
        EditText password = findViewById(R.id.Password);
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

    public void ButtonReg(View view) throws NoSuchAlgorithmException {
        EditText login = findViewById(R.id.Login);
        EditText password = findViewById(R.id.Password);
        if(!login.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
            System.out.println(user.username + " " + user.password);
            Factory f = new Factory();
            Button button = f.getCurrentButton("RegButton");
            button.onClick(view, this, user);
        }
    }
}