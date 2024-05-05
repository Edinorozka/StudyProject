package com.example.studyproject;

import static org.junit.Assert.assertTrue;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

@RunWith(AndroidJUnit4.class)
public class DBHelperTest {
    DBHelper dbHelper;

    @Before
    public void Before(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        dbHelper = new DBHelper(appContext);
    }

    @After
    public void After(){
        dbHelper = null;
    }

    @Test
    public void DBFindUserTest() throws NoSuchAlgorithmException {
        User user = new User("User", "1234");
        dbHelper.addUser(user);
        assertTrue(dbHelper.FindUser(user));
    }

    @Test
    public void DBFindPostTest(){
        User user = new User("User", "1234");
        dbHelper.addUser(user);
        Post post = new Post("1", "post", "new post", "User");
        dbHelper.addPost(post);
        LinkedList<Post> list = new LinkedList<>();
        list.add(post);
        Assert.assertEquals(list.get(0).id, dbHelper.getAllPosts().get(0).id);
    }

    @Test
    public void DBFindNoPostTest(){
        Assert.assertEquals(new LinkedList<>(), dbHelper.getAllPosts());
    }
}
