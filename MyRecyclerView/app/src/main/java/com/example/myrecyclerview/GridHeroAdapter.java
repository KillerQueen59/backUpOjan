package com.example.myrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridHeroAdapter extends RecyclerView.Adapter<GridHeroAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Hero> heroList;

    public ArrayList<Hero> getHeroList() {
        return heroList;
    }

    public void setHeroList(ArrayList<Hero> heroList) {
        this.heroList = heroList;
    }

    public GridHeroAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_grid,viewGroup,false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int i) {
        Glide.with(context)
                .load(getHeroList().get(i).getPhotoHero())
                .apply(new RequestOptions().override(350,550))
                .into(gridViewHolder.imagePhoto);
    }

    @Override
    public int getItemCount() {
        return getHeroList().size();
    }

    public class
    GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imagePhoto;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePhoto = itemView.findViewById(R.id.photoHero);
        }
    }
}
