package com.example.moviecatalogue2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetails extends AppCompatActivity {
    public static final String EXTRA_TITLE = "extra_title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        Movie movie = getIntent().getParcelableExtra(EXTRA_TITLE);

        ImageView Poster = findViewById(R.id.posterBesarMovie);
        TextView Title = findViewById(R.id.titleDetailsMovie);
        TextView Desc = findViewById(R.id.descMovie);
        TextView Date = findViewById(R.id.dateMovie);
        ImageView Backdrops = findViewById(R.id.backDrop);

        Backdrops.setImageResource(movie.getBackdrop());
        Poster.setImageResource(movie.getPoster());
        Title.setText(movie.getTitle());
        Desc.setText(movie.getDesc());
        Date.setText(movie.getDate());
    }
}
