package com.sugarseries.projectakhirmobile.adapter;

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

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.MyViewHolder>{


    private Context context;
    private ArrayList<Car> list = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.row_mobil, parent, false);
        return new MyViewHolder(itemView);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView namamobil, jenis, jumlah, merk, harga;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            namamobil = itemView.findViewById(R.id.tv_mobil);
            jenis = itemView.findViewById(R.id.tv_jenis);
            jumlah = itemView.findViewById(R.id.tv_jumlah);
            merk = itemView.findViewById(R.id.tv_merk);
            harga = itemView.findViewById(R.id.tv_harga);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.MyViewHolder holder, int position) {

        Car car = list.get(position);
        holder.namamobil.setText(car.getNamaMobil());
        holder.jenis.setText(car.getJenis());
        holder.jumlah.setText(car.getJumlah());
        holder.merk.setText(car.getMerk());
        holder.harga.setText(car.getHarga());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public CarAdapter(Context context, ArrayList<Car> list) {
        this.context = context;
        this.list = list;
    }
}
