package com.upgrad.viewpagerdemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int tabCount;


    PagerAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                ChatFragment chatFragment = new ChatFragment();
                return  chatFragment;
            case 1 :
                StatusFragment statusFragment = new StatusFragment();
                return  statusFragment;
            case 2 :
                CallsFragment callsFragment = new CallsFragment();
                return  callsFragment;
            default:
                return  null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
