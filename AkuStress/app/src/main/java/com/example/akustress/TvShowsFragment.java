package com.example.akustress;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowsFragment extends Fragment {
    private String[] dataTitle;
    private String[] dataDesc;
    private String[] dataDate;
    private String[] dataRate;
    private TypedArray dataPoster;
    View view;
    private TvShowAdapter adapter;
    ArrayList<TvShow> tvShows = new ArrayList<>();

    public TvShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        TvShowAdapter adapter = new TvShowAdapter(getContext());
        view = inflater.inflate(R.layout.fragment_tv_shows, container, false);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.setTvShowsList(tvShows);
        recyclerView.setAdapter(adapter);
        prepare();
        addItem();

        return view;
    }
    private void addItem() {
        for (int i = 0; i < dataTitle.length ; i++){
            TvShow tvShow = new TvShow();
            tvShow.setPosterTv(dataPoster.getResourceId(i,-1));
            tvShow.setTitleTv(dataTitle[i]);
            tvShow.setDateTv(dataDate[i]);
            tvShow.setDescTv(dataDesc[i]);
            tvShow.setRateTv(dataRate[i]);
            tvShows.add(tvShow);
        }
    }
    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title_tv);
        dataDate = getResources().getStringArray(R.array.data_date_tv);
        dataDesc = getResources().getStringArray(R.array.data_desc_tv);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster_tv);
        dataRate = getResources().getStringArray(R.array.data_rate_tv);
    }

}
