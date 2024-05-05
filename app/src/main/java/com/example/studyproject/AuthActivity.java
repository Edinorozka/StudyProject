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

public class AuthActivity extends AppCompatActivity {

    private User user;
    private EditText login, password;
    private static boolean flag = false;
    private TextView textView7;
    private final TextWatcher textWatcher = new TextWatcher() {
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
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        textView7 = findViewById(R.id.textView7);
        faildLogin(flag);

        TextView textView = findViewById(R.id.ToolbarTitle);
        textView.setText("Авторизация");

        login = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextPassword);
        login.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
    }

    public void ComeInReg(View view) {
        Factory f = new Factory();
        Button button = f.getCurrentButton("ComeInRegButton");
        button.onClick(view, this, null);
    }

    public TextView faildLogin(boolean flag){
        if (flag){
            textView7.setVisibility(View.VISIBLE);
            return textView7;
        }
        return textView7;
    }

    public void Login(View view) {
        login = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextPassword);

        if(!login.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
            Factory f = new Factory();
            Button button = f.getCurrentButton("LoginButton");
            button.onClick(view, this, user);
        } else {
            flag = true;
            faildLogin(flag);
        }
    }
}