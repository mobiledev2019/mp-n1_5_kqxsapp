package com.example.kqsx2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.kqsx2.Adapter.ArrayAdapterHistory;
import com.example.kqsx2.Model.HistoryPlay;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view =  inflater.inflate(R.layout.fragment_history, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list_history);
        HistoryPlay historyPlay = new HistoryPlay("ab","c","22");
        ArrayList<HistoryPlay> listHistory = new ArrayList<HistoryPlay>();
        listHistory.add(historyPlay);
        ArrayAdapterHistory adapter = new ArrayAdapterHistory(getContext(),R.layout.fragment_history_list, listHistory);
        listView.setAdapter(adapter);
        return view;
    }

}
