package com.example.materialdesign;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardAvengersAdapter extends RecyclerView.Adapter<CardAvengersAdapter.CardViewHolder> {
    public CardAvengersAdapter(Context context) {
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
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.avengers_card, viewGroup, false);
        return new CardViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {
       Avengers p = getListAvengers().get(i);
        Glide.with(context)
                .load(p.getPhoto())
                .apply(new RequestOptions().override(180, 300))
                .into(cardViewHolder.Photo1);
        cardViewHolder.Name1.setText(p.getName());
        cardViewHolder.Desc1.setText(p.getDesc());
        cardViewHolder.btnfav.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite "+getListAvengers().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
        cardViewHolder.btnshare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getListAvengers().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

    }

    @Override
    public int getItemCount() {
        return getListAvengers().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        TextView Name1;
        TextView Desc1;
        ImageView Photo1;
        Button btnfav,btnshare;
        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            Name1 = itemView.findViewById(R.id.Name);
            Desc1 = itemView.findViewById(R.id.desc);
            Photo1 = itemView.findViewById(R.id.photokotak);
            btnfav = itemView.findViewById(R.id.btnfav);
            btnshare = itemView.findViewById(R.id.btnshare);
        }
    }
}
