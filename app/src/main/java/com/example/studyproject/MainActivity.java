package com.example.studyproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.studyproject.ORMDB.DBHelperORM;
import com.example.studyproject.pattern.Button;
import com.example.studyproject.pattern.Factory;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static DBHelper dbHelper;

    public static DBHelperORM dbHelperORM;

    public ArrayList<Post> countries = new ArrayList<>();
    private static boolean auth = false;
    private static User user;

    public static DBHelper getDbHelper() {
        return dbHelper;
    }

    public static boolean getAuth() {
        return auth;
    }

    public static void setAuth(boolean auth) {
        MainActivity.auth = auth;
    }

    public static void setUser(User user) {
        MainActivity.user = user;
    }

    public static User getUser() {
        return user;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (dbHelperORM == null) dbHelperORM = OpenHelperManager.getHelper(this, DBHelperORM.class);
        if (auth) {
            dbHelperORM.getPostDao().addPost(new Post("post", "post", user.username));
            countries.addAll(dbHelperORM.getPostDao().getAllPosts());
            /*dbHelper.getAllPosts();
            countries.addAll(dbHelper.getAllPosts());*/
            createList();
        } else {
            Intent intent = new Intent(this, AuthActivity.class);
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
            Intent intent = new Intent(this, OnePostActivity.class);
            intent.putExtra("OnePost", p);
            startActivity(intent);
        });
    }

    public void addNewPost(View view) {
        Factory f = new Factory();
        Button button = f.getCurrentButton("AddNewPost");
        button.onClick(view, this, user.username);
    }
}