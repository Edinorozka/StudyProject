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

import com.example.studyproject.pattern.Button;
import com.example.studyproject.pattern.Factory;

public class OnePostActivity extends AppCompatActivity {

    Intent intent;
    Post post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_post);

        intent = getIntent();
        post = (Post) intent.getSerializableExtra("OnePost");

        TextView textView = findViewById(R.id.ToolbarTitle);
        textView.setText(post.title);
        TextView textView1 = findViewById(R.id.PostText);
        textView1.setText(post.text);
        TextView textView2 = findViewById(R.id.authorTextView);
        textView2.setText(post.author);

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

    public void DeleteClick(View view) {
        Factory f = new Factory();
        Button button = f.getCurrentButton("DeleteButton");
        button.onClick(view, this, post);
    }

    public void ChangeClick(View view) {
        Factory f = new Factory();
        Button button = f.getCurrentButton("ComeInChangeButton");
        button.onClick(view, this, post);
    }
}