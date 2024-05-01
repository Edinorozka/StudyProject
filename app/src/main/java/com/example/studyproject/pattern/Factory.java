package com.example.studyproject.pattern;

import com.example.studyproject.pattern.Buttons.AddNewPostButton;
import com.example.studyproject.pattern.Buttons.AddPostButton;
import com.example.studyproject.pattern.Buttons.ChangeButton;
import com.example.studyproject.pattern.Buttons.ComeInChangeButton;
import com.example.studyproject.pattern.Buttons.ComeInRegButton;
import com.example.studyproject.pattern.Buttons.DeleteButton;
import com.example.studyproject.pattern.Buttons.LoginButton;
import com.example.studyproject.pattern.Buttons.RegButton;

public class Factory {
    public Button getCurrentButton(String buttonType) {
        Button button = null;
        switch (buttonType) {
            case "AddNewPost":
                button = new AddNewPostButton();
                break;
            case "RegButton":
                button = new RegButton();
                break;
            case "ComeInRegButton":
                button = new ComeInRegButton();
                break;
            case "LoginButton":
                button = new LoginButton();
                break;
            case "DeleteButton":
                button = new DeleteButton();
                break;
            case "ComeInChangeButton":
                button = new ComeInChangeButton();
                break;
            case "AddPostButton":
                button = new AddPostButton();
                break;
            case "ChangeButton":
                button = new ChangeButton();
                break;
        }

        return button;
    }
}
