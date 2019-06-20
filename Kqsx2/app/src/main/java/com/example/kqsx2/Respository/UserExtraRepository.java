package com.example.kqsx2.Respository;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.kqsx2.API.ApiClient;
import com.example.kqsx2.API.OnResponseListener;
import com.example.kqsx2.Model.ErrorMessage;
import com.example.kqsx2.Model.UserExtra;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserExtraRepository {
    private static UserExtraRepository sInstance;

    private UserExtraRepository() {

    }

    public static UserExtraRepository getInstance() {
        if (sInstance == null) {
            sInstance = new UserExtraRepository();
        }
        return sInstance;
    }

    public void getResult(@NonNull Long userExtraId, @NonNull final OnResponseListener<UserExtra> listener) {
        ApiClient apiClient = new ApiClient();
//        String token = SharedPrefsUtil.getInstance().get("key",String.class);
//        ApiInterface apiInterface = ApiClient2.getClient(token).create(ApiInterface.class);
//        Call<ResultB> call = apiClient.getApiInterface().getResult(date, region);
        Call<UserExtra> call = apiClient.getApiInterface().getUserExtra(userExtraId);
        call.enqueue(new Callback<UserExtra>() {
            @Override
            public void onResponse(Call<UserExtra> call, Response<UserExtra> response) {
                if (response.code() == 200 && response.body() != null)
                    listener.onSuccess(response.body());
                else
                    listener.onFailure(new ErrorMessage(response.errorBody().toString()));
            }

            @Override
            public void onFailure(Call<UserExtra> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
