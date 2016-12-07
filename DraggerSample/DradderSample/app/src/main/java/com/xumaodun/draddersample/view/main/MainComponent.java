package com.xumaodun.draddersample.view.main;

import com.xumaodun.draddersample.injection.PerActivity;
import com.xumaodun.draddersample.injection.components.ApplicationComponent;
import com.xumaodun.draddersample.injection.modules.ActivityModule;

import dagger.Component;

/**
 * Created by xumaodun on 2016/12/7.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules =
        {MainModule.class, ActivityModule.class
}) public interface MainComponent {
    void inject(MainActivity mActivity);
}
