package com.xumaodun.draddersample.injection.components;

import android.app.Activity;

import com.xumaodun.draddersample.injection.PerActivity;
import com.xumaodun.draddersample.injection.modules.ActivityModule;

import dagger.Component;

/**
 * Created by xumaodun on 2016/12/7.
 */

@PerActivity
@Component(modules = { ActivityModule.class })
public interface ActivityComponent {

    Activity getActivity();

}
