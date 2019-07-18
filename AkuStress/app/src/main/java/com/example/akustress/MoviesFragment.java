package com.example.akustress;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MoviesFragment extends Fragment  {
    private String[] dataTitle;
    private String[] dataDesc;
    private String[] dataDate;
    private String[] dataRate;
    private TypedArray dataPoster;
    View view;
    private MovieAdapter adapter;
    ArrayList<Movie> movies = new ArrayList<>();


    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        MovieAdapter adapter = new MovieAdapter(getContext());
        view = inflater.inflate(R.layout.fragment_movies, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.setMovieList(movies);
        recyclerView.setAdapter(adapter);
        prepare();
        addItem();

        return view;
    }

    private void addItem() {
        for (int i = 0; i < dataTitle.length ; i++){
            Movie movie = new Movie();
            movie.setPosterFilm(dataPoster.getResourceId(i,-1));
            movie.setTitleFilm(dataTitle[i]);
            movie.setDateFilm(dataDate[i]);
            movie.setDescFilm(dataDesc[i]);
            movie.setRateFilm(dataRate[i]);
            movies.add(movie);
        }
    }
    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataDate = getResources().getStringArray(R.array.data_date);
        dataDesc = getResources().getStringArray(R.array.data_desc);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        dataRate = getResources().getStringArray(R.array.data_rate);
    }



}
