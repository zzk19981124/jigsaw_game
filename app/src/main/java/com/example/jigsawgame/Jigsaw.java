package com.example.jigsawgame;

import android.graphics.Bitmap;

/**
 * @author hello word
 * @desc 拼图实体类
 * @date 2021/6/25
 */
public class Jigsaw {
    private Bitmap mBitmap;
    private int original_x;
    private int original_y;
    private int now_x;
    private int now_y;

    public Jigsaw(){
    }

    public Jigsaw(Bitmap bitmap, int original_x, int original_y, int now_x, int now_y) {
        mBitmap = bitmap;
        this.original_x = original_x;
        this.original_y = original_y;
        this.now_x = now_x;
        this.now_y = now_y;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        mBitmap = bitmap;
    }

    public int getOriginal_x() {
        return original_x;
    }

    public void setOriginal_x(int original_x) {
        this.original_x = original_x;
    }

    public int getOriginal_y() {
        return original_y;
    }

    public void setOriginal_y(int original_y) {
        this.original_y = original_y;
    }

    public int getNow_x() {
        return now_x;
    }

    public void setNow_x(int now_x) {
        this.now_x = now_x;
    }

    public int getNow_y() {
        return now_y;
    }

    public void setNow_y(int now_y) {
        this.now_y = now_y;
    }

    @Override
    public String toString() {
        return "Jigsaw{" +
                "mBitmap=" + mBitmap +
                ", original_x=" + original_x +
                ", original_y=" + original_y +
                ", now_x=" + now_x +
                ", now_y=" + now_y +
                '}';
    }
}
