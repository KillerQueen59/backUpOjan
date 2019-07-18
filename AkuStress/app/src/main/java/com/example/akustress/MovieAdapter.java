package com.example.akustress;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context context;

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    private ArrayList<Movie> movieList;

    public MovieAdapter(Context context) {
        this.context = context;
        movieList = new ArrayList<>();
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.titleMovie.setText(getMovieList().get(i).getTitleFilm());
        viewHolder.dateMovie.setText(getMovieList().get(i).getDateFilm());
        viewHolder.descMovie.setText(getMovieList().get(i).getDescFilm());
        viewHolder.rateMovie.setText(getMovieList().get(i).getRateFilm());
        Glide.with(context)
                .load(getMovieList().get(i).getPosterFilm())
                .apply(new RequestOptions().override(250,550))
                .into(viewHolder.posterMovie);

        viewHolder.btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ShowDetails.class);
                intent.putExtra(ShowDetails.EXTRA_TITLE,movieList.get(i));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return getMovieList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleMovie;
        TextView descMovie;
        TextView dateMovie;
        TextView rateMovie;
        ImageView posterMovie;
        Button btnMoreInfo;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnMoreInfo = itemView.findViewById(R.id.btnMoreInfo);
            titleMovie = itemView.findViewById(R.id.judulFilm);
            dateMovie = itemView.findViewById(R.id.dateFilm);
            descMovie = itemView.findViewById(R.id.descFilm);
            rateMovie = itemView.findViewById(R.id.rateText);
            posterMovie = itemView.findViewById(R.id.posterFilm);
        }
    }
}
