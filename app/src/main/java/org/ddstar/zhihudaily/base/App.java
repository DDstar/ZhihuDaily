package org.ddstar.zhihudaily.base;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.ddstar.zhihudaily.netmodel.RxRequest;

/**
 * Created by DDstar on 2017/1/18.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        RxRequest.initRequest();
    }
}
