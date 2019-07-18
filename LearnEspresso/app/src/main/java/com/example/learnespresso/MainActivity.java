package com.example.learnespresso;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtText;
    Button btnGantiText,btnGantiAct;
    TextView textText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar()!=null){
            getSupportActionBar().setTitle("Learn Espresso");
        }
        edtText = findViewById(R.id.edtText);
        btnGantiAct = findViewById(R.id.btn_ganti_act);
        btnGantiText = findViewById(R.id.btn_ganti_text);
        textText = findViewById(R.id.textText);

        btnGantiText.setOnClickListener(this);
        btnGantiAct.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ganti_act:
                String text = edtText.getText().toString().trim();
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra(SecondActivity.EXTRA_INPUT,text);
                startActivity(intent);
                break;
            case R.id.btn_ganti_text:
                String lalalaText = "Lalala";
                edtText.setText(lalalaText);
                String input  = edtText.getText().toString().trim();
                textText.setText(input);
                break;
        }
    }



}
