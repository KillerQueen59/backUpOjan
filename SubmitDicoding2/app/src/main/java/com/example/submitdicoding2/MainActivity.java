package com.example.submitdicoding2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private RecyclerView recyclerView;
    private ListAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private GridAdapter adapter1;

    private ArrayList<ListItem> mListItem;
    private ArrayList<GridItem> mGridItem;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recview);
        recyclerView.setHasFixedSize(true);
        BottomNavigationView bottomNavigationView = findViewById(R.id.botnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        createListList();
        createGridList();
        buildRecyclerView();
        buildGridView();

    }




    private void buildRecyclerView() {
        adapter = new ListAdapter(mListItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this,ShowDetails.class);
                intent.putExtra("List Item",mListItem.get(position));
                startActivity(intent);
            }
        });

    }

    private void buildGridView() {
        adapter1 = new GridAdapter(mGridItem);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);

        adapter1.setOnClickItemListener(new GridAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent1 = new Intent(MainActivity.this,ShowDetails2.class);
                intent1.putExtra("Grid Item",mGridItem.get(position));
                startActivity(intent1);
            }
        });
    }

    private void createListList() {
        mListItem = new ArrayList<>();
        mListItem.add(new ListItem(R.drawable.hajard,"Eden Hazard","Chelsea to Real Madrid","€ 100.0 M","Eden Michael Hazard is a Belgian professional footballer who plays for Real Madrid and captains the Belgium national team. Primarily playing as an attacking midfielder and as a wide midfielder, Hazard is known for his creativity, speed, dribbling and excellent passing."));
        mListItem.add(new ListItem(R.drawable.deyong,"Frenkie de Jong"," Ajax to Barcelona","€ 75.0 M","Frenkie de Jong is a Dutch professional footballer who plays as a midfielder for Ajax and the Dutch national team. He will join FC Barcelona on July 1st. Born in Gorinchem, de Jong began his professional career at Willem II in 2015, but transferred to Ajax for a fee of €1 a year later."));
        mListItem.add(new ListItem(R.drawable.lucas,"Lucas Hernandez","Athletico Madrid to Bayern Munich","€ 80.0 M","Lucas François Bernard Hernandez, or simply Lucas, is a French professional footballer who plays for Spanish club Atlético Madrid and the French national team as a left back or a central defender."));
        mListItem.add(new ListItem(R.drawable.luka,"Luka Jovic","Frankfurt to Real Madrid","€ 60.0 M","Luka Jović is a Serbian professional footballer who plays for German club Eintracht Frankfurt and the Serbia national team as a striker. From July 2019, he will play for Spanish side Real Madrid. "));
        mListItem.add(new ListItem(R.drawable.beran,"Julian Brandt","B.Leverkussen to B. Dortmund","€ 25.0 M","Julian Brandt is a German professional footballer who plays as a winger for Bayer Leverkusen and the German national team. Brandt made over 55 combined appearances for Germany's youth teams, playing at every level from U15 to U21. He was a member of the squad that won the UEFA European Under-19 Championship in 2014. "));
        mListItem.add((new ListItem(R.drawable.amsey,"Aaron Ramsey","Arsenal to Juventus","Free ","Aaron James Ramsey is a Welsh professional footballer who plays as a midfielder for Premier League club Arsenal and the Wales national team. Ramsey mainly plays as a box-to-box midfielder, but has also been deployed on the left and right wings")));

    }
    private void createGridList() {
        mGridItem = new ArrayList<>();
        mGridItem.add(new GridItem(R.drawable.hajard,"Eden Hazard","Chelsea to Real Madrid","€ 100.0 M","Eden Michael Hazard is a Belgian professional footballer who plays for Real Madrid and captains the Belgium national team. Primarily playing as an attacking midfielder and as a wide midfielder, Hazard is known for his creativity, speed, dribbling and excellent passing."));
        mGridItem.add(new GridItem(R.drawable.deyong,"Frenkie de Jong"," Ajax to Barcelona","€ 75.0 M","Frenkie de Jong is a Dutch professional footballer who plays as a midfielder for Ajax and the Dutch national team. He will join FC Barcelona on July 1st. Born in Gorinchem, de Jong began his professional career at Willem II in 2015, but transferred to Ajax for a fee of €1 a year later."));
        mGridItem.add(new GridItem(R.drawable.lucas,"Lucas Hernandez","Athletico Madrid to Bayern Munich","€ 80.0 M","Lucas François Bernard Hernandez, or simply Lucas, is a French professional footballer who plays for Spanish club Atlético Madrid and the French national team as a left back or a central defender."));
        mGridItem.add(new GridItem(R.drawable.luka,"Luka Jovic","Frankfurt to Real Madrid","€ 60.0 M","Luka Jović is a Serbian professional footballer who plays for German club Eintracht Frankfurt and the Serbia national team as a striker. From July 2019, he will play for Spanish side Real Madrid. "));
        mGridItem.add(new GridItem(R.drawable.beran,"Julian Brandt","B.Leverkussen to B. Dortmund","€ 25.0 M","Julian Brandt is a German professional footballer who plays as a winger for Bayer Leverkusen and the German national team. Brandt made over 55 combined appearances for Germany's youth teams, playing at every level from U15 to U21. He was a member of the squad that won the UEFA European Under-19 Championship in 2014. "));
        mGridItem.add((new GridItem(R.drawable.amsey,"Aaron Ramsey","Arsenal to Juventus","Free ","Aaron James Ramsey is a Welsh professional footballer who plays as a midfielder for Premier League club Arsenal and the Wales national team. Ramsey mainly plays as a box-to-box midfielder, but has also been deployed on the left and right wings")));


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.button_list:
                buildRecyclerView();
                break;
            case R.id.button_grid :
                buildGridView();
                break;

        }
        return true;    }
}
