package com.example.barvolume;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText panjang,lebar,tinggi;
    Button Hitung;
    TextView Hasil;
    private static final String HASIL_PASTI  = "hasil_pasti";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        panjang = findViewById(R.id.isipanjang);
        lebar = findViewById(R.id.isilebar);
        tinggi = findViewById(R.id.isitinggi);
        Hitung = findViewById(R.id.button1);
        Hasil = findViewById(R.id.hasil);

        Hitung.setOnClickListener(this); // This = actvity yg sedang dipakai

        if (savedInstanceState != null){
            String  hasilnya = savedInstanceState.getString(HASIL_PASTI);
            Hasil.setText(hasilnya);
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId()== R.id.button1){
            String isipanjang = panjang.getText().toString().trim(); //
            String isilebar = lebar.getText().toString().trim();
            String isitinggi = tinggi.getText().toString().trim();

            boolean jangankosong = false;   // biar string ga kosong
            boolean jangandobel = false;    // biar string sesuai

            if (TextUtils.isEmpty(isipanjang)){ //
                jangankosong = true;
                panjang.setError("Gaboleh Kosong Dude");
            }
            if (TextUtils.isEmpty(isilebar)){
                jangankosong = true;
                lebar.setError("Gaboleh Kosong Dude");
            }
            if (TextUtils.isEmpty(isitinggi)){
                jangankosong = true;
                tinggi.setError("Gaboleh Kosong Dude");
            }

            Double panjang1 = toDouble(isipanjang);
            Double lebar1 = toDouble(isilebar);
            Double tinggi1 = toDouble(isitinggi);

            if(panjang1 == null){
                jangandobel = true ;
                panjang.setError("Cek Lagi Coba");
            }
            if(lebar1 == null){
                jangandobel = true ;
                lebar.setError("Cek Lagi Coba");
            }
            if(tinggi1 == null){
                jangandobel = true ;
                tinggi.setError("Cek Lagi Coba");
            }
            if (!jangandobel && !jangankosong){
               double volume = panjang1*lebar1*tinggi1;
               Hasil.setText(String.valueOf(volume));
            }


        }
    }

    private Double toDouble(String a) { //
        try{
            return Double.valueOf(a);
        }catch (NumberFormatException e){
            return null;
        }
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(HASIL_PASTI,Hasil.getText().toString());
    }
}
