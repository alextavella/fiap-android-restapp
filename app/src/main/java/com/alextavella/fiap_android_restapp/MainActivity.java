package com.alextavella.fiap_android_restapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.alextavella.fiap_android_restapp.adapter.AndroidAdapter;
import com.alextavella.fiap_android_restapp.api.AndroidAPI;
import com.alextavella.fiap_android_restapp.model.Android;
import com.alextavella.fiap_android_restapp.model.AndroidResponse;
import com.alextavella.fiap_android_restapp.utils.APIUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvAndroids)
    public RecyclerView rvAndroids;

    private AndroidAdapter androidAdapter;
    private AndroidAPI androidAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.init();
        this.bind();
    }

    private void init() {
        androidAdapter = new AndroidAdapter(new ArrayList<Android>());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvAndroids.setLayoutManager(layoutManager);
        rvAndroids.setAdapter(androidAdapter);
        rvAndroids.setHasFixedSize(true);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rvAndroids.addItemDecoration(itemDecoration);
    }

    private void bind() {
        APIUtils
                .getAndroidAPIService()
                .listVersions()
                .enqueue(new Callback<AndroidResponse>() {
                    @Override
                    public void onResponse(Call<AndroidResponse> call, Response<AndroidResponse> response) {
                        if (response.isSuccessful()) {
                            androidAdapter.update(
                                    response
                                            .body()
                                            .getAndroids());
                        }
                    }

                    @Override
                    public void onFailure(Call<AndroidResponse> call, Throwable t) {
                        Log.e("ERRO", t.getMessage());
                    }
                });
    }
}
