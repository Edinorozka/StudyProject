package com.example.studyproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    ArrayList<String> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        Intent intent = getIntent();
        Post post = (Post) intent.getSerializableExtra("post");
        if (post != null) dbHelper.addPost(post);

        dbHelper.getAllPosts();
        for(Post p: dbHelper.getAllPosts()){
            countries.add(p.title);
        }

        ListView countriesList = findViewById(R.id.PostsList);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, countries);

        countriesList.setAdapter(adapter);
    }

    public void addNewPost(View view) {
        Intent intent = new Intent(this, CreatePost.class);
        startActivity(intent);
    }
}