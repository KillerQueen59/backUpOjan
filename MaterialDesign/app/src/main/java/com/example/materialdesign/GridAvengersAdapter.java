package com.example.materialdesign;

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

public class GridAvengersAdapter extends RecyclerView.Adapter<GridAvengersAdapter.GridViewHolder> {

    private Context context;

    public GridAvengersAdapter(Context context) {
        this.context = context;

    }

    public ArrayList<Avengers> getListAvengers() {
        return listAvengers;
    }

    public void setListAvengers(ArrayList<Avengers> listAvengers) {
        this.listAvengers = listAvengers;
    }

    private ArrayList<Avengers> listAvengers;



    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.avengers_grid,parent,false);

        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder Holder, int posisi) {
        Holder.Nick1.setText(getListAvengers().get(posisi).getNick());

        Glide.with(context)
                .load(getListAvengers().get(posisi).getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(Holder.Photo1);
    }

    @Override
    public int getItemCount() {
        return getListAvengers().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView Photo1;
        TextView Nick1;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            Photo1 = itemView.findViewById(R.id.photokotak);
            Nick1 = itemView.findViewById(R.id.Nick);
        }
    }
}
