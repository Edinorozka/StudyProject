package com.example.studyproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.UUID;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        TextView textView = findViewById(R.id.ToolbarTitle);
        textView.setText("Регистрация");
    }

    public void ButtonReg(View view) throws NoSuchAlgorithmException {
        EditText login = findViewById(R.id.Login);
        EditText password = findViewById(R.id.Password);
        if(!login.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(password.getText().toString().getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b: bytes){
                builder.append(String.format("%02X", b));
            }
            System.out.println(login.getText().toString() + " " + builder);
            User user = new User(login.getText().toString(), builder.toString());
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);
        }
    }
}