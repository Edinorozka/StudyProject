package com.example.studyproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.LinkedList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String POSTS = "posts";
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String TEXT = "text";

    public DBHelper(@Nullable Context context) {
        super(context, "StudyProject.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + POSTS + " (" + ID + " text primary key, " + TITLE + " text, " + TEXT + " text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addPost(Post post){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(ID, post.id);
        cv.put(TITLE, post.title);
        cv.put(TEXT, post.text);
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

                Post post = new Post(cursor.getString(id_id), cursor.getString(id_title), cursor.getString(id_text));
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

}
