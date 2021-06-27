package com.example.jigsawgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

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
        //初始化拼图的碎片
        Bitmap jigsaw = JigsawHelper.getInstance().getJigsaw(this);
        initJigsaw(jigsaw);
        new Handler().postDelayed(new Runnable() {  //postDelayed  推迟
            @Override
            public void run() {
                randomJigsaw();
            }
        },200);
    }

    private void initJigsaw(Bitmap bitmapJigsaw) {
        mGridLayout = findViewById(R.id.gl_layout);
        //获得切割后每个小碎片的长宽
        int itemWidth = bitmapJigsaw.getWidth() /5;
        int itemHeight = bitmapJigsaw.getHeight() / 3;
        //切割原图为拼图碎片装入网格布局里
        for (int i = 0;i<jigsawArray.length;i++){
            for (int j = 0;j<jigsawArray[0].length;j++){
                Bitmap bitmap = Bitmap.createBitmap(bitmapJigsaw,j*itemWidth,i*itemHeight,itemWidth,itemHeight);
                ImageView imageView = new ImageView(this);
                imageView.setImageBitmap(bitmap);
                imageView.setPadding(2,2,2,2);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //判断是否可以移动
                        boolean isNearBy = JigsawHelper.getInstance().isNearByEmptyView((ImageView) v,emptyImageView);
                        if (isNearBy){
                            //处理移动
                            handleClickItem((ImageView) v,true);
                        }
                    }
                });
                //绑定数据
                imageView.setTag(new Jigsaw(bitmap,j,i));
                //添加到拼图布局
                imageViews[i][j] = imageView;
                mGridLayout.addView(imageView);
            }
        }
        //设置拼图空碎片
        ImageView imageView = (ImageView) mGridLayout.getChildAt(mGridLayout.getChildCount()-1);
        imageView.setImageBitmap(null);
        emptyImageView = imageView;
    }

    private void jigsawProcess() {
        mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                //判断手指滑动方向
                //int gestureDetector = GestureH
                return true;
            }
        });
    }

    //初始化拼图，打乱顺序
    private void randomJigsaw() {

    }
    //处理拼图间的移动
    private void handleClickItem(final ImageView imageView,boolean animation){
        if (animation){
            handleClickItem(imageView);
        }else{

        }
    }
    //处理点击拼图的移动事件
    private void handleClickItem(final ImageView imageView){
        if (isAnimated){
            TranslateAnimation translateAnimation  = null;   //TranslateAnimation  平移动画
            if (imageView.getX() < emptyImageView.getX()){
                //左往右
                translateAnimation = new TranslateAnimation(0,imageView.getWidth(),0,0);
            }
            if (imageView.getX() >emptyImageView.getX()) {
                //右往左
                translateAnimation = new TranslateAnimation(0,-imageView.getWidth(),0,0);
            }
            if (imageView.getY() >emptyImageView.getY()) {
                //上往下
                translateAnimation = new TranslateAnimation(0,0,0,imageView.getHeight());
            }
            if (imageView.getX() >emptyImageView.getX()) {
                //下往上
                translateAnimation = new TranslateAnimation(0,-imageView.getWidth(),0,-imageView.getHeight());
            }
            if (translateAnimation != null){
                translateAnimation.setDuration(80);
                translateAnimation.setFillAfter(true);
                translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        isAnimated = true;
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //清除动画
                        isAnimated = false;
                        imageView.clearAnimation();
                        //交换拼图数据
                        changeJigsawData(imageView);
                        //判断游戏是否结束
                        boolean isFinish = JigsawHelper.getInstance().isFinishGame(imageViews,emptyImageView);
                        if(isFinish){
                            Toast.makeText(MainActivity.this,"拼图成功，游戏结束！",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                imageView.startAnimation(translateAnimation);
            }
        }
    }
    //交换拼图数据
    public void changeJigsawData(ImageView imageView){
        Jigsaw emptyJigsaw = (Jigsaw) emptyImageView.getTag();
        Jigsaw jigsaw = (Jigsaw) imageView.getTag();
        //更新imageView的显示内容
        emptyImageView.setImageBitmap(jigsaw.getBitmap());
        imageView.setImageBitmap(null);
        //交换数据
        emptyJigsaw.setNow_x(jigsaw.getNow_x());
        emptyJigsaw.setNow_y(jigsaw.getOriginal_y());
        emptyJigsaw.setBitmap(jigsaw.getBitmap());
        //更新空拼图引用
        emptyImageView = imageView;
    }
    //处理手势移动拼图
    private void handleFlingGesture(int gestureDirection, boolean animation){
        ImageView imageView = null;
        Jigsaw emptyJigsaw  = (Jigsaw) emptyImageView.getTag();
        switch (gestureDirection){
            case GestureHelper.LEFT:
                //if (emptyJigsaw.get)
                break;
            default:
                break;
        }
        if (imageView !=null){
            handleClickItem(imageView,animation);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }
}































































