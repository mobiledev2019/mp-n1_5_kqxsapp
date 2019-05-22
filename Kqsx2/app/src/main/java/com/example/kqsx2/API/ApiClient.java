package com.example.kqsx2.API;

import com.example.kqsx2.Interface.ApiInterface;

import retrofit2.Retrofit;

public class ApiClient {
    public static final String BASE_URL = "http://192.168.0.101:8080";//public

    private static ApiClient apiClient;
    private ApiInterface apiInterface;
    private static String token =  "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTU1ODYyMjkyOH0.f0V-wN78uLfycRT8U4_xwOxRspSYNtPIL9eQjW3aTXvKbQqgE8Jq2Si01IGf2CTQ-oImV9_kEc6rjWoelYe7JQ";

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