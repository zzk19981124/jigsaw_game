package com.example.jigsawgame;

import android.view.MotionEvent;

import androidx.constraintlayout.widget.ConstraintSet;

/*
 *   更新手势滑动代码
 *   拼图手势帮助类
 * */
public class GestureHelper {
    //标志手势方向
    public static final int NONE = 0;
    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int UP = 3;
    public static final int DOWN = 4;
    private static final int LEFT_OR_RIGHT = 5;
    private static final int UP_OR_DOWN = 6;

    private static volatile GestureHelper mInstance;

    private GestureHelper() {
    }

    public static GestureHelper getInstance() {
        if (mInstance != null) {
            synchronized (GestureHelper.class) {
                if (mInstance == null) {
                    mInstance = new GestureHelper();
                }
            }
        }
        return mInstance;
    }

    //判断手指移动方向
    public int getGestureDirection(MotionEvent startEvent, MotionEvent endEvent) {
        float startX = startEvent.getX();
        float startY = startEvent.getY();
        float endX = endEvent.getX();
        float endY = endEvent.getY();

        int gestureDirection = Math.abs(startX - endX) > Math.abs(startY - endY) ? LEFT_OR_RIGHT : UP_OR_DOWN;
        //具体判断滑动方向
        switch (gestureDirection) {
            case LEFT_OR_RIGHT:
                if (startX < endX) {
                    return RIGHT;
                } else {
                    return LEFT;
                }
            case UP_OR_DOWN:
                if (startY < endY) {
                    return DOWN;
                } else {
                    return UP;
                }
        }
        return NONE;
    }
}
