package com.example.kqsx2.Respository;

import android.support.annotation.NonNull;

import com.example.kqsx2.API.ApiClient;
import com.example.kqsx2.API.OnResponseListener;
import com.example.kqsx2.Model.HistoryPlay;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryPlayRepository {
    private static HistoryPlayRepository sInstance;

    private HistoryPlayRepository() {

    }

    public static HistoryPlayRepository getInstance() {
        if (sInstance == null) {
            sInstance = new HistoryPlayRepository();
        }
        return sInstance;
    }
    public void getGuess(@NonNull final OnResponseListener<HistoryPlay> listener) {
        Call<HistoryPlay> call = ApiClient.getInstance().getApiInterface().getGuess();
        call.enqueue(new Callback<HistoryPlay>() {
            @Override
            public void onResponse(Call<HistoryPlay> call, Response<HistoryPlay> response) {
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
            public void onFailure(Call<HistoryPlay> call, Throwable t) {
                listener.onFailure(null);
            }
        });
    }
}
