package com.example.costumview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ButtonDude buttonDude;
    private EdtiTextDude edtiTextDude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtiTextDude = findViewById(R.id.editTextDude);
        buttonDude = findViewById(R.id.buttonDude);

        setButtonEnabled();

        edtiTextDude.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setButtonEnabled();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edtiTextDude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,edtiTextDude.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setButtonEnabled() {
        Editable result = edtiTextDude.getText();
        if (result != null && !result.toString().isEmpty()){
            buttonDude.setEnabled(true);
        }else {
            buttonDude.setEnabled(false);
        }
    }
}
