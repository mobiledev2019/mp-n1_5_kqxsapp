package com.example.kqsx2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.kqsx2.API.ApiClient;
import com.example.kqsx2.API.OnResponseListener;
import com.example.kqsx2.Model.ErrorMessage;
import com.example.kqsx2.Model.JWTToken;
import com.example.kqsx2.Model.User;
import com.example.kqsx2.Respository.UserRepository;

public class LoginHomeActivity extends AppCompatActivity {
    EditText username,password;
    Button btlogin;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_chat_login);
        btlogin = (Button) findViewById(R.id.loginchat);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        sharedpreferences = getSharedPreferences("token", Context.MODE_PRIVATE);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User(username.getText().toString(), password.getText().toString());
                UserRepository.getInstance().getLoginUser(user, new OnResponseListener<JWTToken>() {
                    @Override
                    public void onSuccess(JWTToken data) {

                        ApiClient.getInstance().setToken(data.getIdToken());
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("key", data.getIdToken());
                        editor.commit();
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
