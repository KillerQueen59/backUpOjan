package com.example.myrecyclerview;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<Hero> list = new ArrayList<>();
    final String STATE_TITLE    ="state_string";
    final String STATE_LIST     ="state_list";
    final String STATE_MODE     ="state_mode";
    int mode;
    String title = "Mode List";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_category);
        recyclerView.setHasFixedSize(true);// melakukan optimasi ukuran lebar dan tinggi secara otomatis

        list.addAll(HeroData.getListData());
        showRecycleList();
        showRecycleGrid();
        showRecycleCard();
        if (savedInstanceState == null){// agar data tersimpan dalam list
            setActionBarTitle(title);
            list.addAll(HeroData.getListData());
            showRecycleList();
            mode = R.id.list_menu;
        }else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Hero> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);

            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE,getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST,list);
        outState.putInt(STATE_MODE,mode);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar()!=null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showRecycleCard() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // set layout
        CardHeroAdapter cardHeroAdapter = new CardHeroAdapter(this);// set adapter
        cardHeroAdapter.setListHero(list);// set adapter ke list hero
        recyclerView.setAdapter(cardHeroAdapter);
    }

    private void showRecycleGrid() {
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        GridHeroAdapter gridHeroAdapter  = new GridHeroAdapter(this);
        gridHeroAdapter.setHeroList(list);
        recyclerView.setAdapter(gridHeroAdapter);


        ItemClickSuppot.addTo(recyclerView).setOnItemClickListener(new ItemClickSuppot.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int i, View v) {
                showSelectedHero(list.get(i)); // menampilkan dari recycle view yang di klik
            }
        });
     }

    private void showRecycleList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListHeroAdapter listHeroAdapter = new ListHeroAdapter(this);
        listHeroAdapter.setListHero(list);
        recyclerView.setAdapter(listHeroAdapter);

        ItemClickSuppot.addTo(recyclerView).setOnItemClickListener(new ItemClickSuppot.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int i, View v) {
                showSelectedHero(list.get(i));
            }
        });
        ItemClickSuppot.addTo(recyclerView).setOnItemLongClickListener(new ItemClickSuppot.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClicked(RecyclerView recyclerView, int i, View v) {
                showSelectedLongHero(list.get(i));
                return false;
            }
        });


    }

    private void showSelectedLongHero(Hero hero) {
        Toast.makeText(this,"Kamu menekan lama dan memilih "+ hero.getNamaHero(),Toast.LENGTH_LONG).show();
    }

    private void showSelectedHero(Hero hero) {
        Toast.makeText(this,"Kamu Memilih "+hero.getNamaHero(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int stateMode) {
        switch (stateMode){
            case R.id.list_menu:
                title = "Mode List";
                showRecycleList();
                break;
            case R.id.grid_menu:
                title = "Mode Grid";
                showRecycleGrid();
                break;
            case R.id.card_menu:
                title = "Mode Card";
                showRecycleCard();
                break;
        }
        mode = stateMode ;
        setActionBarTitle(title);
        }


    }

