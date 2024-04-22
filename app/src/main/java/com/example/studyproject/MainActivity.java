package com.example.studyproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    Intent intent;
    ArrayList<Post> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        intent = getIntent();
        if(intent.hasExtra("post")){
            Post post = (Post) intent.getSerializableExtra("post");
            if (post != null) dbHelper.addPost(post);
        }
        if(intent.hasExtra("delete")){
            Post post = (Post) intent.getSerializableExtra("delete");
            if (post != null) dbHelper.DeleteOnePost(post);
        }
        if(intent.hasExtra("update")){
            Post post = (Post) intent.getSerializableExtra("update");
            if (post != null) dbHelper.UpdateOnePost(post);
        }


        dbHelper.getAllPosts();
        countries.addAll(dbHelper.getAllPosts());

        ListView countriesList = findViewById(R.id.PostsList);

        ArrayAdapter<Post> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, countries);

        countriesList.setAdapter(adapter);
        countriesList.setOnItemClickListener((adapterView, view, i, l) -> {
            Post p = countries.get(i);
            intent = new Intent(this, OnePostActivity.class);
            intent.putExtra("OnePost", p);
            startActivity(intent);
        });
    }

    public void addNewPost(View view) {
        intent = new Intent(this, CreatePost.class);
        startActivity(intent);
    }
}