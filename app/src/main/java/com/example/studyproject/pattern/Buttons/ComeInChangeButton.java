package com.example.studyproject.pattern.Buttons;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.example.studyproject.CangePostActivity;
import com.example.studyproject.Post;
import com.example.studyproject.pattern.Button;

public class ComeInChangeButton implements Button {
    @Override
    public void onClick(View view, Context context, Object object) {
        Intent intent = new Intent(context, CangePostActivity.class);
        intent.putExtra("ChangePost", (Post) object);
        context.startActivity(intent);
    }
}
