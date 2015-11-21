package com.trioplus.realestate.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trioplus.realestate.R;
import com.trioplus.realestate.activity.MainActivity;

/**
 * Created by Ahmed on 11/21/2015.
 */
public class HomeFragment extends CommonFragment {

    private static int SPLASH_TIME_OUT = 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void refreshContent() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, SPLASH_TIME_OUT);
    }
}
