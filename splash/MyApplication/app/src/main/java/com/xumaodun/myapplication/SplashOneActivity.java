package com.xumaodun.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xumaodun.myapplication.utils.CommonUtils;

import java.util.Random;

public class SplashOneActivity extends BaseActivity {

    private TextView mTitleText;
    private TextView mVersionText;
    private RelativeLayout mRootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_one);
        hideStatusBar();
        mRootLayout = (RelativeLayout) findViewById(R.id.content);
        Random random = new Random();
        int num = random.nextInt(4);
        int drawable = R.mipmap.pic_background_1;
        switch (num ){
            case 0:
                break;
            case 1:
                drawable = R.mipmap.pic_background_2;
                break;
            case 2:
                drawable = R.mipmap.pic_background_3;
                break;
            case 3:
                drawable = R.mipmap.pic_background_4;
                break;
        }
        mRootLayout.setBackgroundDrawable(getResources().getDrawable(drawable));
        Animation animImage = AnimationUtils.loadAnimation(this,R.anim.image_welcome);
        mRootLayout.startAnimation(animImage);
        animImage.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //动画结束时打开首页
                startActivity(new Intent(SplashOneActivity.this,MainActivity.class));
                overridePendingTransition(R.anim.activity_slide_in, R.anim.no_anim);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        mTitleText = (TextView) findViewById(R.id.title_text);
        mVersionText = (TextView) findViewById(R.id.version_text);
        mVersionText.setText("版本："+ CommonUtils.getVersion(this));
    }

    private void hideStatusBar() {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

}
