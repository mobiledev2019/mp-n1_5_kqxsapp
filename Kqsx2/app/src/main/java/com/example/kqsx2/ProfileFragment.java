package com.example.kqsx2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kqsx2.API.OnResponseListener;
import com.example.kqsx2.Model.ErrorMessage;
import com.example.kqsx2.Model.UserExtra;
import com.example.kqsx2.Respository.UserExtraRepository;

public class ProfileFragment extends Fragment {
    private UserExtra userExtra;
    private EditText profile_edt_email;
    private EditText profile_edt_fullname;
    private TextView pointcash;
    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        final View view =  inflater.inflate(R.layout.profile_fragment, container, false);
        profile_edt_email = (EditText) view.findViewById(R.id.profile_edt_email);
        profile_edt_fullname = (EditText) view.findViewById(R.id.profile_edt_fullname);
        pointcash = (TextView) view.findViewById(R.id.pointcash);
        UserExtraRepository.getInstance().getResult(3L, new OnResponseListener<UserExtra>() {
            @Override
            public void onSuccess(UserExtra data) {
                profile_edt_email.setText(data.getEmail());
                profile_edt_fullname.setText(data.getFirstName()+ " "+ data.getLastName());
                pointcash.setText(data.getPointCash() + " Point");
            }

            @Override
            public void onFailure(ErrorMessage errorMessage) {

            }
        });
        return view;
    }
}
