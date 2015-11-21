package com.trioplus.realestate;

import android.app.Application;

/**
 * Created by Ahmed on 11/22/2015.
 */
public class RealStateApplication extends Application{

    public static final String LOG_TAG = "RealEstate";
    public static final String API_URL = "http://192.168.88.14";

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
