package com.example.intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainObject extends AppCompatActivity {

    public static final String EXTRA_PERSON = "extra_person";

    TextView textObj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_object);
        textObj = findViewById(R.id.teksobjek);

        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : " + person.getName() + "\nAge : " + person.getAge() + "\nEmail : " + person.getEmail() + "\nCity : " + person.getCity();
        textObj .setText(text);
    }
}
