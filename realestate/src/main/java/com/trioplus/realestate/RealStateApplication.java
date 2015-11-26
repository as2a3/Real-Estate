package com.trioplus.realestate;

import android.app.Application;
import android.content.Context;

/**
 * Created by Ahmed on 11/22/2015.
 */
public class RealStateApplication extends Application{

    public static final String LOG_TAG = "RealEstate";

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

}
