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
        View view= inflater.inflate(R.layout.fragment_chat, container, false);
        return view;
    }

}
