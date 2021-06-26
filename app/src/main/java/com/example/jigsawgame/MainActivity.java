package com.example.jigsawgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private boolean isAnimated; //动画是否在执行，避免快速点击导致动画重复执行
    private GridLayout mGridLayout;
    private ImageView emptyImageView;  //空白拼图碎片
    private GestureDetector mGestureDetector;    //用户手势检测
    //维护拼图碎片的集合
    private int[][] jigsawArray = new int[3][5];
    private ImageView[][] imageViews = new ImageView[3][5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jigsawProcess();    //拼图的逻辑判断
        initJigsaw();       //初始化拼图的碎片
    }

    private void initJigsaw() {
        //Bitmap jigsaw =
    }

    private void jigsawProcess(){
        mGestureDetector = new GestureDetector(this,new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                //判断手指滑动方向
                //int gestureDetector = GestureH
                return true;
            }
        });
    }
    //初始化拼图，打乱顺序
    private void randomJigsaw(){

    }
}