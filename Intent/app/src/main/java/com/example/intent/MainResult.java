package com.example.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MainResult extends AppCompatActivity implements View.OnClickListener {
    RadioGroup radiogaga;
    Button choose;

    public static String EXTRA_SELECTED_VALUE = "extra_selected_value"; // sebagai key untuk putExtra
    public static int RESULT_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_result);

        radiogaga = findViewById(R.id.radiogaga);
        choose = findViewById(R.id.pilih);

        choose.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.pilih){
            if (radiogaga.getCheckedRadioButtonId()!=0){
                int angka = 0;
                switch (radiogaga.getCheckedRadioButtonId()){ // untuk mengecek nilai dari radio button
                    case R.id._10:
                        angka = 10;
                        break;
                    case R.id._15:
                        angka = 15;
                        break;
                    case R.id._20:
                        angka = 20;
                        break;
                    case R.id._19:
                        angka = 19;
                        break;
                }
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE,angka);
                setResult(RESULT_CODE,resultIntent);
                finish(); // untuk menutup activity , jadi gaharus pake intent untuk ke activitt awal

            }
        }
    }


}
