package com.example.kqsx2;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kqsx2.API.OnResponseListener;
import com.example.kqsx2.Adapter.AdapterKq;
import com.example.kqsx2.Model.ErrorMessage;
import com.example.kqsx2.Model.KetQua;
import com.example.kqsx2.Model.ResultB;
import com.example.kqsx2.Respository.ResultRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class LiveBFragment extends Fragment {
    private RecyclerView rcvKQ;
    private List<KetQua> listKq;
    private List<String> stringList;
    private AdapterKq adapterKq;

    public LiveBFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_live_b, container, false);
        final Handler handler = new Handler();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                listKq = new ArrayList<>();
                stringList = new ArrayList<>();
                String currentTime = getCurrentDate();
                Log.d("abc", "currentTIME "+currentTime);
                ResultRepository.getInstance().getResult(currentTime, 1L, new OnResponseListener<ResultB>() {
                    @Override
                    public void onSuccess(ResultB data) {
                        List<String> getSpecial = new ArrayList<String>();
                        if(data.getSpecial().size() > 0) {
                            getSpecial = data.getSpecial();
                        } else {
                            getSpecial.add("");
                        }
                        List<String> getFirst = new ArrayList<String>();
                        if(data.getFirst().size() > 0) {
                            getFirst = data.getFirst();
                        } else {
                            getFirst.add("");
                        }
                        List<String> getSecond = new ArrayList<String>();
                        if(data.getSecond().size() > 0) {
                            getSecond = data.getSecond();
                        } else {
                            getSecond.add("");
                            getSecond.add("");
                        }
                        List<String> getThird = new ArrayList<String>();
                        if(data.getThird().size() > 0) {
                            getThird = data.getThird();
                        } else {
                            getThird.add("");
                            getThird.add("");
                            getThird.add("");
                            getThird.add("");
                            getThird.add("");
                            getThird.add("");
                        }
                        List<String> getFourth = new ArrayList<String>();
                        if(data.getFourth().size() > 0) {
                            getFourth = data.getFourth();
                        } else {
                            getFourth.add("");
                            getFourth.add("");
                            getFourth.add("");
                            getFourth.add("");
                        }
                        List<String> getFifth = new ArrayList<String>();
                        if(data.getFifth().size() > 0) {
                            getFifth = data.getFifth();
                        } else {
                            getFifth.add("");
                            getFifth.add("");
                            getFifth.add("");
                            getFifth.add("");
                            getFifth.add("");
                            getFifth.add("");
                        }
                        List<String> getSixth = new ArrayList<String>();
                        if(data.getSixth().size() > 0) {
                            getSixth = data.getSixth();
                        } else {
                            getSixth.add("");
                            getSixth.add("");
                            getSixth.add("");
                        }
                        List<String> getSeventh = new ArrayList<String>();
                        if(data.getSeventh().size() > 0) {
                            getSeventh = data.getSeventh();
                        } else {
                            getSeventh.add("");
                            getSeventh.add("");
                            getSeventh.add("");
                            getSeventh.add("");
                        }
                        listKq.add(new KetQua("GDB",getSpecial,0));
                        listKq.add(new KetQua("G1",getFirst,1));
                        listKq.add(new KetQua("G2",getSecond,2));
                        listKq.add(new KetQua("G3",getThird,3));
                        listKq.add(new KetQua("G4",getFourth,4));
                        listKq.add(new KetQua("G5",getFifth,5));
                        listKq.add(new KetQua("G6",getSixth,6));
                        listKq.add(new KetQua("G7",getSeventh,7));

                        adapterKq = new AdapterKq(listKq);
                        rcvKQ = view.findViewById(R.id.rcv_kq);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        rcvKQ.setLayoutManager(layoutManager);
                        rcvKQ.setAdapter(adapterKq);
                    }

                    @Override
                    public void onFailure(ErrorMessage errorMessage) {
                        System.out.println("error: "+ errorMessage.getTitle());
                    }
                });
                handler.postDelayed(this, 10000);
            }
        };
        handler.post(task);
        // this code will be executed after 2 seconds


        return view;
    }
    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }
}