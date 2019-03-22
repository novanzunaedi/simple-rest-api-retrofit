package com.example.myapplication.util.api;
import com.example.myapplication.Model.ResponseDataSiswa;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseApiService {
    @GET("1e4630cb6afb45163445ef9a2c3e023c/raw/e90179f262e09a94c898fdcd3a2f35723210e1d4/dataSiswa")
    Call<ResponseDataSiswa> getDataSiswa();
}
