package com.example.kqsx2.API;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.example.kqsx2.Interface.ApiInterface;
import com.example.kqsx2.Utils.App;
import com.example.kqsx2.Utils.AppSharedPref;
import com.example.kqsx2.Utils.SharedPrefsUtil;

import retrofit2.Retrofit;

public class ApiClient{
    public static final String BASE_URL = "http://192.168.0.101:8080";//public

    private static ApiClient apiClient;
    private ApiInterface apiInterface;

//    private static String token =  "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTU2MDg3MTU0N30.GfJikhsS5voHpC23aVLCtD9_2QTtLUENqemres0gTVbjgzlC5LJKmztQHouigjLLyF20TgOVwvaWXCnmHn28Tw";
    private static String token =  SharedPrefsUtil.getInstance().get("key", String.class);

    public ApiClient() {
        apiInterface = ApiInterface.Factory.create(getRetrofit());
    }

    public static Retrofit getRetrofit() {
        return ApiInterface.Factory.getRetrofit(BASE_URL, token);
    }

    public static ApiClient getInstance() {
        if (apiClient == null) {
            apiClient = new ApiClient();
        }
        return apiClient;
    }

    public void setToken(String token) {
        apiInterface = null;
        apiClient = null;
        this.token = token;
        new ApiClient();
    }


    public ApiInterface getApiInterface() {
        return apiInterface;
    }
}