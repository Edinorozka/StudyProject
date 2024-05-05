package com.example.studyproject.pattern.Buttons;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.example.studyproject.MainActivity;
import com.example.studyproject.Post;
import com.example.studyproject.pattern.Button;

public class AddPostButton implements Button {
    @Override
    public void onClick(View view, Context context, Object object) {
        Intent intent = new Intent(context, MainActivity.class);
        MainActivity.getDbHelper().addPost((Post) object);
        context.startActivity(intent);
    }

    @Override
    public String getButtonType() {
        return "AddPostButton";
    }
}
