package com.example.kqsx2.Respository;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.kqsx2.API.ApiClient;
import com.example.kqsx2.API.OnResponseListener;
import com.example.kqsx2.Model.ErrorMessage;
import com.example.kqsx2.Model.HistoryPlay;

import java.util.List;

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
    public void getGuess(@NonNull final OnResponseListener<List<HistoryPlay>> listener) {
        Call<List<HistoryPlay>> call = ApiClient.getInstance().getApiInterface().getGuess();
        call.enqueue(new Callback<List<HistoryPlay>>() {
            @Override
            public void onResponse(Call<List<HistoryPlay>> call, Response<List<HistoryPlay>> response) {
                if (response.code() == 200 && response.body() != null) {
                    listener.onSuccess(response.body());

                } else if (response == null) {
                    listener.onFailure(new ErrorMessage(response.errorBody().toString()));
                }
            }

            @Override
            public void onFailure(Call<List<HistoryPlay>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }
}
