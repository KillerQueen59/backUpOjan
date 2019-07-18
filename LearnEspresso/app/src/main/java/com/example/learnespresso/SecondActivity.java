package com.example.learnespresso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textResult;
    public  static  final String EXTRA_INPUT = "extra_input";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Activity Second");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        textResult= findViewById(R.id.textAct2);
        String input = getIntent().getStringExtra(EXTRA_INPUT);
        textResult.setText(input);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
