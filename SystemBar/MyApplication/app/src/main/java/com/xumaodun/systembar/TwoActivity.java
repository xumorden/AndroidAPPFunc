package com.xumaodun.systembar;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.xumaodun.systembar.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TwoActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.bind(this);
        initToolBar(mToolbar, true, "透明覆盖状态栏");
    }

    @Override
    protected boolean isSystemBarTranslucent() {
        return true;
    }
}
