package com.example.ma.seat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CustomAdapter extends FragmentPagerAdapter {
    int images[] = {R.drawable.gametitle_01,R.drawable.gametitle_02,R.drawable.gametitle_03};

    public CustomAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position){
        return Image_Fragment.newInstance(images[position]);
    }

    @Override
    public int getCount() {
        return images.length;
    }
}