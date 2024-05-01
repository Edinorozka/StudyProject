package com.example.studyproject;

import android.content.Intent;
import android.os.Bundle;
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

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class CreatePost extends AppCompatActivity {
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        Intent intent = getIntent();
        username = (String) intent.getSerializableExtra("login");

        TextView textView = findViewById(R.id.ToolbarTitle);
        textView.setText("Создание поста");

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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
            Post post = new Post(UUID.randomUUID().toString(), title.getText().toString(), text.getText().toString(), username);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("post", post);
            startActivity(intent);
        }
    }
}