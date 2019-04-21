package com.example.kqsx2.Respository;

import android.support.annotation.NonNull;

import com.example.kqsx2.API.ApiClient;
import com.example.kqsx2.API.OnResponseListener;
import com.example.kqsx2.Model.ErrorMessage;
import com.example.kqsx2.Model.Guess;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Guessrepository {
    private static Guessrepository sInstance;

    private Guessrepository() {

    }

    public static Guessrepository getInstance() {
        if (sInstance == null) {
            sInstance = new Guessrepository();
        }
        return sInstance;
    }
    public void createGuess(Guess guess, @NonNull final OnResponseListener<Void> listener) {
        Call<Void> call = ApiClient.getInstance().getApiInterface().createGuess(guess);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response == null) {
                    listener.onFailure(null);
                    return;
                }
                if (!response.isSuccessful()) {
//                    ErrorMessage errorMessage = ErrorUtils.parseError(response);
//                    listener.onFailure(errorMessage);
                    return;
                }

                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                listener.onFailure(null);
            }
        });
    }
}
