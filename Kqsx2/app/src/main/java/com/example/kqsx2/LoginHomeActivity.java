package com.example.kqsx2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kqsx2.API.ApiClient;
import com.example.kqsx2.API.OnResponseListener;
import com.example.kqsx2.Model.ErrorMessage;
import com.example.kqsx2.Model.JWTToken;
import com.example.kqsx2.Model.User;
import com.example.kqsx2.Respository.UserRepository;
import com.example.kqsx2.Utils.App;
import com.example.kqsx2.Utils.AppSharedPref;
import com.example.kqsx2.Utils.SharedPrefsUtil;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class LoginHomeActivity extends AppCompatActivity {
    EditText username,password;
    Button btlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_chat_login);
        btlogin = (Button) findViewById(R.id.loginchat);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        try {
            FirebaseInstanceId.getInstance().getInstanceId()
                    .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                        @Override
                        public void onComplete(@NonNull Task<InstanceIdResult> task) {
                            // Get new Instance ID token
                            try {
                                String token = task.getResult().getToken();
                                Log.d("firebase", token);
                                // Log and toast
                            } catch (Exception e) {

                            }

                        }
                    });
        } catch (Exception e) {
        }
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User(username.getText().toString(), password.getText().toString());
                UserRepository.getInstance().getLoginUser(user, new OnResponseListener<JWTToken>() {
                    @Override
                    public void onSuccess(JWTToken data) {
                        ApiClient.getInstance().setToken(data.getId_token());
//                        Log.d("AAAAAAAAAAAAA", "onSuccess: " + AppSharedPref.getInstance(LoginHomeActivity.this));

                        SharedPrefsUtil.getInstance().put("key", "Bearer "+data.getId_token());
//                        AppSharedPref.getInstance(LoginHomeActivity.this).setName("key", "Bearer "+data.getId_token());
                        Intent intent=new Intent(LoginHomeActivity.this,BottomActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(ErrorMessage errorMessage) {
                        String errMsg = "Error Unknown";
                        if (errorMessage != null) {
                            errMsg = errorMessage.getTitle();
                            if (errorMessage.getStatus() == 428) {
//                                showThankRegistration();
                            }
                        }
                    }
                });

            }
        });
    }
}
