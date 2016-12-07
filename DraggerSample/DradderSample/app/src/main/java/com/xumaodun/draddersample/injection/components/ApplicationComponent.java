package com.xumaodun.draddersample.injection.components;

import android.content.Context;

import com.xumaodun.draddersample.MyApplication;
import com.xumaodun.draddersample.api.weatherapi.WeatherApi;
import com.xumaodun.draddersample.injection.PerApp;
import com.xumaodun.draddersample.injection.modules.ApiModule;
import com.xumaodun.draddersample.injection.modules.ApplicationModule;
import com.xumaodun.draddersample.util.ToastUtils;

import dagger.Component;

/**
 * Created by xumaodun on 2016/12/6.
 *
 * @PerApp
 * 单例的有效范围随着其依附的Component，为了使得@PerApp的作用范围是整个Application
 *
 * 当使用ComponentA注入Container时，如果找不到对应的依赖，就会到ComponentB中查找。但是，
 * ComponentB必须显式把这些A找不到的依赖提供给A。怎么提供呢，只需要在ComponentB中添加方法即可
 */
@PerApp
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    Context getContext();

    // // 假设A中module中找不到，但是B的module有，B必须提供带返回值的方法如下
    //MainPresenter会调用ToastUtils
    ToastUtils getToastUtils();
    WeatherApi getWeatherApi();

    //Component就是一个将Module生成的实例注入Container中的注入器
    //将ApplicationModule注入.
    void inject(MyApplication mApplication);
}
