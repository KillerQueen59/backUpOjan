package com.example.submission2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Movies> movieList;


    public ArrayList<Movies> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movies> movieList) {
        this.movieList = movieList;
    }

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie,viewGroup,false);
        CategoryViewHolder holder = new CategoryViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.titleFilm.setText(getMovieList().get(i).getDataTitle());
        categoryViewHolder.dateFilm.setText(getMovieList().get(i).getDataDate());
        categoryViewHolder.descFilm.setText(getMovieList().get(i).getDataDesc());
        categoryViewHolder.rateFilm.setText(getMovieList().get(i).getDataRate());
        Glide.with(context)
                .load(getMovieList().get(i).getDataPoster())
                .apply(new RequestOptions().override(250,550))
                .into(categoryViewHolder.posterFilm);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView titleFilm;
        TextView dateFilm;
        TextView descFilm;
        TextView rateFilm;
        ImageView posterFilm;

        public CategoryViewHolder(View view) {
            super(view);
            titleFilm = view.findViewById(R.id.judulFilm);
            dateFilm = view.findViewById(R.id.dateFilm);
            descFilm = view.findViewById(R.id.descFilm);
            rateFilm = view.findViewById(R.id.rateText);
            posterFilm = view.findViewById(R.id.posterFilm);
        }
    }
}
