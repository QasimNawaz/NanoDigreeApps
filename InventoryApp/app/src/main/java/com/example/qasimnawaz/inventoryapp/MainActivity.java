package com.example.qasimnawaz.inventoryapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.qasimnawaz.inventoryapp.Adapters.FragAdapter;
import com.example.qasimnawaz.inventoryapp.Fragments.DetailLayout;
import com.example.qasimnawaz.inventoryapp.Fragments.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private Product mProduct;
    private DetailLayout mDetailLayout;
    private FragAdapter adapter;
    private ArrayList<Fragment> mFragmentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentArrayList = new ArrayList<>();
        mProduct = new Product();
        mDetailLayout = new DetailLayout();

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        mFragmentArrayList.add(mProduct);

        mFragmentArrayList.add(mDetailLayout);

        mTabLayout.addTab(mTabLayout.newTab().setText("Products"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Sales Detail"));
        adapter = new FragAdapter(getSupportFragmentManager(), mFragmentArrayList);
        mViewPager.setAdapter(adapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mViewPager.setOffscreenPageLimit(3);
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());

                switch (tab.getPosition()) {
                    case 0:
                        Product t = (Product) mFragmentArrayList.get(0);
                        t.refresh();
                        break;
                    case 1:
//                        DetailLayout t2= (DetailLayout) mFragmentArrayList.get(1);
                        //       DetailLayout t2 = (DetailLayout) mFragmentArrayList.get(1);
                        //     t2.refresh();
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                // mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //   mViewPager.setCurrentItem(tab.getPosition());


            }
        });


    }
}
