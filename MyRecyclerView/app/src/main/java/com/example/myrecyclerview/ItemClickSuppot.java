package com.example.myrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemClickSuppot  { // kelas untuk memberikan aksi ketika list di tekan
    private final RecyclerView mRecycleView;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mOnItemClickListener!= null){
                RecyclerView.ViewHolder holder =mRecycleView.getChildViewHolder(v);
                mOnItemClickListener.onItemClicked(mRecycleView,holder.getAdapterPosition(),v);
            }
        }
    };

    private View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if (mOnItemLongClickListener != null){
                RecyclerView.ViewHolder holder = mRecycleView.getChildViewHolder(v);
                return mOnItemLongClickListener.onItemLongClicked(  mRecycleView,holder .getAdapterPosition(),v);
            }
            return false;
        }
    };
    private RecyclerView.OnChildAttachStateChangeListener mAttachListener = new RecyclerView.OnChildAttachStateChangeListener() {
        @Override
        public void onChildViewAttachedToWindow(@NonNull View view) {
            if (mOnItemClickListener != null){
                view.setOnClickListener(mOnClickListener);
            }
            if (mOnItemLongClickListener != null){
                view.setOnLongClickListener(mOnLongClickListener);
            }
        }

        @Override
        public void onChildViewDetachedFromWindow(@NonNull View view) {

        }
    };

    public ItemClickSuppot(RecyclerView recycleView) {
        mRecycleView = recycleView;
        mRecycleView.setTag(R.id.item_click_support,this);
        mRecycleView.addOnChildAttachStateChangeListener(mAttachListener);
    }

    public static ItemClickSuppot addTo(RecyclerView mRecycleView) { //
        ItemClickSuppot suppot =(ItemClickSuppot) mRecycleView.getTag(R.id.item_click_support);
        if (suppot == null){
            suppot = new ItemClickSuppot(mRecycleView);
        }
            return suppot;
    }

    public static  ItemClickSuppot removeFrom(RecyclerView mRecycleView) { //
        ItemClickSuppot suppot =(ItemClickSuppot) mRecycleView.getTag(R.id.item_click_support);
        if (suppot != null){
            suppot.detach(mRecycleView);
        }
        return  suppot ;
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mOnItemClickListener = listener;
    }
    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mOnItemLongClickListener = listener;
    }
    private void detach(RecyclerView mRecycleView) {
        mRecycleView.removeOnChildAttachStateChangeListener(mAttachListener);
        mRecycleView.setTag(R.id.item_click_support,null);
    }



    public interface OnItemClickListener {
        void onItemClicked(RecyclerView recyclerView,int i,View v);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClicked (RecyclerView recyclerView,int i,View v);
    }



}

