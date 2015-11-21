package com.trioplus.realestate.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trioplus.realestate.activity.MainActivity;

/**
 * Created by Ahmed on 11/21/2015.
 */
public abstract class CommonFragment extends Fragment{

    public Toolbar toolbar;

    private Activity activity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = getMainActivity().getToolbar();

        getMainActivity().getSwipeRefreshLayout().setEnabled(true);

        if (getMainActivity().getSwipeRefreshLayout() != null) {
            getMainActivity().getSwipeRefreshLayout().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    if (getMainActivity() != null) {
                        getMainActivity().getSwipeRefreshLayout().setRefreshing(false);
                        refreshContent();
                    }
                }
            });
        }
    }

    public abstract void refreshContent();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    protected MainActivity getMainActivity() {
        if (getActivity() != null) {
            return (MainActivity) getActivity();
        } else {
            return (MainActivity) this.activity;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }
}
