package com.example.studyproject.ORMDB;

import com.example.studyproject.Post;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;
import java.util.List;

public class PostDAO extends BaseDaoImpl<Post, Integer> {

    protected PostDAO(ConnectionSource connectionSource, Class<Post> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public void addPost(Post post){
        try {
            this.create(post);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Post> getAllPosts(){
        try {
            return this.queryForAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
