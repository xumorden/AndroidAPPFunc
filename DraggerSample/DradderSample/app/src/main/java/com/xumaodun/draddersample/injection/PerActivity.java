package com.xumaodun.draddersample.injection;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by xumaodun on 2016/12/7.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerActivity {
}
