package com.xumaodun.draddersample.injection.modules;

import com.xumaodun.draddersample.api.weatherapi.WeatherApi;

import dagger.Module;
import dagger.Provides;

/**
 * Created by xumaodun on 2016/12/7.
 */
@Module
public class ApiModule {

    @Provides
    public WeatherApi provideWeatherApi(){
        return new WeatherApi();
    }
}
