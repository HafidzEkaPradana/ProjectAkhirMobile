package com.sugarseries.projectakhirmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.sugarseries.projectakhirmobile.adapter.CarAdapter;
import com.sugarseries.projectakhirmobile.model.Car;

import java.util.ArrayList;
import java.util.List;

public class DaftarMobil extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    private List<Car> list = new ArrayList<>();
    private CarAdapter carAdapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_mobil);

        recyclerView = findViewById(R.id.recyclerview);
        carAdapter = new CarAdapter(getApplicationContext(), (ArrayList<Car>) list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(carAdapter);

    }
    @Override
    protected void onStart(){
        super.onStart();
        getData();
    }

    private void getData(){
        db.collection("cars")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataChanged")
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                Car car = new Car(document.getString("namaMobil"),document.getString("jenis"),document.getString("tempatduduk"),document.getString("merk"),document.getString("harga"));
                                car.setId(document.getId());
                                list.add(car);
                            }
                            carAdapter.notifyDataSetChanged();
                        }else{
                            Toast.makeText(getApplicationContext(),"Data gagal diambil", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}