package com.example.jigsawgame;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.GestureDetector;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private boolean isAnimated; //动画是否在执行，避免快速点击导致动画重复执行
    private GridLayout mGridLayout;
    private ImageView emptyImageView;  //空白拼图碎片
    private GestureDetector mGestureDetector;    //用户手势检测
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}