package com.sugarseries.projectakhirmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sugarseries.projectakhirmobile.adapter.CarAdapter;
import com.sugarseries.projectakhirmobile.model.Car;

import java.util.ArrayList;

public class DaftarMobil extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference database;
    private ArrayList<Car> list = new ArrayList<>();
    private CarAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_mobil);

        recyclerView = findViewById(R.id.carlist);
        database = FirebaseDatabase.getInstance().getReference("cars");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        carAdapter = new CarAdapter(this, list);
        recyclerView.setAdapter(carAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Car car = dataSnapshot.getValue(Car.class);
                    list.add(car);
                }
                carAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Terjadi Kesalahan",Toast.LENGTH_SHORT).show();
            }
        });

    }
}