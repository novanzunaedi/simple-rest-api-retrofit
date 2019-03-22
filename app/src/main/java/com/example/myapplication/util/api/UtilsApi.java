package com.example.myapplication.util.api;

import android.util.Log;

public class UtilsApi {
    public static final String BASE_URL_API = "https://gist.githubusercontent.com/novanzunaedi/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        Log.e("API", "getAPIService: " + BASE_URL_API);
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
