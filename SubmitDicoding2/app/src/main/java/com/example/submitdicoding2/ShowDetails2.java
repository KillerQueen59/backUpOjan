package com.example.submitdicoding2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetails2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details2);  Intent intent = getIntent();
        GridItem gridItem = intent.getParcelableExtra("Grid item");


        int imageRes = gridItem.getImageResource();
        String player1 = gridItem.getPlayer();
        String details1 = gridItem.getDetails();

        ImageView imageView = findViewById(R.id.photo2);
        imageView.setImageResource(imageRes);

        TextView textView1 = findViewById(R.id.player2);
        textView1.setText(player1);

        TextView textView2 = findViewById(R.id.details2);
        textView2.setText(details1);
    }
}
