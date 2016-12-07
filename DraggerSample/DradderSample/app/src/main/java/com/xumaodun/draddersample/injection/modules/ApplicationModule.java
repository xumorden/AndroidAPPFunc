package com.xumaodun.draddersample.injection.modules;

import android.content.Context;

import com.xumaodun.draddersample.MyApplication;
import com.xumaodun.draddersample.injection.PerApp;
import com.xumaodun.draddersample.util.ToastUtils;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xumaodun on 2016/12/6.
 */
@Module
public class ApplicationModule {

    //提供ToastUtils
    @PerApp @Provides
    ToastUtils provideToastUtils(Context mContext){
        return new ToastUtils(mContext);
    }

    //因为ToastUtils需要Context,所以提供Context
    @PerApp @Provides
    Context provideContext(){
        return myApplication.getApplicationContext();
    }

    //初始化Context
    private final MyApplication myApplication;

    //在MyApplication 的oncreate() 中会传入application
    public ApplicationModule(MyApplication application) {
        myApplication = application;
    }
}
