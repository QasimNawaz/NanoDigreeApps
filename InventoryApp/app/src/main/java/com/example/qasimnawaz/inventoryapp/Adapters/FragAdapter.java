package com.example.qasimnawaz.inventoryapp.Adapters;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> mFragmentArrayList;
    private Context mContext;

    public FragAdapter(FragmentManager fm, ArrayList<Fragment> mFragmentArrayList) {
        super(fm);
        this.mFragmentArrayList = mFragmentArrayList;
    }

    @Override
    public int getCount() {
        return mFragmentArrayList.size();
    }


    @Override
    public Fragment getItem(int position) {
        return mFragmentArrayList.get(position);
    }
}
