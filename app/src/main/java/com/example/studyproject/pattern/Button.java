package com.example.studyproject.pattern;

import android.content.Context;
import android.view.View;

public interface Button {
    void onClick(View view, Context context, Object object);
    String getButtonType();
}
