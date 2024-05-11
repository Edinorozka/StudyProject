package com.example.studyproject.pattern.Buttons;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.studyproject.MainActivity;
import com.example.studyproject.User;
import com.example.studyproject.pattern.Button;

import java.security.NoSuchAlgorithmException;

public class LoginButton implements Button {
    @Override
    public void onClick(View view, Context context, Object object) {
        User user = (User) object;
        Intent intent = new Intent(context, MainActivity.class);
        MainActivity.setAuth(MainActivity.dbHelperORM.getUserDao().getUser(user));
        if (MainActivity.getAuth()){
            MainActivity.setUser(user);
            context.startActivity(intent);
        }
        /*try {
            //MainActivity.setAuth(MainActivity.getDbHelper().FindUser(user));
            if (MainActivity.getAuth()){
                MainActivity.setUser(user);
                context.startActivity(intent);
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }*/

    }

    @Override
    public String getButtonType() {
        return "LoginButton";
    }
}
