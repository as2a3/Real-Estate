package com.trioplus.realestate.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trioplus.realestate.R;

/**
 * Created by hp on 21/11/2015.
 */
public class EstateDetailsFragment extends CommonFragment{

    /*
    * Sa3eed
    * Note:....This Fragment may be converted into activity
    * */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_estate_details, container, false);
        return view;
    }

    @Override
    public void refreshContent() {

    }
}