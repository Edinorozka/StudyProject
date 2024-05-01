package com.example.studyproject.pattern.Buttons;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.studyproject.CreatePost;
import com.example.studyproject.pattern.Button;

public class AddNewPostButton implements Button {
    @Override
    public void onClick(View view, Context context, Object object) {
        Intent intent = new Intent(context, CreatePost.class);
        String username = (String) object;
        intent.putExtra("username", username);
        context.startActivity(intent);
    }
}
