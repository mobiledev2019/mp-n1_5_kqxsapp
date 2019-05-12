package com.example.kqsx2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kqsx2.API.ApiClient;
import com.example.kqsx2.API.OnResponseListener;
import com.example.kqsx2.Model.ErrorMessage;
import com.example.kqsx2.Model.User;
import com.example.kqsx2.Respository.UserRepository;
import com.example.kqsx2.Utils.SharedPrefsUtil;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatLoginFragment extends Fragment {
    EditText username,password;
    Button btlogin;
    public ChatLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_chat_login, container, false);
        username = (EditText) view.findViewById(R.id.username);
        password = (EditText) view.findViewById(R.id.password);
        btlogin=(Button)view.findViewById(R.id.loginchat);

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User(username.getText().toString(), password.getText().toString());
                UserRepository.getInstance().getLoginUser(user, new OnResponseListener<String>() {
                    @Override
                    public void onSuccess(String data) {
                        ApiClient.getInstance().setToken(data);
                        SharedPrefsUtil.getInstance().put("TOKEN",data);
                        System.out.println("token " + data);
//                        Intent intent=new Intent(getActivity(),ChatActivity.class);
//                        startActivity(intent);
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

        return view;

    }

}
