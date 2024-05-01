package com.example.studyproject;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Serializable {
    public String username;
    String password;

    @NonNull
    @Override
    public String toString() {
        return username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
