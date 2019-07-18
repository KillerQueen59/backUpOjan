package com.example.submitdicoding2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import java.util.ArrayList;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {
    private Context context;

    public GridAdapter(Context context) {
        this.context = context;
    }

    private ArrayList<GridItem> mGridItem;
    private OnItemClickListener mListener;


    public interface OnItemClickListener  {
        void onItemClick(int position);
    }

    public void setOnClickItemListener (OnItemClickListener listener){
        mListener = listener;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_grid,parent,false);
        GridViewHolder gridViewHolder = new GridViewHolder(v,mListener);
        return gridViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int position) {
        GridItem currentItem = mGridItem.get(position);

        gridViewHolder.Photo.setImageResource(currentItem.getImageResource());
    }

    @Override
    public int getItemCount() {
        return mGridItem.size();
    }

    public static class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView Photo;

        public GridViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            Photo = itemView.findViewById(R.id.photo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }

        @Override
        public void onClick(View v) {

        }
    }
    public GridAdapter(ArrayList<GridItem> gridItems){
        mGridItem = gridItems;
    }
}
