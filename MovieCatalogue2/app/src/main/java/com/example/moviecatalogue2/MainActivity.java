package com.example.moviecatalogue2;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataTitle;
    private String[] dataDesc;
    private String[] dataDate;
    private TypedArray dataBackdrop;// mengambil string gambar
    private TypedArray dataPoster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.list_v);

        listView.setAdapter(adapter);
        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Movie movie = new Movie();
                movie.setTitle(movies.get(position).getTitle());
                movie.setDesc(movies.get(position).getDesc());
                movie.setDate(movies.get(position).getDate());
                movie.setPoster(movies.get(position).getPoster());
                movie.setBackdrop(movies.get(position).getBackdrop());

                Intent goURL = new Intent(MainActivity.this, ShowDetails.class);
                goURL.putExtra(ShowDetails.EXTRA_TITLE,  movie);
                startActivity(goURL);
            }
        });

    }
    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataTitle.length ; i++){
            Movie movie = new Movie();
            movie.setPoster(dataPoster.getResourceId(i,-1));
            movie.setTitle(dataTitle[i]);
            movie.setDate(dataDate[i]);
            movie.setDesc(dataDesc[i]);
            movie.setBackdrop(dataBackdrop.getResourceId(i,-1));
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataDate = getResources().getStringArray(R.array.data_date);
        dataDesc = getResources().getStringArray(R.array.data_desc);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        dataBackdrop = getResources().obtainTypedArray(R.array.data_backdrop);
    }
}
