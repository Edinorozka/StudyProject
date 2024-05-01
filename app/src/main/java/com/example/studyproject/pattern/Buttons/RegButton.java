package com.example.studyproject.pattern.Buttons;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.example.studyproject.MainActivity;
import com.example.studyproject.User;
import com.example.studyproject.pattern.Button;

public class RegButton implements Button {
    @Override
    public void onClick(View view, Context context, Object object) {
        Intent intent = new Intent(context, MainActivity.class);
        User user = (User) object;
        MainActivity.getDbHelper().addUser(user);
        context.startActivity(intent);
    }
}
