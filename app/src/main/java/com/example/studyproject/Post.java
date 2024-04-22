package com.example.studyproject;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Post implements Serializable {
    String id;
    String title, text;

    @NonNull
    @Override
    public String toString() {
        return title;
    }

    public Post(String id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }
}
