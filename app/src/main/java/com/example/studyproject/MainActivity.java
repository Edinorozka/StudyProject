package com.example.studyproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    Intent intent;
    ArrayList<Post> countries = new ArrayList<>();
    static boolean auth = false;

    static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        intent = getIntent();
        if(intent.hasExtra("login")){
            user = (User) intent.getSerializableExtra("login");
            try {
                auth = dbHelper.FindUser(user);
            } catch (NoSuchAlgorithmException e) {
                System.out.println(e);
            }
        }
        if(intent.hasExtra("user")) {
            User user = (User) intent.getSerializableExtra("user");
            if (user != null) dbHelper.addUser(user);
        }
        if(intent.hasExtra("post")){
            Post post = (Post) intent.getSerializableExtra("post");
            if (post != null) dbHelper.addPost(post);
        }
        if(intent.hasExtra("delete")){
            Post post = (Post) intent.getSerializableExtra("delete");
            if (post != null) dbHelper.DeleteOnePost(post);
        }
        if(intent.hasExtra("update")) {
            Post post = (Post) intent.getSerializableExtra("update");
            if (post != null) dbHelper.UpdateOnePost(post);
        }
        if (auth) {
            dbHelper.getAllPosts();
            countries.addAll(dbHelper.getAllPosts());
            createList();
        } else {
            intent = new Intent(this, AuthActivity.class);
            startActivity(intent);
        }


        SearchView searchView = findViewById(R.id.searchPosts);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // Действия после нажатия ввод
            @Override
            public boolean onQueryTextSubmit(String s) {
                countries = new ArrayList<>();
                countries.addAll(dbHelper.FindPosts(s));
                createList();
                return false;
            }

            // Действия после каждого нажатия
            @Override
            public boolean onQueryTextChange(String s) {
                countries = new ArrayList<>();
                countries.addAll(dbHelper.FindPosts(s));
                createList();
                return false;
            }
        });
    }

    public void createList(){
        ListView countriesList = findViewById(R.id.PostsList);
        countriesList.setAdapter(null);

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
        intent.putExtra("username", user.username);
        startActivity(intent);
    }
}