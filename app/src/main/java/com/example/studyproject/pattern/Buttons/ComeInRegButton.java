package com.example.studyproject.pattern.Buttons;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.studyproject.MainActivity;
import com.example.studyproject.RegActivity;
import com.example.studyproject.pattern.Button;

public class ComeInRegButton implements Button {
    @Override
    public void onClick(View view, Context context, Object object) {
        Intent intent = new Intent(context, RegActivity.class);
        context.startActivity(intent);
    }
}
