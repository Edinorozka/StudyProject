package com.example.studyproject.ORMDB;

import com.example.studyproject.Post;
import com.example.studyproject.User;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

public class DBconf extends OrmLiteConfigUtil {

    public static final Class<?>[] classes = new Class[]{User.class, Post.class};
    public static void main(String[] args) throws SQLException, IOException {
        writeConfigFile("ormlite_config", classes);
    }
}
