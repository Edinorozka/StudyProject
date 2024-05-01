package com.example.studyproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        TextView textView = findViewById(R.id.ToolbarTitle);
        textView.setText("Авторизация");
    }

    public void ComeInReg(View view) {
        Intent intent = new Intent(this, RegActivity.class);
        startActivity(intent);
    }

    public void Login(View view) {
        EditText login = findViewById(R.id.editTextText);
        EditText password = findViewById(R.id.editTextPassword);
        if(!login.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
            User user = new User(login.getText().toString(), password.getText().toString());
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("login", user);
            startActivity(intent);
        }
    }
}