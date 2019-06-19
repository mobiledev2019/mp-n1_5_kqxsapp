package com.example.kqsx2.API;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import com.example.kqsx2.Utils.App;

import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.facebook.FacebookSdk.getCacheDir;


public class ApiClient2 {
    private static int cacheSize = 10 * 1024 * 1024; // 10 MB
    private static Cache cache = new Cache(getCacheDir(), cacheSize);


    public static final String BASE_URL = "http://172.16.200.99:8080"; // public server
//    public static final String BASE_URL = "http://18.219.29.104:8989"; // old SERVER
//    public static final String BASE_URL = "http://172.16.12.19:8989"; // MR LONG

    private static Retrofit retrofit = null;

    public static Retrofit getClient(final String token) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().cache(cache).addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request.Builder builder = originalRequest.newBuilder().header("Authorization", token);
                if (hasNetwork(App.self()))
                    builder.header("Cache-Control", "public, max-age=" + 5);
                else
                    builder.header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7);


                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).addInterceptor(logging).build();
        if (!TextUtils.isEmpty(token) || retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static boolean hasNetwork(Context context) {
        Boolean isConnected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected())
            isConnected = true;
        return isConnected;
    }

}
