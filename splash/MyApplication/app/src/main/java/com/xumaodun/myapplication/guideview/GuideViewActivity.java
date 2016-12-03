package com.xumaodun.myapplication.guideview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xumaodun.myapplication.R;
import com.xumaodun.myapplication.guideview.activity.FragActivity;
import com.xumaodun.myapplication.guideview.activity.FullActivity;
import com.xumaodun.myapplication.guideview.activity.SimpleGuideViewActivity;
import com.xumaodun.myapplication.guideview.activity.ViewActivity;

public class GuideViewActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnAty, mBtnFrag, mBtnView, mBtnFragView, mBtnMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_view);
        mBtnAty = (Button) findViewById(R.id.btn_aty);
        mBtnFrag = (Button) findViewById(R.id.btn_frag);
        mBtnFragView = (Button) findViewById(R.id.btn_frag_view);
        mBtnMore = (Button) findViewById(R.id.btn_more);
        mBtnView = (Button) findViewById(R.id.btn_view);
        mBtnAty.setOnClickListener(this);
        mBtnFrag.setOnClickListener(this);
        mBtnFragView.setOnClickListener(this);
        mBtnMore.setOnClickListener(this);
        mBtnView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_aty:
                //遮罩整个activity
                startActivity(new Intent(GuideViewActivity.this, FullActivity.class));
                break;
            case R.id.btn_frag:
                //遮罩整个fragment
                startActivity(new Intent(GuideViewActivity.this, FragActivity.class).putExtra("fragmentId",0));
                break;
            case R.id.btn_frag_view:
                //遮罩fragment中的某个view
                startActivity(new Intent(GuideViewActivity.this, FragActivity.class).putExtra("fragmentId",1));
                break;
            case R.id.btn_more:
                //单个页面多个遮罩
                startActivity(new Intent(GuideViewActivity.this, SimpleGuideViewActivity.class));
                break;
            case R.id.btn_view:
                //遮罩某个view
                startActivity(new Intent(GuideViewActivity.this, ViewActivity.class));
                break;
        }
    }
}
