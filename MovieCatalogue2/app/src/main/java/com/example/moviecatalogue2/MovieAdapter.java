package com.example.moviecatalogue2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    private ArrayList<Movie> movies;


    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);
        }
        ViewHolder viewHolder = new ViewHolder(convertView);
        Movie movie = (Movie) getItem(position);
        viewHolder.bind(movie);
        return convertView;
    }

    private class ViewHolder {
        private TextView Name,Desc,Date;
        private ImageView Poster;
        public ViewHolder(View convertView) {
            Name = convertView.findViewById(R.id.titleMovie);
            Desc = convertView.findViewById(R.id.descMovie);
            Date = convertView.findViewById(R.id.dateMovie);
            Poster = convertView.findViewById(R.id.posteMovie);
        }
        public void bind(Movie movie) {
            Name.setText(movie.getTitle());
            Desc.setText(movie.getDesc());
            Date.setText(movie.getDate());
            Poster.setImageResource(movie.getPoster());
        }
    }


}
