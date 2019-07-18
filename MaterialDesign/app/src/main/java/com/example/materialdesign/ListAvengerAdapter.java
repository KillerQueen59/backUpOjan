package com.example.materialdesign;

import android.content.Context;
import android.media.Image;
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

public class ListAvengerAdapter extends RecyclerView.Adapter<ListAvengerAdapter.CategoryViewHolder> {
    public ListAvengerAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<Avengers> getListAvengers() {
        return listAvengers;
    }

    public void setListAvengers(ArrayList<Avengers> listAvengers) {
        this.listAvengers = listAvengers;
    }

    private ArrayList<Avengers> listAvengers;

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.avengers_list,viewGroup,false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int posisi) {
        categoryViewHolder.Name1.setText(getListAvengers().get(posisi).getName());
        categoryViewHolder.Desc1.setText(getListAvengers().get(posisi).getDesc());

        Glide.with(context)
                .load(getListAvengers().get(posisi).getPhoto())
                .apply(new RequestOptions().override(100,300))
                .into(categoryViewHolder.Photo1);


    }

    @Override
    public int getItemCount() {
        return getListAvengers().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView Name1;
        TextView Desc1;
        ImageView Photo1;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            Name1 = itemView.findViewById(R.id.Name);
            Desc1 = itemView.findViewById(R.id.desc);
            Photo1 = itemView.findViewById(R.id.photokotak);
        }
    }
}
