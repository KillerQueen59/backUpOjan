package com.example.swipeviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailACtivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_activity);


        TextView textView = findViewById(R.id.textView);
        textView.setText(getIntent().getStringExtra("param"));

    }
}
