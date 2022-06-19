package com.sugarseries.projectakhirmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView daftar,pesan, histori, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        daftar = findViewById(R.id.daftarMobil);
        pesan = findViewById(R.id.pemesanan);
        histori = findViewById(R.id.histori);
        about = findViewById(R.id.about);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DaftarMobil.class));
            }
        });

    }
}