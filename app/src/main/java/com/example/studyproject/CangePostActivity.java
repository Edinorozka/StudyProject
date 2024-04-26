package com.example.studyproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CangePostActivity extends AppCompatActivity {
    Intent intent;
    Post post;
    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cange_post);
        TextView textView = findViewById(R.id.ToolbarTitle);
        textView.setText("Изменение поста");

        intent = getIntent();
        post = (Post) intent.getSerializableExtra("ChangePost");

        textView1 = findViewById(R.id.PostTitle1);
        textView1.setText(post.title);
        textView2 = findViewById(R.id.PostText1);
        textView2.setText(post.text);

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

    public void ChangePost(View view) {
        if (!textView1.getText().toString().isEmpty() && !textView2.getText().toString().isEmpty()) {
            post.title = textView1.getText().toString();
            post.text = textView2.getText().toString();
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("update", post);
        startActivity(intent);
    }
}