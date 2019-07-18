package com.example.unittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView {
    EditText textPanjang,textLebar,textTinggi;
    Button btnHitung;
    TextView textHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textPanjang = findViewById(R.id.panjang);
        textLebar = findViewById(R.id.lebar);
        textTinggi = findViewById(R.id.tinggi);
        btnHitung = findViewById(R.id.hitungbutton);
        textHasil = findViewById(R.id.hasil);

        final MainPresenter presenter = new MainPresenter(this);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String panjang = textPanjang.getText().toString().trim();
                String lebar = textLebar.getText().toString().trim();
                String tinggi = textTinggi.getText().toString().trim();

                boolean kalokosong  = false;

                if (TextUtils.isEmpty(panjang)){
                    kalokosong = true;
                    textPanjang.setError("Isi dulu Bosh");
                }
                if (TextUtils.isEmpty(lebar)){
                    kalokosong = true;
                    textLebar.setError("Isi dulu Bosh");
                }
                if (TextUtils.isEmpty(tinggi)){
                    kalokosong = true;
                    textTinggi.setError("Isi dulu Bosh");
                }
                if(!kalokosong){
                    double p = Double.parseDouble(panjang);//
                    double l = Double.parseDouble(lebar);
                    double t = Double.parseDouble(tinggi);

                    presenter.calculateVolume(p,l,t);

                }

            }
        });
    }

    @Override
    public void showVolume(MainModel model) {
        textHasil.setText(String.valueOf(model.getVolume()));
    }
}
