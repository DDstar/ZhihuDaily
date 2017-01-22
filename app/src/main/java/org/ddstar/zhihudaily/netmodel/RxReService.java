package org.ddstar.zhihudaily.netmodel;

import org.ddstar.zhihudaily.datamodel.BeanStart;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by DDstar on 2017/1/22.
 */

public interface RxReService {
    @GET("start-image/1080*1776")
    Observable<BeanStart> getStartImage();

    @GET("start-image/1080*1776")
    Call<BeanStart> getImage();
}