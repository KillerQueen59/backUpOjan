package com.example.projectbistani;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextInputEditText EmailInput,PasswordInput;
    TextView LupaText,DaftarText;
    Button LoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EmailInput = findViewById(R.id.email);
        PasswordInput = findViewById(R.id.password);
        LupaText = findViewById(R.id.LupaPassword);
        DaftarText = findViewById(R.id.daftar);
        LoginButton = findViewById(R.id.Login);


        DaftarText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(MainActivity.this,Daftar.class);
                startActivity(LoginIntent);
                overridePendingTransition(R.anim.up_to_down,R.anim.down_in);
            }
        });
    }
}
