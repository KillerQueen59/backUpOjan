package com.example.myactionbar;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();//menampilkan custom item pada action ba
        menuInflater.inflate(R.menu.option_men,menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);//
        if (searchManager != null){
            android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView)(menu.findItem(R.id.searchMenu)).getActionView(); // aktivasi searchView
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));//
            searchView.setQueryHint(getResources().getString(R.string.search_hint));//memberikan hint pada pengguna tentang query search apa yang telah dimasukkan.
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                /*
               Gunakan method ini ketika search selesai atau OK
                */
                @Override
                public boolean onQueryTextSubmit(String s) {
                    Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
                    return false;
                }
                /*
                            Gunakan method ini untuk merespon tiap perubahan huruf pada searchView
                             */
                @Override
                public boolean onQueryTextChange(String s) {
                    return true;
                }
            });

        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                MenuFragment menuFragment = new MenuFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,menuFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

                 return true;
            case R.id.menu2 :
                Intent i = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(i);
                return true;
            default:
                return true;
        }
    }
}
