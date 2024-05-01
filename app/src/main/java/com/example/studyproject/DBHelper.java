package com.example.studyproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class DBHelper extends SQLiteOpenHelper {
    private static final String USER = "user";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String POSTS = "posts";
    private static final String ID = "_id";
    private static final String TITLE = "title";
    private static final String TEXT = "text";
    private static final String AUTHOR = "author";

    public DBHelper(@Nullable Context context) {
        super(context, "StudyProject.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table if not exists " + USER + " (" + USERNAME + " text primary key," + PASSWORD + " text);");
        db.execSQL("CREATE TABLE if not exists " + POSTS + " (" + ID + " text primary key, " + TITLE + " text, " + TEXT + " text," + AUTHOR + " text references " + USER + "(" + USERNAME + "));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(USERNAME, user.username);
        cv.put(PASSWORD, user.password);
        db.insert(USER, null, cv);

        db.close();
    }

    public boolean FindUser(User user) throws NoSuchAlgorithmException {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;
        if (user != null){
            cursor = db.rawQuery("select * from " + USER + " where " + USERNAME + " =  ?", new String[]{user.username});
            if(cursor != null){
                if(cursor.moveToFirst()) {
                    cursor.moveToFirst();
                    int id_username = cursor.getColumnIndex(USERNAME);
                    int id_password = cursor.getColumnIndex(PASSWORD);
                    User findUser = new User(cursor.getString(id_username), cursor.getString(id_password));
                    if (Objects.equals(findUser.password, user.password)) {
                        db.close();
                        return true;
                    }
                }
            }
        }
        db.close();
        return false;
    }

    public void addPost(Post post){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(ID, post.id);
        cv.put(TITLE, post.title);
        cv.put(TEXT, post.text);
        cv.put(AUTHOR, post.author);
        db.insert(POSTS, null, cv);

        db.close();
    }

    public LinkedList<Post> getAllPosts(){
        LinkedList<Post> list = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(POSTS, null, null, null, null, null, null);

        if (cursor.moveToFirst()){
            do {
                int id_id = cursor.getColumnIndex(ID);
                int id_title = cursor.getColumnIndex(TITLE);
                int id_text = cursor.getColumnIndex(TEXT);
                int id_author = cursor.getColumnIndex(AUTHOR);

                Post post = new Post(cursor.getString(id_id), cursor.getString(id_title), cursor.getString(id_text), cursor.getString(id_author));
                list.add(post);

            } while (cursor.moveToNext());
        }

        db.close();
        return list;
    }

    public void DeleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(POSTS, null, null);
        db.close();
    }

    public void DeleteOnePost(Post post){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(POSTS,   ID + "='" + post.id + "'", null);
        db.close();
    }

    public void UpdateOnePost(Post post){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ID , post.id);
        cv.put(TITLE , post.title);
        cv.put(TEXT , post.text);
        db.update(POSTS, cv, ID + "='" + post.id + "'", null);
        db.close();
    }

    public LinkedList<Post> FindPosts(String string){
        LinkedList<Post> list = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;
        if (!string.isEmpty()){
            cursor = db.rawQuery("select * from " + POSTS + " where " + TITLE + " like ?", new String[]{"%" + string + "%"});
        } else {
            cursor = db.rawQuery("select * from " + POSTS, null);
        }

        if (cursor.moveToFirst()){
            do {
                int id_id = cursor.getColumnIndex(ID);
                int id_title = cursor.getColumnIndex(TITLE);
                int id_text = cursor.getColumnIndex(TEXT);
                int id_author = cursor.getColumnIndex(AUTHOR);

                Post post = new Post(cursor.getString(id_id), cursor.getString(id_title), cursor.getString(id_text), cursor.getString(id_author));
                list.add(post);

            } while (cursor.moveToNext());
        }
        db.close();
        return list;
    }

}
