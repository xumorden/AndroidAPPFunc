package com.xumaodun.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.xumaodun.myapplication.ui.SplashView;

public class SplashTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_two);

        // call after setContentView(R.layout.activity_sample);
        SplashView.showSplashView(this, 6, R.mipmap.default_img, new SplashView.OnSplashViewActionListener() {
            @Override
            public void onSplashImageClick(String actionUrl) {
                Log.d("SplashView", "img clicked. actionUrl: " + actionUrl);
                Toast.makeText(SplashTwoActivity.this, "img clicked.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSplashViewDismiss(boolean initiativeDismiss) {
                Log.d("SplashView", "dismissed, initiativeDismiss: " + initiativeDismiss);
                Intent mItent = new Intent(SplashTwoActivity.this, MainActivity.class);
                startActivity(mItent);
            }
        });

        // call this method anywhere to update splash view data
        SplashView.updateSplashData(this, "http://ww2.sinaimg.cn/large/72f96cbagw1f5mxjtl6htj20g00sg0vn.jpg", "http://baidu.com");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}
