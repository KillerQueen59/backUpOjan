package com.example.listview;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

// ArrayAdapter untuk data yang sedikit dan simple
//BaseA Adapter untuk data yg lebih kompleks
public class MainActivity extends AppCompatActivity {
    private String [] dataName;
    private String [] dataDesc;
    private TypedArray ImagePhoto;
    private HeroAdapter adapter;
    private ArrayList<Hero> Herolist;

    // private String[] dataName = {"Cut Nyak Dien","Ki Hajar Dewantara","Moh Yamin","Patimura","R A Kartini","Sukarno"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter =new HeroAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
       // ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,dataName);//
        listView.setAdapter(adapter);
        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,Herolist.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addItem() { // nampilin data
        Herolist = new ArrayList<>();
        for (int i = 0 ; i < dataName.length;i++){
            Hero hero = new Hero();
            hero.setPhoto(ImagePhoto.getResourceId(i,-1));//
            hero.setName(dataName[i]);
            hero.setDesc(dataDesc[i]);
            Herolist.add(hero);// memasukkan ke ArrayList
        }
            adapter.setHerolist(Herolist);
    }

    private void prepare() { // ngambil data
        dataName = getResources().getStringArray(R.array.data_name);
        dataDesc = getResources().getStringArray(R.array.data_description);
        ImagePhoto = getResources().obtainTypedArray(R.array.data_photo);
    }


}
