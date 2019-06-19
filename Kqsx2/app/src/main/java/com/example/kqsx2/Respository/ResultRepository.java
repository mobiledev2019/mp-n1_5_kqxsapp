package com.example.kqsx2.Respository;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.kqsx2.API.ApiClient;
import com.example.kqsx2.API.ApiClient2;
import com.example.kqsx2.API.OnResponseListener;
import com.example.kqsx2.Interface.ApiInterface;
import com.example.kqsx2.Model.ErrorMessage;
import com.example.kqsx2.Model.ResultB;
import com.example.kqsx2.Utils.SharedPrefsUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResultRepository {
    private static ResultRepository sInstance;

    private ResultRepository() {

    }

    public static ResultRepository getInstance() {
        if (sInstance == null) {
            sInstance = new ResultRepository();
        }
        return sInstance;
    }
    public void getResult(@NonNull String date,@NonNull Long region,@NonNull final OnResponseListener<ResultB> listener) {
        ApiClient apiClient = new ApiClient();
//        String token = SharedPrefsUtil.getInstance().get("key",String.class);
//        ApiInterface apiInterface = ApiClient2.getClient(token).create(ApiInterface.class);
//        Call<ResultB> call = apiClient.getApiInterface().getResult(date, region);
        Call<ResultB> call = apiClient.getApiInterface().getResult(date, region);
        call.enqueue(new Callback<ResultB>() {
            @Override
            public void onResponse(Call<ResultB> call, Response<ResultB> response) {
                if (response.code() == 200 && response.body() != null)
                    listener.onSuccess(response.body());
                else
                    listener.onFailure(new ErrorMessage(response.errorBody().toString()));
            }

            @Override
            public void onFailure(Call<ResultB> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
