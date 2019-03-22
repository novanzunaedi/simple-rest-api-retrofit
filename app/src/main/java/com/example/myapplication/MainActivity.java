package com.example.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.Model.DataSiswa;
import com.example.myapplication.Model.ResponseDataSiswa;
import com.example.myapplication.adapter.SiswaAdapter;
import com.example.myapplication.util.api.BaseApiService;
import com.example.myapplication.util.api.UtilsApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Context mContext;
    List<DataSiswa> semuasiswaItemList = new ArrayList<>();
    SiswaAdapter siswaAdapter;
    BaseApiService mApiService;
    private RecyclerView Rvsiswa=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        mApiService = UtilsApi.getAPIService();

        siswaAdapter = new SiswaAdapter(this, semuasiswaItemList);

        RecyclerView.LayoutManager mLayoutmanager = new LinearLayoutManager(this);

        Rvsiswa = findViewById(R.id.rvSiswa);
        Rvsiswa.setLayoutManager(mLayoutmanager);

        getResultListSiswa();
    }

    public void getResultListSiswa(){
        mApiService.getDataSiswa().enqueue(new Callback<ResponseDataSiswa>() {
            @Override
            public void onResponse(Call<ResponseDataSiswa> call, Response<ResponseDataSiswa> response) {
                handleResponse(response.body().getData());
            }

            @Override
            public void onFailure(Call<ResponseDataSiswa> call, Throwable t) {
                Log.e("err res",call.toString()+" "+t.toString());
                Toast.makeText(mContext, "Tidak Dapat Terhubung Ke Server !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void handleResponse(List<DataSiswa> data) {
        Rvsiswa.setAdapter(new SiswaAdapter(mContext, data));
        siswaAdapter.notifyDataSetChanged();
    }
}