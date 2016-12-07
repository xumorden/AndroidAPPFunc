package com.xumaodun.draddersample.view;

import android.support.annotation.NonNull;

/**
 * Created by xumaodun on 2016/12/7.
 */
public interface BasePresenter <T extends BaseView>{

    void attachView(@NonNull T view);

    void detachView();

}
