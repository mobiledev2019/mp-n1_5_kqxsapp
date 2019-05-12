package com.example.kqsx2.Interface;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.GET;

import com.example.kqsx2.Model.Guess;
import com.example.kqsx2.Model.HistoryPlay;
import com.example.kqsx2.Model.ResultB;
import com.example.kqsx2.Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Response;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api/getResult")
    Call<ResultB> getResult(@Query("date") String date, @Query("region") Long region);

    @POST("api/createGuess")
    Call<Void> createGuess(@Body Guess guess);

    @POST("api/authenticate")
    Call<String> getToken(@Body User user);

    @GET("api/getGuess")
    Call<HistoryPlay> getGuess();

    class Factory {

        public static Retrofit getRetrofit(String url, final String token) {
            //add logging
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//            OkHttpClient Okclient = new OkHttpClient.Builder()
//                    .addInterceptor(logging)
//                    .build();

            OkHttpClient Okclient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request newRequest  = chain.request().newBuilder()
                            .addHeader("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX0FETUlOLFJPTEVfVVNFUiIsImV4cCI6MTU1NjAwMzY5NX0.zsjWSUL7lQl6mlzKNUcE7Lp8xuZFVN2pB-RsmsKvb7mZmfHcaug-zyPnkNbAv9LRjhrqx7DqVf8ENfh9wjExsw")
                            .build();
                    return chain.proceed(newRequest);
                }
            }).build();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            builder.connectTimeout(7000, TimeUnit.SECONDS);
            builder.readTimeout(7000, TimeUnit.SECONDS);
            //add token on header

            builder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request originalRequest = chain.request();

                    Request.Builder builder = originalRequest.newBuilder().header("Authorization", token).addHeader("Content-type", "application/json");

                    Request newRequest = builder.build();
                    return chain.proceed(newRequest);
                }
            });

            Gson gson = new GsonBuilder()
                    .enableComplexMapKeySerialization()
//                    .excludeFieldsWithoutExposeAnnotation()
                    .setPrettyPrinting()
                    .setVersion(1.0)
                    .create();


            OkHttpClient client = builder.build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .client(Okclient)
                    .build();
            return retrofit;
        }

        public static ApiInterface create(Retrofit retrofit) {
            return retrofit.create(ApiInterface.class);
        }
    }
}
