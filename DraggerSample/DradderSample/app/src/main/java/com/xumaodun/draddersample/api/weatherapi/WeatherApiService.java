package com.xumaodun.draddersample.api.weatherapi;

import com.xumaodun.draddersample.model.WeatherResultBean;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by xumaodun on 2016/12/7.
 */
public interface WeatherApiService {
    /**
     * 查询天气
     */
    @GET("apistore/weatherservice/cityname")
    Observable<WeatherResultBean> queryWeather
    (@Header("apikey") String apikey, @Query("cityname") String cityname);
}
