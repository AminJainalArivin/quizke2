package com.example.quizdadakan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity_nota extends AppCompatActivity {

    TextView tvtype2, tvtambahan2, tvwaktu2, tvtotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nota);

        tvtype2 = findViewById(R.id.tvtype2);
        tvtambahan2 = findViewById(R.id.tvtambahan2);
        tvwaktu2 = findViewById(R.id.tvwaktu2);
        tvtotal = findViewById(R.id.tvtotal);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        String type = intent.getStringExtra("Type");
        String tambahan = intent.getStringExtra("Tambahan");
        String waktu = intent.getStringExtra("waktu");
        String total = intent.getStringExtra("Total");

        tvtype2.setText("Type: " + type);
        tvtambahan2.setText("Tambahan: " + tambahan);
        tvwaktu2.setText("Waktu: " + waktu);
        tvtotal.setText("Total: " + total);
    }
}