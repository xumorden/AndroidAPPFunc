package com.xumaodun.draddersample.view.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.xumaodun.draddersample.R;
import com.xumaodun.draddersample.injection.modules.ActivityModule;
import com.xumaodun.draddersample.view.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity
        implements View.OnClickListener, MainContract.View{

    @BindView(R.id.city)
    EditText mCity;
    @BindView(R.id.query)
    Button mQuery;
    @BindView(R.id.queryresult)
    TextView mQueryresult;

    @Inject
    MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainComponent.builder()
                .applicationComponent(getApplicationComponent())
                //如果需要传入特定的Module实例，可以使用有参构造器
                //如果Module只有有参构造器，则必须显式传入Module实例。
                .activityModule(new ActivityModule(this))
                .mainModule(new MainModule())
                .build()
                .inject(this);
        ButterKnife.bind(this);
        mMainPresenter.attachView(this);
        mQuery.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        mMainPresenter.getWeather(mCity.getText().toString());
    }

    @Override
    public void showWeather(String weather) {
        mQueryresult.setText(weather);
    }

}
