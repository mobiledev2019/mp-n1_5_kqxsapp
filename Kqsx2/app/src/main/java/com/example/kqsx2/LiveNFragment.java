package com.example.kqsx2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kqsx2.API.OnResponseListener;
import com.example.kqsx2.Adapter.AdapterKq;
import com.example.kqsx2.Model.ErrorMessage;
import com.example.kqsx2.Model.KetQua;
import com.example.kqsx2.Model.ResultB;
import com.example.kqsx2.Respository.ResultRepository;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LiveNFragment extends Fragment {

    private RecyclerView rcvKQ;
    private List<KetQua> listKq;
    private List<String> stringList;
    private AdapterKq adapterKq;
    public LiveNFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_live_n, container, false);
        listKq = new ArrayList<>();
//        stringList = new ArrayList<>();
        ResultRepository.getInstance().getResult("2019-04-02", 1L, new OnResponseListener<ResultB>() {
            @Override
            public void onSuccess(ResultB data) {
                listKq.add(new KetQua("GDB",data.getSpecial(),0));
                listKq.add(new KetQua("G1",data.getFirst(),1));
                listKq.add(new KetQua("G2",data.getSecond(),2));
                listKq.add(new KetQua("G3",data.getThird(),3));
                listKq.add(new KetQua("G4",data.getFourth(),4));
                listKq.add(new KetQua("G5",data.getFifth(),5));
                listKq.add(new KetQua("G6",data.getSixth(),6));
                listKq.add(new KetQua("G7",data.getSeventh(),7));

                adapterKq = new AdapterKq(listKq);
                rcvKQ = view.findViewById(R.id.rcv_kq_hcm);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                rcvKQ.setLayoutManager(layoutManager);
                rcvKQ.setAdapter(adapterKq);
            }

            @Override
            public void onFailure(ErrorMessage errorMessage) {
                System.out.println("error: "+ errorMessage);
            }
        });

        return view;
    }

}
