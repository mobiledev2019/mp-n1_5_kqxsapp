package com.example.kqsx2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

import com.example.kqsx2.API.OnResponseListener;
import com.example.kqsx2.Model.ErrorMessage;
import com.example.kqsx2.Model.Guess;
import com.example.kqsx2.Respository.Guessrepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends Fragment {
    private Guess guess = new Guess();

    public PlayFragment() {
        // Required empty public constructor
    }
    private Button btkhuvuc,btnPlay,btnprofile;
    private EditText sdd,sdiem;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         final View view = inflater.inflate(R.layout.fragment_play, container, false);
         btkhuvuc=(Button)view.findViewById(R.id.btkhuvuc);
         btkhuvuc.setText("Chọn Khu vực");
        btnPlay = (Button) view.findViewById(R.id.btplay);
        final Button bthtplay=(Button)view.findViewById(R.id.bthtplay);
        bthtplay.setText("Chọn hình thức chơi");
        btnprofile = (Button) view.findViewById(R.id.btnprofile);
        //
        sdd = (EditText) view.findViewById(R.id.sdd);
        sdiem = (EditText) view.findViewById(R.id.sdiem);
        //event click checkbox
        btkhuvuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menukhuvuc;
                menukhuvuc = new PopupMenu(requireActivity(),btkhuvuc);// sai context requireActivity()
                menukhuvuc.getMenuInflater().inflate(R.menu.popmenukhuvuc,menukhuvuc.getMenu());
                menukhuvuc.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.mb:
                                btkhuvuc.setText("Miền Bắc");
                                guess.setRegion(1L);
                                return true;
                            case R.id.mn:
                                btkhuvuc.setText("Miền Nam");
                                guess.setRegion(3L);
                                return true;
                            case R.id.mt:
                                btkhuvuc.setText("Miền Trung");
                                guess.setRegion(2L);
                                return true;
//                            case R.id.nvl:
//                                btkhuvuc.setText("Vĩnh Long");
//                                return true;
//                            case R.id.ntv:
//                                btkhuvuc.setText("Trà Vinh");
//                                return true;
//                            case R.id.nbd:
//                                btkhuvuc.setText("Bình Dương");
//                                return true;
                        }
                        return false;
                    }
                });
                menukhuvuc.show();
            }
        });
        bthtplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu menuhtplay;
                menuhtplay = new PopupMenu(requireActivity(),btkhuvuc);// sai context requireActivity()
                menuhtplay.getMenuInflater().inflate(R.menu.popmenuhtchoi,menuhtplay.getMenu());
                menuhtplay.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.lo:
                                bthtplay.setText("Lô");
                                guess.setType_guess(1L);
                                return true;
                            case R.id.de:
                                bthtplay.setText("Đề");
                                guess.setType_guess(2L);
                                return true;
                        }
                        return false;
                    }
                });
                menuhtplay.show();
            }
        });
        String currentDate = getCurrentDate();
        guess.setTime_guess(currentDate);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guess.setNumber_guess(sdd.getText().toString());
//                guess.set(sdd.getText().toString());
                Guessrepository.getInstance().createGuess(guess, new OnResponseListener<Void>() {
                    @Override
                    public void onSuccess(Void data) {

                    }

                    @Override
                    public void onFailure(ErrorMessage errorMessage) {

                    }
                });
            }
        });
        btnprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragment profileFragment = new ProfileFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack so the user can navigate back
                transaction.replace(R.id.container, profileFragment);
                transaction.addToBackStack(null);
                // Commit the transaction
                transaction.commit();
            }
        });
         return view;
    }
    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }
}
