package com.xumaodun.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xumaodun.myapplication.guideview.GuideViewActivity;

public class MainActivity extends AppCompatActivity {

    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void splashOne(View view){
        mIntent = new Intent(this, SplashOneActivity.class);
        startActivity(mIntent);
    }

    public void splashTwo(View view){
        mIntent = new Intent(this, SplashTwoActivity.class);
        startActivity(mIntent);
    }
    public void splashThree(View view){
        mIntent = new Intent(this, SplashThreeActivity.class);
        startActivity(mIntent);
    }

    public void splashFour(View view){
        mIntent = new Intent(this, SplashFourActivity.class);
        startActivity(mIntent);
    }
    public void guideView(View view){
        mIntent = new Intent(this, GuideViewActivity.class);
        startActivity(mIntent);
    }
}
