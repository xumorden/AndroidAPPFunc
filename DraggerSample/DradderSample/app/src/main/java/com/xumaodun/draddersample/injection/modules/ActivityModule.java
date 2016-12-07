package com.xumaodun.draddersample.injection.modules;

import android.app.Activity;

import com.xumaodun.draddersample.injection.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xumaodun on 2016/12/7.
 */
@Module
public class ActivityModule {
    private final Activity mActivity;

    public ActivityModule(Activity mActivity){
        this.mActivity = mActivity;
    }

    //提供mActivity. 而mActivity是由构造函数提供的.
    @Provides @PerActivity Activity provideActivity(){
        return mActivity;
    }
}
