package com.example.submission2final;

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
    private ArrayList<Movies> listMovies;

    public MoviesAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Movies> getListMovies() {
        return listMovies;
    }

    public void setListMovies(ArrayList<Movies> listMovies) {
        this.listMovies = listMovies;
    }




    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.ite,viewGroup,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.titleFilm.setText(getListMovies().get(i).getDataTitle());
        categoryViewHolder.descFilm.setText(getListMovies().get(i).getDataDesc());
        categoryViewHolder.dateFilm.setText(getListMovies().get(i).getDataDate());
        categoryViewHolder.rateFilm.setText(getListMovies().get(i).getDataRate());
        Glide.with(context)
                .load(getListMovies().get(i).getDataPoster())
                .apply(new RequestOptions().override(250,550))
                .into(categoryViewHolder.posterFilm);


    }

    @Override
    public int getItemCount() {
        return getListMovies().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView titleFilm;
        TextView dateFilm;
        TextView descFilm;
        TextView rateFilm;
        ImageView posterFilm;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            titleFilm = itemView.findViewById(R.id.judulFilm);
            dateFilm = itemView.findViewById(R.id.dateFilm);
            descFilm = itemView.findViewById(R.id.descFilm);
            rateFilm = itemView.findViewById(R.id.rateText);
            posterFilm = itemView.findViewById(R.id.posterFilm);
        }
    }
}
