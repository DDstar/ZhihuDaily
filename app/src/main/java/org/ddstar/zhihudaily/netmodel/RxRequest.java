package org.ddstar.zhihudaily.netmodel;

import org.ddstar.zhihudaily.datamodel.BeanStart;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by DDstar on 2017/1/22.
 */

public class RxRequest {
    private static String BASEURL = "http://news-at.zhihu.com/api/4/";
    private static RxReService mRxReService;

    public static void initRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//添加取消订阅时取消http请求
                .addConverterFactory(GsonConverterFactory.create())//添加Gson解析库
                .build();
        mRxReService = retrofit.create(RxReService.class);
    }

    public static void getStartImage(Subscriber<BeanStart> subscriber) {
        mRxReService.getStartImage()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public static void getStartImage(Callback<BeanStart> callback) {
        Call<BeanStart> stringCall = mRxReService.getImage();
        stringCall.enqueue(callback);
    }
}