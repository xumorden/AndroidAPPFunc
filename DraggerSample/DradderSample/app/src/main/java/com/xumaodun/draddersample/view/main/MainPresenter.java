package com.xumaodun.draddersample.view.main;

import android.text.TextUtils;

import com.xumaodun.draddersample.api.BaseSubsribe;
import com.xumaodun.draddersample.api.weatherapi.WeatherApi;
import com.xumaodun.draddersample.config.ConstantApi;
import com.xumaodun.draddersample.injection.PerActivity;
import com.xumaodun.draddersample.model.WeatherResultBean;
import com.xumaodun.draddersample.util.ToastUtils;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by xumaodun on 2016/12/7.
 */
@PerActivity
public class MainPresenter implements MainContract.Presenter{

    private Subscription mSubscription;
    private WeatherResultBean.RetDataEntity retData;
    public final WeatherApi mWeatherApi;
    private MainContract.View mMainView;
    private  final ToastUtils mToastUtils;

    @Inject
    public MainPresenter(WeatherApi mWeatherApi, ToastUtils mToastUtils){
        this.mToastUtils = mToastUtils;
        this.mWeatherApi = mWeatherApi;
    }

    @Override
    public void getWeather(final String city) {
        if (TextUtils.isEmpty(city)) {
            mToastUtils.showToast("请输入城市:");
            return;
        }
        mSubscription =
                mWeatherApi.queryWeather(ConstantApi.baiduKey, city, new BaseSubsribe<WeatherResultBean>() {
            @Override
            public void onSuccess(WeatherResultBean result) {
                retData = result.getRetData();
                mMainView.showWeather(retData.getCity() + ":" + retData.getWeather() + ":" + retData.getDate());
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                mToastUtils.showToast("查询失败.");
                mMainView.showWeather("请输入正确城市!");
            }
        });
    }

    @Override
    public void attachView( MainContract.View view) {
        mMainView = view;
    }

    @Override
    public void detachView() {
        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
        mMainView = null;
    }
}
