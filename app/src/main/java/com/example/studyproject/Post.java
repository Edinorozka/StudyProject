package com.example.studyproject;

import java.io.Serializable;

public class Post implements Serializable {
    String id;
    String title, text;

    public Post(String id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }
}
