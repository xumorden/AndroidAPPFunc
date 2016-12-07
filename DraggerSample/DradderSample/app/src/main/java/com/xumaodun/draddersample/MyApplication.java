package com.xumaodun.draddersample;

import android.app.Application;

import com.xumaodun.draddersample.injection.components.ApplicationComponent;
import com.xumaodun.draddersample.injection.components.DaggerApplicationComponent;
import com.xumaodun.draddersample.injection.modules.ApplicationModule;

/**
 * Created by xumaodun on 2016/12/6.
 * @PerApp
 * 单例的有效范围随着其依附的Component，为了使得@PerApp的作用范围是整个Application
 */
public class MyApplication extends Application{

    // 注意是静态
    private static ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent =
        DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    //供给调用
    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

}
