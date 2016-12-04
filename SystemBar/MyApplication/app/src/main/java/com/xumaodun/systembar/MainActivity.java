package com.xumaodun.systembar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_one) Button mBtnoOne;
    @BindView(R.id.btn_two) Button mBtnoTwo;
    @BindView(R.id.btn_three) Button mBtnoThree;
    @BindView(R.id.btn_four) Button mBtnoFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_one, R.id.btn_two, R.id.btn_three, R.id.btn_four})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                startActivity(new Intent(MainActivity.this, OneActivity.class));
                break;
            case R.id.btn_two:
                startActivity(new Intent(MainActivity.this, TwoActivity.class));
                break;
            case R.id.btn_three:
                startActivity(new Intent(MainActivity.this, ThreeActivity.class));
                break;
            case R.id.btn_four:
                startActivity(new Intent(MainActivity.this, FourActivity.class));
                break;
        }
    }
}
