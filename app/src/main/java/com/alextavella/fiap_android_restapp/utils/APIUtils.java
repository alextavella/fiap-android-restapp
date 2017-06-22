package com.alextavella.fiap_android_restapp.utils;

import com.alextavella.fiap_android_restapp.api.AndroidAPI;
import com.alextavella.fiap_android_restapp.api.RetrofitClient;

/**
 * Created by alextavella on 21/06/17.
 */

public class APIUtils {

    public static final String BASE_URL = "http://www.mocky.io";

    public static AndroidAPI getAndroidAPIService() {
        return RetrofitClient
                .getClient(BASE_URL)
                .create(AndroidAPI.class);
    }
}
