package com.example.kqsx2.API;

import com.example.kqsx2.Model.ErrorMessage;

public interface OnResponseListener<T> {
    void onSuccess(T data);

    void onFailure(ErrorMessage errorMessage);
}
