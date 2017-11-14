package com.example.biz_41;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by ПОДАРУНКОВИЙ on 19.10.2017.
 */

public class BizApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}