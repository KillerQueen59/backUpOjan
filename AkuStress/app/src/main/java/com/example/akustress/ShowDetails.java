package com.example.akustress;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.akustress.Movie;
import com.example.akustress.R;

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
        TextView Rate = findViewById(R.id.rateText);


        Rate.setText(movie.getRateFilm());
        Title.setText(movie.getTitleFilm());
        Desc.setText(movie.getDescFilm());
        Date.setText(movie.getDateFilm());
        Poster.setImageResource(movie.getPosterFilm());

    }
}
