package com.example.studyproject.ORMDB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.Nullable;

import com.example.studyproject.MainActivity;
import com.example.studyproject.Post;
import com.example.studyproject.User;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DBHelperORM extends OrmLiteSqliteOpenHelper {
    private PostDAO postDao = null;
    private UserDAO userDao = null;

    public UserDAO getUserDao() {
        if(userDao == null){
            try {
                userDao = new UserDAO(getConnectionSource(), User.class);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return userDao;
    }

    public PostDAO getPostDao(){
        if(postDao == null){
            try {
                postDao = new PostDAO(getConnectionSource(), Post.class);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return postDao;
    }


    public DBHelperORM(@Nullable Context context) {
        super(context, "StudyProjectORM.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, User.class);
            TableUtils.createTableIfNotExists(connectionSource, Post.class);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, User.class, true);
            TableUtils.dropTable(connectionSource, Post.class, true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
