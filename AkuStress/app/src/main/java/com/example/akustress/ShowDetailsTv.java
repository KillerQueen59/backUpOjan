package com.example.akustress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetailsTv extends AppCompatActivity {
    public static final String EXTRA_TITLE = "extra_title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details_tv);
        TvShow tvShow = getIntent().getParcelableExtra(EXTRA_TITLE);

        ImageView Poster = findViewById(R.id.posterBesarTv);
        TextView Title = findViewById(R.id.titleDetailsTv);
        TextView Desc = findViewById(R.id.descTv);
        TextView Date = findViewById(R.id.dateTv);
        TextView Rate = findViewById(R.id.rateTextTv);


        Rate.setText(tvShow.getRateTv());
        Title.setText(tvShow.getTitleTv());
        Desc.setText(tvShow.getDescTv());
        Date.setText(tvShow.getDateTv());
        Poster.setImageResource(tvShow.getPosterTv());

    }
}
