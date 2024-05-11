package com.example.studyproject;

import androidx.annotation.NonNull;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "posts")
public class Post implements Serializable {
    @DatabaseField(generatedId = true)
    int id;
    @DatabaseField(dataType = DataType.STRING)
    String title;
    @DatabaseField(dataType = DataType.STRING)
    String text;
    @DatabaseField(dataType = DataType.STRING)
    String author;

    @NonNull
    @Override
    public String toString() {
        return title;
    }
    public Post() {
    }

    public Post(String title, String text, String author) {
        this.title = title;
        this.text = text;
        this.author = author;
    }
}
