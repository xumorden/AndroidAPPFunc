package com.xumaodun.draddersample.api.weatherapi;

import com.xumaodun.draddersample.api.BaseSubsribe;
import com.xumaodun.draddersample.config.ConstantApi;
import com.xumaodun.draddersample.model.WeatherResultBean;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by xumaodun on 2016/12/7.
 */
public class WeatherApi {
    private   WeatherApiService weatherApiService;
    public  WeatherApi() {
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
        OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient.Builder builder = okHttpClient.newBuilder();
        builder.retryOnConnectionFailure(true);
        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient)
                .baseUrl(ConstantApi.BaiduUrl)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        weatherApiService = retrofit.create(WeatherApiService.class);
    }



    //可写,可不写.不写的话就在Presenter中实现这段代码.
    public Subscription queryWeather(String apikey, String cityname, BaseSubsribe<WeatherResultBean> subsribe) {
        Observable<WeatherResultBean> observable = weatherApiService.queryWeather(apikey, cityname);
        Subscription subscribe = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subsribe);
        return subscribe;
    }
}
