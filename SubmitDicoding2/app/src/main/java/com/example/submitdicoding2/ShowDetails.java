package com.example.submitdicoding2;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ShowDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        Intent intent = getIntent();
        ListItem listItem = intent.getParcelableExtra("List Item");

        int imageRes = listItem.getImageResource();
        String player1 = listItem.getPlayer();
        String details1 = listItem.getDetails();

        ImageView imageView = findViewById(R.id.photo2);
        imageView.setImageResource(imageRes);

        TextView textView1 = findViewById(R.id.player2);
        textView1.setText(player1);

        TextView textView2 = findViewById(R.id.details2);
        textView2.setText(details1);
    }
}
