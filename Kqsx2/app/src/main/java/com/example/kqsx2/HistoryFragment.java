package com.example.kqsx2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.kqsx2.API.OnResponseListener;
import com.example.kqsx2.Adapter.ArrayAdapterHistory;
import com.example.kqsx2.Model.ErrorMessage;
import com.example.kqsx2.Model.HistoryPlay;
import com.example.kqsx2.Respository.HistoryPlayRepository;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {
private ArrayList<HistoryPlay> listHistory;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_history, container, false);
        final ListView listView = (ListView) view.findViewById(R.id.list_history);
//        HistoryPlay historyPlay = new HistoryPlay("ab","c","22");
        final HistoryPlay historyPlay = new HistoryPlay();
        listHistory = new ArrayList<HistoryPlay>();
        HistoryPlayRepository.getInstance().getGuess(new OnResponseListener<List<HistoryPlay>>() {
            @Override
            public void onSuccess(List<HistoryPlay> data) {
                for(int i=0;i< data.size();i++) {
                    historyPlay.setNumber_guess(data.get(i).getNumber_guess());
                    historyPlay.setRegion(data.get(i).getRegion());
                    historyPlay.setTime_guess(data.get(i).getTime_guess());
                    historyPlay.setType_guess(data.get(i).getType_guess());
                    listHistory.add(historyPlay);
                }
                ArrayAdapterHistory adapter = new ArrayAdapterHistory(getContext(),R.layout.fragment_history_list, listHistory);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(ErrorMessage errorMessage) {

            }
        });

        return view;
    }

}
