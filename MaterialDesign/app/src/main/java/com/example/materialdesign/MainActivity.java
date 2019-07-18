package com.example.materialdesign;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener {
    private RecyclerView recview;
    private ArrayList<Avengers> list = new ArrayList<>();
    private String title = "Mode List";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recview = findViewById(R.id.recview);
        recview.setHasFixedSize(true);
        BottomNavigationView bottomNavigationView = findViewById(R.id.BotNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        list.addAll(AvengersData.getListData());
        showRecyclerGrid();
        showRecyclerList();
        showRecyclerCard();
    }

    private void showRecyclerCard() {
        recview.setLayoutManager(new LinearLayoutManager(this));
        CardAvengersAdapter cardAvengersAdapter = new CardAvengersAdapter(this);
        cardAvengersAdapter.setListAvengers(list);
        recview.setAdapter(cardAvengersAdapter);
    }

    private void showRecyclerGrid() {
        recview.setLayoutManager(new GridLayoutManager(this,2));
        GridAvengersAdapter gridAvengersAdapter = new GridAvengersAdapter(this);
        gridAvengersAdapter.setListAvengers(list);
        recview.setAdapter(gridAvengersAdapter);
    }

    private void showRecyclerList() {
        recview.setLayoutManager(new LinearLayoutManager(this));
        ListAvengerAdapter listAvengerAdapter =  new ListAvengerAdapter(this);
        listAvengerAdapter.setListAvengers(list);
        recview.setAdapter(listAvengerAdapter);
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.btnlist:
                setActionBarTitle("Avengers Endgame");
                showRecyclerList();
                break;
            case R.id.btngrid:
                setActionBarTitle("Avengers Endgame");
                showRecyclerGrid();
                break;
            case R.id.btncard:
                setActionBarTitle("Avengers Endgame");
                showRecyclerCard();
                break;

        }
        return true;
    }
}
