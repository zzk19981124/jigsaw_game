package com.example.jigsawgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.ImageView;

/*
 * 拼图数据帮助类，处理和view无关的业务
 * */
public class JigsawHelper {
    private static volatile JigsawHelper mInstance;    //instance 例子   ，引用类型变量，指向类

    public JigsawHelper() {
    }

    /*
     * synchronized   同步锁，线程访问该代码块，其他试图访问该对象的线程将被阻塞
     * */
    public static JigsawHelper getInstance() {
        if (mInstance == null) {
            synchronized (JigsawHelper.class) {
                if (mInstance == null) {
                    mInstance = new JigsawHelper();
                }
            }
        }
        return mInstance;
    }

    //获取拼图 (大图)
    public Bitmap getJigsaw(Context context) {
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.hand);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int screenWidth = getScreenWidth(context); //获取屏幕的宽度
        //按屏幕宽铺满显示，算出缩放比例
        float scale = 1.0f;
        if (bitmapWidth < screenWidth) {
            scale = (screenWidth * 1.0f) / bitmapWidth;   //filter
        }
        bitmap = Bitmap.createScaledBitmap(bitmap, screenWidth, (int) (bitmapHeight * scale), false);   //filter 过滤
        return bitmap;
    }

    //获取屏幕的宽度
    private int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    //判断当前 view是否在可移动范围之内 （在空白view的上下左右）                          （可能有问题）
    public boolean isNearByEmptyView(ImageView imageView, ImageView emptyView) {
        Jigsaw emptyJigsaw = (Jigsaw) imageView.getTag();   //getTag() 取出数据
        Jigsaw jigsaw = (Jigsaw) emptyView.getTag();   //cast 加
        if (emptyJigsaw != null && jigsaw != null) {
            //点击拼图在空拼图左边
            if (jigsaw.getOriginal_x() + 1 == emptyJigsaw.getOriginal_x() && jigsaw.getOriginal_y() == emptyJigsaw.getOriginal_y()) {
                return true;
            }
            //点击拼图在空拼图右边
            if (jigsaw.getOriginal_x() - 1 == emptyJigsaw.getOriginal_x() && jigsaw.getOriginal_y() == emptyJigsaw.getOriginal_y()) {
                return true;
            }
            //点击拼图在空拼图上边
            if (jigsaw.getOriginal_x() == emptyJigsaw.getOriginal_x() && jigsaw.getOriginal_y() + 1 == emptyJigsaw.getOriginal_y()) {
                return true;
            }
            //点击拼图在空拼图下边
            if (jigsaw.getOriginal_x() == emptyJigsaw.getOriginal_x() && jigsaw.getOriginal_y() - 1 == emptyJigsaw.getOriginal_y()) {
                return true;
            }
        }
        return false;
    }

    //判断游戏是否结束
    public boolean isFinishGame(ImageView[][] imageViews, ImageView emptyView) {
        int rightNum = 0;  //记录匹配拼图数
        for (int i = 0; i < imageViews.length; i++) {
            for (int j = 0; j < imageViews[0].length; j++) {
                if (imageViews[i][j] != emptyView) {
                    Jigsaw jigsaw = (Jigsaw) imageViews[i][j].getTag();
                    if (jigsaw != null) {
                        if (jigsaw.getOriginal_x() == jigsaw.getNow_x() && jigsaw.getOriginal_y() == jigsaw.getNow_y()) {
                            rightNum++;
                        }
                    }
                }
            }
        }
        if (rightNum == (imageViews.length * imageViews[0].length - 1)) {
            return true;
        }
        return false;
    }
}
