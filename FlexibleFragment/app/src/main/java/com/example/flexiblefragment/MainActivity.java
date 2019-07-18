package com.example.flexiblefragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager mFragmentManager = getSupportFragmentManager();//merupakan antarmuka untuk mengorganisir obyek fragment yang terdapat didalam sebuah Activity.
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();// untuk biar bisa di add,replace,commit.
        HomeFragment mHomeFragment = new HomeFragment();// jadii homefragment objek

        Fragment fragment = mFragmentManager.findFragmentByTag(HomeFragment.class.getSimpleName());//

        if (!(fragment instanceof  HomeFragment)){//
            mFragmentTransaction.add(R.id.tempat_frame,mHomeFragment,HomeFragment.class.getSimpleName()); // menambahkan obyek fragment ke dalam layout container
            Log.d("MyFlexibleFragment","Fragment Name : " + HomeFragment.class.getSimpleName()); //
            mFragmentTransaction.commit();//untuk melakukan pemasangan obyek secara asynchronous untuk ditampilkan ke antar muka pengguna 

        }

    }
}
