package com.xumaodun.myapplication.guideview.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.xumaodun.myapplication.R;
import com.xumaodun.myapplication.guideview.component.MutiComponent;
import com.xumaodun.myapplication.guideview.ui.Guide;
import com.xumaodun.myapplication.guideview.ui.GuideBuilder;

public class ViewActivity extends AppCompatActivity {

    private LinearLayout ll_nearby, ll_view_group;
    Guide guide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_guide_view);
        ll_nearby = (LinearLayout) findViewById(R.id.ll_nearby);
        ll_view_group = (LinearLayout) findViewById(R.id.ll_view_group);
        ll_view_group.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Toast.makeText(ViewActivity.this, "show", Toast.LENGTH_SHORT).show();
            }
        });
        ll_nearby.post(new Runnable() {
            @Override public void run() {
                showGuideView();
            }
        });
    }

    public void showGuideView() {
        GuideBuilder builder = new GuideBuilder();
        builder.setTargetView(ll_nearby)
                .setFullingViewId(R.id.ll_view_group)
                .setAlpha(150)
                .setHighTargetCorner(20)
                .setHighTargetPadding(10)
                .setOverlayTarget(false)
                .setOutsideTouchable(false);
        builder.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
            @Override public void onShown() {
            }

            @Override public void onDismiss() {
            }
        });

        builder.addComponent(new MutiComponent());
        guide = builder.createGuide();
        guide.setShouldCheckLocInWindow(true);
        guide.show(this);
    }
}
