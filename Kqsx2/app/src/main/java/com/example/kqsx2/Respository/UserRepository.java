package com.example.kqsx2.Respository;

import android.support.annotation.NonNull;

import com.example.kqsx2.API.ApiClient;
import com.example.kqsx2.API.OnResponseListener;
import com.example.kqsx2.Model.ErrorMessage;
import com.example.kqsx2.Model.JWTToken;
import com.example.kqsx2.Model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class UserRepository {
    private static UserRepository sInstance;

    private UserRepository() {

    }

    public static UserRepository getInstance() {
        if (sInstance == null) {
            sInstance = new UserRepository();
        }
        return sInstance;
    }
    public void getLoginUser(@NonNull @Body User user, @NonNull final OnResponseListener<JWTToken> listener) {

        Call<JWTToken> call = ApiClient.getInstance().getApiInterface().getToken(user);
        call.enqueue(new Callback<JWTToken>() {
            @Override
            public void onResponse(Call<JWTToken> call, Response<JWTToken> response) {
                if (response.code() == 200 && response.body() != null)
                    listener.onSuccess(response.body());
                else if (response.code() == 401) {
                    listener.onFailure(new ErrorMessage("Password is invalid"));
                }else if(response.code() == 428){
                    listener.onFailure(new ErrorMessage(428,"User not activated"));
                } else if (response.code() == 404){
                    listener.onFailure(new ErrorMessage("Account doesn't exists"));
                } else if(response.code() == 400){
                    listener.onFailure(new ErrorMessage("Password is invalid"));
                }
            }

            @Override
            public void onFailure(Call<JWTToken> call, Throwable t) {
                listener.onFailure(new ErrorMessage());

            }
        });
    }
}
