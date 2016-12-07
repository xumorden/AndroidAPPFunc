package com.xumaodun.draddersample.view.main;

import com.xumaodun.draddersample.view.BasePresenter;
import com.xumaodun.draddersample.view.BaseView;

/**
 * Created by xumaodun on 2016/12/7.
 * 对MainActivity的抽取.
 */
public interface MainContract {

    //对MainActivity UI的抽取.
    interface View extends BaseView {
        void showWeather(String weather);
    }

    //对MainActivity 业务逻辑的抽取.
    interface Presenter extends BasePresenter<View> {
        void getWeather(String city);
    }
}
