package com.example.studyproject.ORMDB;

import com.example.studyproject.User;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;

public class UserDAO extends BaseDaoImpl<User, Integer> {

    protected UserDAO(ConnectionSource connectionSource, Class<User> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public void addUser(User user){
        try {
            this.create(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean getUser(User user){
        try {
            return this.queryBuilder().where().eq(User.USERNAME, user.username) != null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}