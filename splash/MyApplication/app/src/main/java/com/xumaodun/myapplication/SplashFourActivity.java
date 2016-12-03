package com.xumaodun.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import me.wangyuwei.particleview.ParticleView;

public class SplashFourActivity extends Activity {

    private ParticleView pv_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_four);
        pv_logo = (ParticleView) findViewById(R.id.pv_logo);
        pv_logo.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                Intent intent = new Intent(SplashFourActivity.this, MainActivity.class);
                SplashFourActivity.this.startActivity(intent);
                SplashFourActivity.this.finish();
            }
        });
        pv_logo.startAnim();
    }
}
