package com.example.kqsx2.Utils;

import android.app.Application;

import com.google.gson.Gson;

public class App extends Application {
    private static App mSelf;
    private Gson mGSon;

    public static App self() {
        if(mSelf == null) {
            mSelf = new App();
        }
        return mSelf;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mSelf = this;
        mGSon = new Gson();
    }

    public Gson getGSon() {
        return mGSon;
    }
}
