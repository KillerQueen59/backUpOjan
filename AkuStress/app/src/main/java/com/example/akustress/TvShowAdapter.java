package com.example.akustress;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.CategoryViewHoldeer> {
    private Context context;
    private ArrayList<TvShow> tvShowsList;
    AdapterView.OnItemClickListener onItemClickListener;

    public ArrayList<TvShow> getTvShowsList() {
        return tvShowsList;
    }

    public void setTvShowsList(ArrayList<TvShow> tvShowsList) {
        this.tvShowsList = tvShowsList;
    }

    public TvShowAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHoldeer onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tv,viewGroup,false);
        CategoryViewHoldeer holder = new CategoryViewHoldeer(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHoldeer categoryViewHoldeer, final int i) {
       ViewHolder(categoryViewHoldeer,i);

    }
    public void ViewHolder(CategoryViewHoldeer categoryViewHoldeer,final int i){
        categoryViewHoldeer.titleTv.setText(getTvShowsList().get(i).getTitleTv());
        categoryViewHoldeer.dateTv.setText(getTvShowsList().get(i).getDateTv());
        categoryViewHoldeer.descTv.setText(getTvShowsList().get(i).getDescTv());
        categoryViewHoldeer.rateTv.setText(getTvShowsList().get(i).getRateTv());
        Glide.with(context)
                .load(getTvShowsList().get(i).getPosterTv())
                .apply(new RequestOptions().override(250,550))
                .into(categoryViewHoldeer.posterTv);

        categoryViewHoldeer.btnMoreInfoTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowDetails.class);
                intent.putExtra(ShowDetails.EXTRA_TITLE,tvShowsList.get(i));
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return getTvShowsList().size();
    }

    public class CategoryViewHoldeer extends RecyclerView.ViewHolder {
        TextView titleTv;
        TextView descTv;
        TextView dateTv;
        TextView rateTv;
        ImageView posterTv;
        Button btnMoreInfoTv;

        public CategoryViewHoldeer(@NonNull View itemView) {
            super(itemView);
            btnMoreInfoTv = itemView.findViewById(R.id.btnMoreInfoTv);
            titleTv = itemView.findViewById(R.id.judulTv);
            dateTv = itemView.findViewById(R.id.dateTv);
            descTv = itemView.findViewById(R.id.descTv);
            rateTv = itemView.findViewById(R.id.rateTextTv);
            posterTv = itemView.findViewById(R.id.posterTv);
        }
    }
}
