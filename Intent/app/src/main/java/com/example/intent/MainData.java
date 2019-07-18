package com.example.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainData extends AppCompatActivity {
    TextView TextData;
    public static final String EXTRA_AGE = "extra_age"; //Catatan : Key yang dikirimkan melalui putExtra() harus sama dengan key sewaktu mengambil nilai dari data yang dikirimkan melalui getStringExtra().
    public static final String EXTRA_NAME = "extra_name";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_data);
        TextData = findViewById(R.id.textdata);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE,0);// Harus ada default value untuk int extra

        String text = "Nama " + name + "\nYour Age : " + age;
        TextData.setText(text);

    }
}
