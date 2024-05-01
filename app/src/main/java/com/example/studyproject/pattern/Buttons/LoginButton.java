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
        try {
            System.out.println(MainActivity.getAuth());
            MainActivity.setAuth(MainActivity.getDbHelper().FindUser(user));
            System.out.println(MainActivity.getAuth());
            if (MainActivity.getAuth()){
                MainActivity.setUser(user);
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        context.startActivity(intent);
    }
}
