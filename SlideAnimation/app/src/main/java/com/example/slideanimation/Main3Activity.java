package com.example.slideanimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    Button next3,back3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        next3 = findViewById(R.id.next3);
        next3.setOnClickListener(this);
        back3 = findViewById(R.id.back3);
        back3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.next3:
                Intent intent2 = new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent2);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                break;
            case R.id.back3:
                Intent intent3 = new Intent(Main3Activity.this,Main2Activity.class);
                startActivity(intent3);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                break;
        }
    }
}
