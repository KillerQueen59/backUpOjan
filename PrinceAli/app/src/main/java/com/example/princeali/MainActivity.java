package com.example.princeali;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button Press,Reset;
    TextView Number;
    int num1 = 0;

    private static final String HASIL_PASTI = "hasilpasti";


    public void onPress(View view){
        num1++;
        Number.setText(String.valueOf(num1));
    }
    public void onReset(View view){
        num1=0;
        Number.setText(String.valueOf(num1));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Press = findViewById(R.id.Press);
        Number = findViewById(R.id.number);
        Reset = findViewById(R.id.Reset);
    if (savedInstanceState != null){
String Hasil =savedInstanceState.getString(HASIL_PASTI);
        Number.setText(Hasil);
            }

    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(HASIL_PASTI,Number.getText().toString());
    }

}
