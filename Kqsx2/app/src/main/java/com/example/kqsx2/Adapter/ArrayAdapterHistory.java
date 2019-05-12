package com.example.kqsx2.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kqsx2.Model.HistoryPlay;
import com.example.kqsx2.R;

import java.util.ArrayList;

public class ArrayAdapterHistory extends ArrayAdapter<HistoryPlay> {
    private TextView point,type,time;
    private Context context;
    int resource;
    public ArrayAdapterHistory(@NonNull Context context, int resource, ArrayList<HistoryPlay> listPlay) {
        super(context, resource, listPlay);
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String strPoint = getItem(position).getNumber_guess();
        Long strType = getItem(position).getType_guess();
        String strTime = getItem(position).getTime_guess();
        Long strRegion = getItem(position).getRegion();
        HistoryPlay history = new HistoryPlay(strPoint, strRegion,strType,strTime);
        System.out.println("point "+ strPoint);
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);
        point = (TextView) convertView.findViewById(R.id.point);
        type = (TextView) convertView.findViewById(R.id.type);
        time = (TextView) convertView.findViewById(R.id.time);

        //
        point.setText(strPoint);
        type.setText(""+strType);
        time.setText(strTime);
        return convertView;
    }
}
