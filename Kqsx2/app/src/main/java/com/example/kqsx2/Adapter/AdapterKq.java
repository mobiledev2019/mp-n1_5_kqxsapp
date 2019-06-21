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
                List<TextView> textViews2 = new ArrayList<>();
                textViews2.add(holder.txt1);
                textViews2.add(holder.txt2);
                for (int i = 0;i<ketQua.getStringList().size();i++) {
                    textViews2.get(i).setText(ketQua.getStringList().get(i));
                }
//                holder.txt1.setText(ketQua.getStringList().get(0));
//                holder.txt2.setText(ketQua.getStringList().get(1));
//                holder.txt3.setVisibility(View.GONE);
//                holder.txt4.setVisibility(View.GONE);
//                holder.txt5.setVisibility(View.GONE);
//                holder.txt6.setVisibility(View.GONE);
                break;
            case 3:
                List<TextView> textViews3 = new ArrayList<>();
                textViews3.add(holder.txt1);
                textViews3.add(holder.txt2);
                textViews3.add(holder.txt3);
                textViews3.add(holder.txt4);
                textViews3.add(holder.txt5);
                textViews3.add(holder.txt6);

                for (int i = 0;i<ketQua.getStringList().size();i++) {
                    textViews3.get(i).setText(ketQua.getStringList().get(i));
                }
//                holder.txt1.setText(ketQua.getStringList().get(0) != null ? ketQua.getStringList().get(0): "");
//                holder.txt2.setText(ketQua.getStringList().get(1)!= null ? ketQua.getStringList().get(1): "");
//                holder.txt3.setText(ketQua.getStringList().get(2)!= null ? ketQua.getStringList().get(2): "");
//                holder.txt4.setText(ketQua.getStringList().get(3)!= null ? ketQua.getStringList().get(3): "");
//                holder.txt5.setText(ketQua.getStringList().get(4)!= null ? ketQua.getStringList().get(4): "");
//                holder.txt6.setText(ketQua.getStringList().get(5)!= null ? ketQua.getStringList().get(5): "");
                break;
            case 4:
                List<TextView> textViews4 = new ArrayList<>();
                textViews4.add(holder.txt1);
                textViews4.add(holder.txt2);
                textViews4.add(holder.txt3);
                textViews4.add(holder.txt4);
                for (int i = 0;i<ketQua.getStringList().size();i++) {
                    textViews4.get(i).setText(ketQua.getStringList().get(i));
                }
//                holder.txt1.setText(ketQua.getStringList().get(0));
//                holder.txt2.setText(ketQua.getStringList().get(1));
//                holder.txt3.setText(ketQua.getStringList().get(2));
//                holder.txt4.setText(ketQua.getStringList().get(3));
//                holder.txt5.setVisibility(View.GONE);
//                holder.txt6.setVisibility(View.GONE);
                break;
            case 5:
                List<TextView> textViews5 = new ArrayList<>();
                textViews5.add(holder.txt1);
                textViews5.add(holder.txt2);
                textViews5.add(holder.txt3);
                textViews5.add(holder.txt4);
                textViews5.add(holder.txt5);
                textViews5.add(holder.txt6);

                for (int i = 0;i<ketQua.getStringList().size();i++) {
                    textViews5.get(i).setText(ketQua.getStringList().get(i));
                }
//                holder.txt1.setText(ketQua.getStringList().get(0));
//                holder.txt2.setText(ketQua.getStringList().get(1));
//                holder.txt3.setText(ketQua.getStringList().get(2));
//                holder.txt4.setText(ketQua.getStringList().get(3));
//                holder.txt5.setText(ketQua.getStringList().get(4));
//                holder.txt6.setText(ketQua.getStringList().get(5));
                break;
            case 6:
                List<TextView> textViews6 = new ArrayList<>();
                textViews6.add(holder.txt1);
                textViews6.add(holder.txt2);
                textViews6.add(holder.txt3);

                for (int i = 0;i<ketQua.getStringList().size();i++) {
                    textViews6.get(i).setText(ketQua.getStringList().get(i));
                }
//                holder.txt1.setText(ketQua.getStringList().get(0));
//                holder.txt2.setText(ketQua.getStringList().get(1));
//                holder.txt3.setText(ketQua.getStringList().get(2));
//                holder.txt4.setVisibility(View.GONE);
//                holder.txt5.setVisibility(View.GONE);
//                holder.txt6.setVisibility(View.GONE);
                break;
            case 7:
                List<TextView> textViews7 = new ArrayList<>();
                textViews7.add(holder.txt1);
                textViews7.add(holder.txt2);
                textViews7.add(holder.txt3);
                textViews7.add(holder.txt4);

                for (int i = 0;i<ketQua.getStringList().size();i++) {
                    textViews7.get(i).setText(ketQua.getStringList().get(i));
                }
//                holder.txt1.setText(ketQua.getStringList().get(0));
//                holder.txt2.setText(ketQua.getStringList().get(1));
//                holder.txt3.setText(ketQua.getStringList().get(2));
//                holder.txt4.setText(ketQua.getStringList().get(3));
//                holder.txt5.setVisibility(View.GONE);
//                holder.txt6.setVisibility(View.GONE);
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
