package com.example.studyproject;

import androidx.annotation.NonNull;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "user")
public class User implements Serializable {
    public static final String USERNAME = "username";
    @DatabaseField(canBeNull = false, dataType = DataType.STRING) public String username;
    @DatabaseField(canBeNull = false, dataType = DataType.STRING)String password;

    @NonNull
    @Override
    public String toString() {
        return username;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
