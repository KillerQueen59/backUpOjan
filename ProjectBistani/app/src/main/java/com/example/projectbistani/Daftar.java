package com.example.projectbistani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Daftar extends AppCompatActivity {
    TextView masukText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        masukText = findViewById(R.id.masuk);
        masukText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent();
                finish();
                overridePendingTransition(R.anim.up_out,R.anim.down_out);

            }
        });
    }
}
