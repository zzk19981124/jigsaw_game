package com.example.jigsawgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridLayout;

public class TestActivity extends AppCompatActivity {
    private GridLayout mGridLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        mGridLayout = findViewById(R.id.gl_layout);

    }
}