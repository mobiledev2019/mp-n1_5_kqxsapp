package com.example.kqsx2.API;

import com.example.kqsx2.Interface.ApiInterface;

import retrofit2.Retrofit;

public class ApiClient {
    public static final String BASE_URL = "http://192.168.0.101:8080";//public

    private static ApiClient apiClient;
    private ApiInterface apiInterface;
    private static String token =  "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTU1NTkzMzUwNX0.KT4l9sxYAZiqPSEIS2QRdhm9-CL3AsBYYNK9A3r2PG7M6ZpVkYuZ-LRRrPDfqg4nKA0jxLIxBmfykmNOjwVdaQ";

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