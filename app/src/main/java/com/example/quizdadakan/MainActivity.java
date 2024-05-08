package com.example.quizdadakan;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgps, rgtambahan;
    RadioButton rbps5, rbps4, rbps3, rbpsvr, rbIndomie, rbMie, rbSiomay;
    EditText etjam;
    Button btnproses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rgps = findViewById(R.id.rgps);
        rgtambahan = findViewById(R.id.rgtambahan);
        rbps5 = findViewById(R.id.rbps5);
        rbps4 = findViewById(R.id.rbps4);
        rbps3 = findViewById(R.id.rbps3);
        rbpsvr =  findViewById(R.id.rbpsvr);
        rbIndomie = findViewById(R.id.rbIndomie);
        rbMie =  findViewById(R.id.rbMie);
        rbSiomay = findViewById(R.id.rbSiomay);
        etjam = findViewById(R.id.etjam);
        btnproses = findViewById(R.id.btnproses);


        private int Jam = 0;


        btnproses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { prosesTransaksi  }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void prosesTransaksi() {
        Integer type = rgps.getCheckedRadioButtonId();
        RadioButton type = findViewById(rgps);
        String pilihtype = rgps.getTooltipText().toString();
        int typePrice = 0;
        switch (pilihtype) {
            case "Ps5":
                typePrice = 10000;
                break;
            case "Ps4":
                typePrice = 8000;
                break;
            case "Ps3":
                typePrice = 5000;
                break;
            case "PsVR":
                typePrice = 2000;
                break;
        }

        int tambah = rgtambahan.getCheckedRadioButtonId();
        RadioButton pilihtambahan = findViewById(tambah);
        String pilihtambah = pilihtambahan.getText().toString();
        int tambah = 0;
        switch (pilihtambah) {
            case "Indomie":
                tambah = 7000;
                break;
            case "Mie Ayam":
                tambah = 10000;
                break;
            case "Siomay":
                tambah = 5000;
                break;
        }
        String hoursString = etjam.getText().toString();
        int Jam;
        if (!hoursString.isEmpty()) {
            Jam = Integer.parseInt(hoursString);
        }


        int totalPrice = (typePrice * Jam) + tambah;


        String result = "Tipe: " + pilihtype + " (" + typePrice + "/Jam)" +
                "\nTambahan: " + pilihtambah + " (" + tambah + ")" +
                "\nWaktu: " + Jam + " jam" +
                "\nTotal: " + totalPrice;
        textViewResult.setText(result);

    }
}