package com.example.studyproject;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Post implements Serializable {
    String id;
    String title, text, author;

    @NonNull
    @Override
    public String toString() {
        return title;
    }

    public Post(String id, String title, String text, String author) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.author = author;
    }
}
