package com.example.rumusbangunan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText p,l;
    Button hitung;
    TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p = findViewById(R.id.panjang);
        l = findViewById(R.id.lebar);
        hitung = findViewById(R.id.button);
        hasil = findViewById(R.id.txt_hasil);
        hitung.setOnClickListener(v -> {
            //jika tidak mengisi panjang dan lebar sekaligus maka akan tampil notifikasi
            if(p.length()==0 && l.length()==0){
                Toast.makeText(getApplication(),"Panjang dan lebar tidak boleh Kosong",Toast.LENGTH_LONG).show();
            }
            //notifikasi ini akan muncul jika panjangnya tidak diisi
            else if (p.length()==0){
                Toast.makeText(getApplication(),"Panjang tidak boleh kososng", Toast.LENGTH_LONG).show();
            }
            //notifikasi jika lebar tidak diisi
            else if (l.length()==0){
                Toast.makeText(getApplication(),"Lebar tidak boleh kosong",Toast.LENGTH_LONG).show();
            }
            else{
                String isipanjang = p.getText().toString();
                String isilebar = l.getText().toString();
                double p = Double.parseDouble(isipanjang);
                double l = Double.parseDouble(isilebar);
                double hs = LuasPersegiPanjang(p,l);
                String output = String.valueOf(hs);
                hasil.setText(output);
            }
        });
    }
    public double LuasPersegiPanjang(double p, double l){return p*l;}
}