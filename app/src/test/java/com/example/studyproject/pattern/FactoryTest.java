package com.example.studyproject.pattern;

import com.example.studyproject.pattern.Buttons.AddNewPostButton;

import org.junit.Assert;
import org.junit.Test;

public class FactoryTest {

    @Test
    public void getCurrentButton() {
        Factory factory = new Factory();
        Button button = new AddNewPostButton();
        Assert.assertEquals(button.getButtonType(), factory.getCurrentButton("AddNewPost").getButtonType());
    }
}