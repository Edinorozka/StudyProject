package com.example.studyproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.studyproject.pattern.Button;
import com.example.studyproject.pattern.Factory;

import org.jetbrains.annotations.NotNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class CreatePost extends AppCompatActivity {
    private String username;
    private Post post;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        Intent intent = getIntent();
        username = (String) intent.getSerializableExtra("username");

        TextView textView = findViewById(R.id.ToolbarTitle);
        textView.setText("Создание поста");

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        EditText title = findViewById(R.id.PostTitle);
        EditText text = findViewById(R.id.PostText);

        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!title.getText().toString().isEmpty() && !text.getText().toString().isEmpty()){
                    post = new Post(UUID.randomUUID().toString(), title.getText().toString(), text.getText().toString(), username);
                }
            }
        });
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!title.getText().toString().isEmpty() && !text.getText().toString().isEmpty()){
                    post = new Post(UUID.randomUUID().toString(), title.getText().toString(), text.getText().toString(), username);
                }
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        this.finish();
        return super.onOptionsItemSelected(item);
    }

    public void AddPost(View view) {
        EditText title = findViewById(R.id.PostTitle);
        EditText text = findViewById(R.id.PostText);
        if (!title.getText().toString().isEmpty() && !text.getText().toString().isEmpty()){
            Factory f = new Factory();
            Button button = f.getCurrentButton("AddPostButton");
            button.onClick(view, this, post);
        }
    }
}