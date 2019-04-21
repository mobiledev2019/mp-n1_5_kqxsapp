package com.example.kqsx2.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kqsx2.Model.KetQua;
import com.example.kqsx2.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterKq extends RecyclerView.Adapter<AdapterKq.kqViewHolder> {
    private List<KetQua> listKq = new ArrayList<>();

    public AdapterKq(List<KetQua> listKq) {
        this.listKq = listKq;
    }

    @Override
    public kqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_b, parent, false);
        return new AdapterKq.kqViewHolder(view);
    }

    @Override
    public void onBindViewHolder(kqViewHolder holder, int position) {
        KetQua ketQua = listKq.get(position);
        switch (ketQua.getNumGiai()){
            case 0:
                holder.txt1.setText(ketQua.getStringList().get(0));
                holder.txt2.setVisibility(View.GONE);
                holder.txt3.setVisibility(View.GONE);
                holder.txt4.setVisibility(View.GONE);
                holder.txt5.setVisibility(View.GONE);
                holder.txt6.setVisibility(View.GONE);
                break;
            case 1:
                holder.txt1.setText(ketQua.getStringList().get(0));
                holder.txt2.setVisibility(View.GONE);
                holder.txt3.setVisibility(View.GONE);
                holder.txt4.setVisibility(View.GONE);
                holder.txt5.setVisibility(View.GONE);
                holder.txt6.setVisibility(View.GONE);
                break;
            case 2:
                holder.txt1.setText(ketQua.getStringList().get(0));
                holder.txt2.setText(ketQua.getStringList().get(1));
                holder.txt3.setVisibility(View.GONE);
                holder.txt4.setVisibility(View.GONE);
                holder.txt5.setVisibility(View.GONE);
                holder.txt6.setVisibility(View.GONE);
                break;
            case 3:
                holder.txt1.setText(ketQua.getStringList().get(0));
                holder.txt2.setText(ketQua.getStringList().get(1));
                holder.txt3.setText(ketQua.getStringList().get(2));
                holder.txt4.setText(ketQua.getStringList().get(3));
                holder.txt5.setText(ketQua.getStringList().get(4));
                holder.txt6.setText(ketQua.getStringList().get(5));
                break;
            case 4:
                holder.txt1.setText(ketQua.getStringList().get(0));
                holder.txt2.setText(ketQua.getStringList().get(1));
                holder.txt3.setText(ketQua.getStringList().get(2));
                holder.txt4.setText(ketQua.getStringList().get(3));
                holder.txt5.setVisibility(View.GONE);
                holder.txt6.setVisibility(View.GONE);
                break;
            case 5:
                holder.txt1.setText(ketQua.getStringList().get(0));
                holder.txt2.setText(ketQua.getStringList().get(1));
                holder.txt3.setText(ketQua.getStringList().get(2));
                holder.txt4.setText(ketQua.getStringList().get(3));
                holder.txt5.setText(ketQua.getStringList().get(4));
                holder.txt6.setText(ketQua.getStringList().get(5));
                break;
            case 6:
                holder.txt1.setText(ketQua.getStringList().get(0));
                holder.txt2.setText(ketQua.getStringList().get(1));
                holder.txt3.setText(ketQua.getStringList().get(2));
                holder.txt4.setVisibility(View.GONE);
                holder.txt5.setVisibility(View.GONE);
                holder.txt6.setVisibility(View.GONE);
                break;
            case 7:
                holder.txt1.setText(ketQua.getStringList().get(0));
                holder.txt2.setText(ketQua.getStringList().get(1));
                holder.txt3.setText(ketQua.getStringList().get(2));
                holder.txt4.setText(ketQua.getStringList().get(3));
                holder.txt5.setVisibility(View.GONE);
                holder.txt6.setVisibility(View.GONE);
                break;
        }
        holder.txtTitle.setText(ketQua.getGiai());
    }

    @Override
    public int getItemCount() {
        return listKq.size();
    }


    public class kqViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txt1,txt2,txt3,txt4,txt5,txt6,txtTitle;

        public kqViewHolder(View itemView) {
            super(itemView);
            txt1 = itemView.findViewById(R.id.txt1);
            txt2 = itemView.findViewById(R.id.txt2);
            txt3 = itemView.findViewById(R.id.txt3);
            txt4 = itemView.findViewById(R.id.txt4);
            txt5 = itemView.findViewById(R.id.txt5);
            txt6 = itemView.findViewById(R.id.txt6);
            txtTitle = itemView.findViewById(R.id.txt_title);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {

            }

        }
    }
}
