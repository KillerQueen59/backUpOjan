package com.example.serviceapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button  btnStart;
    private Button  btnStartIntent;
    private Button  btnStartBound;
    private Button  btnStopBound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);

        btnStartIntent = findViewById(R.id.btnStartIntent);
        btnStartIntent.setOnClickListener(this);

        btnStartBound = findViewById(R.id.btnStartBound);
        btnStartBound.setOnClickListener(this);

        btnStopBound = findViewById(R.id.btnStopBound);
        btnStopBound.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnStart:
                Intent intent = new Intent(MainActivity.this,PureService.class);
                startService(intent);
                break;
            case R.id.btnStartIntent:
                break;
            case R.id.btnStartBound:
                break;
            case R.id.btnStopBound:
                break;

        }
    }
}
