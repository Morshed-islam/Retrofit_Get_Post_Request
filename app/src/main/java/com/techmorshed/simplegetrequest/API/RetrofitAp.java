package com.techmorshed.simplegetrequest.API;

import com.techmorshed.simplegetrequest.model.Network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAp {

    @GET("/HPImageArchive.aspx?format=js&idx=0&n=50&mkt=en-US")
    Call<Network> getImageData();

    //http://programmingroot.com/android-retrofit-http-library-fetch-json-listview-tutorial-example/
    //https://demonuts.com/android-retrofit-listview/

}
