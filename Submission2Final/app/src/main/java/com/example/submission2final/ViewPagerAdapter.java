package com.example.submission2final;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    private final List<Fragment> lstFragment = new ArrayList<>();
    private final List<String> lstString = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return lstFragment.get(i);
    }

    @Override
    public int getCount() {
        return lstString.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lstString.get(position);
    }
    public void AddFragment(Fragment fragment,String s) {
        lstFragment.add(fragment);
        lstString.add(s);
    }
}
