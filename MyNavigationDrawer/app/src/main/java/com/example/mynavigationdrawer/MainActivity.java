package com.example.mynavigationdrawer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    CircleImageView profileCircleImageView;
    String profileImageUrl = "https://lh3.googleusercontent.com/-4qy2DfcXBoE/AAAAAAAAAAI/AAAAAAAABi4/rY-jrtntAi4/s640-il/photo.jpg";
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);// toolbar di set sebagai action bar

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Home");
        }


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//untuk menampilkan sebuah snackbar
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "Halo saya aksi dari floatingactionbutton ", Toast.LENGTH_LONG).show();
                            }
                        }).show();
            }
        });
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        profileCircleImageView = navigationView.getHeaderView(0).findViewById(R.id.imageView);// mengubah komponen view yang terdapat di dalam header sebuah navigation view,
        //Kenapa harus 0? Ini karena indeks header berada pada susunan teratas dari kumpulan list menu yang terdapat pada NavigationView.
        Glide.with(MainActivity.this)
                .load(profileImageUrl)
                .into(profileCircleImageView);
            /*
        Jika savedinstance masih null, maka redirect ke fragment home
        Berguna ketika aplikasi pertama dijalankan untuk mengisi halaman default
        dan berguna juga ketika config changes terjadi, karena fragment akan
        secara otomatis ditambahkan ke dalam activity,
        maka kita tidak perlu replace fragment kembali.
         */
        if (savedInstanceState == null) {
            Fragment currentFragment = new HomeFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.content_main, currentFragment)//
                    .commit();
        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);//
        drawerLayout.addDrawerListener(toggle);//agar obyek DrawerLayout dapat dijalankan melalui hamburger menu yang terdapat di Toolbar
        toggle.syncState();//
    }

    @Override
    protected void onPause() {
        super.onPause();
        drawerLayout.removeDrawerListener(toggle);//Listener dihapus agar tidak terjadi aktifitas yang tidak diinginkan ketika activity mengalami pause.
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Bundle bundle = new Bundle();
        Fragment fragment = null;
        String title = "";
        if (id == R.id.nav_home) {
            fragment = new HomeFragment();
        } else if (id == R.id.nav_camera) {
            // Handle the camera action
            title = "Camera";
            fragment = new PageFragment();
            bundle.putString(PageFragment.EXTRAS, "Camera");
            fragment.setArguments(bundle);
        } else if (id == R.id.nav_gallery) {
            title = "gallery";
            fragment = new PageFragment();
            bundle.putString(PageFragment.EXTRAS, "Gallery");
            fragment.setArguments(bundle);//

        } else if (id == R.id.nav_slideshow) {
            title = "slideshow";
            fragment = new PageFragment();
            bundle.putString(PageFragment.EXTRAS, "SlideShow");//
            fragment.setArguments(bundle);


        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_main, fragment)//
                    .commit();
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}
