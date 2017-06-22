package com.alextavella.fiap_android_restapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alextavella on 21/06/17.
 */

public class AndroidResponse {

    @SerializedName("android")
    private List<Android> androids;

    public AndroidResponse(List<Android> androids) {
        this.androids = androids;
    }

    public List<Android> getAndroids() {
        return androids;
    }

    public void setAndroids(List<Android> androids) {
        this.androids = androids;
    }
}
