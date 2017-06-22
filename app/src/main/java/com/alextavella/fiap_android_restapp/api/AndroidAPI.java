package com.alextavella.fiap_android_restapp.api;

import com.alextavella.fiap_android_restapp.model.AndroidResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by alextavella on 21/06/17.
 */

public interface AndroidAPI {

    @GET("/v2/58af1fb21000001e1cc94547")
    Call<AndroidResponse> listVersions();
}
