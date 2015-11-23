package com.trioplus.realestate.webservice;

import com.trioplus.realestate.model.Estate;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Ahmed on 11/23/2015.
 */
public interface GetApi {

    @GET("/estate.json")
    void getPlaceDetails(Callback<Estate> response);

}
