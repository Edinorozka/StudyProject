package com.example.studyproject.pattern.Buttons;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.studyproject.MainActivity;
import com.example.studyproject.Post;
import com.example.studyproject.pattern.Button;

public class ChangeButton implements Button {
    @Override
    public void onClick(View view, Context context, Object object) {
        MainActivity.getDbHelper().UpdateOnePost((Post) object);
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
}
