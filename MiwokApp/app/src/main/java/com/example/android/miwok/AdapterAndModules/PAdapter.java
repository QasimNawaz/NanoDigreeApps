package com.example.android.miwok.AdapterAndModules;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.miwok.Activities.ColorsFragment;
import com.example.android.miwok.Activities.FamilyFragment;
import com.example.android.miwok.Activities.NumbersFragment;
import com.example.android.miwok.Activities.PhrasesFragment;

/**
 * Created by Qasim Nawaz on 10/5/2016.
 */



public class PAdapter extends FragmentPagerAdapter
{
    int PAGE_NUM = 4;

    public PAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:{
                return "Colors";
            }
            case 1:{
                return "Family";
            }
            case 2:{
                return "Numbers";
            }
            case 3:{
                return "Phrases";
            }
            default:{
                return null;
            }
        }
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:{
                return new ColorsFragment();
            }
            case 1:{
                return new FamilyFragment();
            }
            case 2:{
                return new NumbersFragment();
            }
            case 3:{
                return new PhrasesFragment();
            }
            default:{
                return null;
            }
        }


    }

    @Override
    public int getCount() {
        return PAGE_NUM;
    }
}
