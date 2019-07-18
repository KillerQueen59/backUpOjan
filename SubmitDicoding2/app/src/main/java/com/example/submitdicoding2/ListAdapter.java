package com.example.submitdicoding2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private ArrayList<ListItem> mListItem;
    private OnItemClickListener mListener;



        public interface OnItemClickListener  {
            void onItemClick(int position);
        }

        public void setOnItemClickListener(OnItemClickListener listener){
            mListener = listener;
        }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list,parent,false);
        ListViewHolder listViewHolder = new ListViewHolder(view,mListener);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int position) {
        ListItem currentItem =  mListItem.get(position);

        listViewHolder.Photo.setImageResource(currentItem.getImageResource());
        listViewHolder.Player.setText(currentItem.getPlayer());
        listViewHolder.Club.setText(currentItem.getClub());
        listViewHolder.Price.setText(currentItem.getPrice());

    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    public static class ListViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView Photo;
        public TextView Player,Club,Price,Details;


        public ListViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            Photo = itemView.findViewById(R.id.photo);
            Player = itemView.findViewById(R.id.player);
            Club = itemView.findViewById(R.id.club);
            Price = itemView.findViewById(R.id.price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
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

    public ListAdapter(ArrayList<ListItem> listItems){
        mListItem = listItems;
    }

}
