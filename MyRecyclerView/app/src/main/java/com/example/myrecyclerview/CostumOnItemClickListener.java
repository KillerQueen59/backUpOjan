package com.example.myrecyclerview;

import android.view.View;

public class CostumOnItemClickListener implements View.OnClickListener{//menangani aksi ketika item dari RecyclerView diklik
    private int position;
    private OnItemClickCallBack onItemClickCallBack;
    CostumOnItemClickListener(int position,OnItemClickCallBack onItemClickCallBack){
        this.position = position;
        this.onItemClickCallBack = onItemClickCallBack;//
    }



    @Override
    public void onClick(View v) {
        onItemClickCallBack.onItemClicked(v ,position);
    }

    public interface OnItemClickCallBack {
            void onItemClicked(View view,int position);
    }
}
