package com.example.myrecyclerview;

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

public class CardHeroAdapter extends RecyclerView.Adapter<CardHeroAdapter.CategoryViewHolder> {
    private Context context;

    public ArrayList<Hero> getListHero() {
        return listHero;
    }

    public void setListHero(ArrayList<Hero> listHero) {
        this.listHero = listHero;
    }

    private ArrayList<Hero> listHero;


    public CardHeroAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public CardHeroAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_row_card,viewGroup,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHeroAdapter.CategoryViewHolder categoryViewHolder, final int i) {
        categoryViewHolder.tvNama.setText(getListHero().get(i).getNamaHero());
        categoryViewHolder.tvDesc.setText(getListHero().get(i).getDescHero());
        Glide.with(context)
                .load(getListHero().get(i).getPhotoHero())
                .apply(new RequestOptions().override(350,550))
                .into(categoryViewHolder.imagePhoto);

        categoryViewHolder.btnShare.setOnClickListener(new CostumOnItemClickListener(i, new CostumOnItemClickListener.OnItemClickCallBack() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context,"Share "+getListHero().get(i).getNamaHero(),Toast.LENGTH_SHORT).show();
            }
        }));
        categoryViewHolder.btnLike.setOnClickListener(new CostumOnItemClickListener(i, new CostumOnItemClickListener.OnItemClickCallBack() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context,"Like " + getListHero().get(i).getNamaHero(),Toast.LENGTH_SHORT).show();
            }
        }));

    }

    @Override
    public int getItemCount() {
        return getListHero().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        TextView tvDesc;
        ImageView imagePhoto;
        Button btnLike;
        Button btnShare;
        public CategoryViewHolder(View view) {
            super(view);
            tvNama = view.findViewById(R.id.namaHero);
            tvDesc = view.findViewById(R.id.descHero);
            imagePhoto = view.findViewById(R.id.photoHero);
            btnLike = view.findViewById(R.id.buttonLike);
            btnShare = view.findViewById(R.id.buttonShare);
        }
    }
}
