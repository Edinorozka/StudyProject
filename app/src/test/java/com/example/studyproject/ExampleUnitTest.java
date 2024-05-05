package com.example.studyproject;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import com.example.studyproject.pattern.Button;
import com.example.studyproject.pattern.Buttons.LoginButton;
import com.example.studyproject.pattern.Factory;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void GetButton(){
        Post post = new Post("1", "Post", "this is a post", null);
        Assert.assertEquals("Post", post.toString());
    }
}