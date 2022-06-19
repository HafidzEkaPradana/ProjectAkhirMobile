package com.sugarseries.projectakhirmobile.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sugarseries.projectakhirmobile.R;
import com.sugarseries.projectakhirmobile.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder>{


    private Context context;
    private ArrayList<Car> dataMobil;
    private Dialog dialog;

    @NonNull
    @Override
    public CarAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_mobil, parent, false);
        return new MyViewHolder(itemView);
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView namamobil, jenis, jumlah, merk, harga;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            namamobil = itemView.findViewById(R.id.txnamaMobil);
            jenis = itemView.findViewById(R.id.txjenis);
            jumlah = itemView.findViewById(R.id.txjumlah);
            merk = itemView.findViewById(R.id.txmerk);
            harga = itemView.findViewById(R.id.txharga);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.MyViewHolder holder, int position) {
        holder.namamobil.setText(dataMobil.get(position).getNamaMobil());
        holder.jenis.setText(dataMobil.get(position).getJenisMobil());
        holder.jumlah.setText(dataMobil.get(position).getJumlah());
        holder.merk.setText(dataMobil.get(position).getMerk());
        holder.harga.setText(dataMobil.get(position).getHarga());
    }

    @Override
    public int getItemCount() {
        return dataMobil.size();
    }

    public CarAdapter(Context cont, ArrayList<Car> data){
        context = cont;
        dataMobil = data;
    }
}
