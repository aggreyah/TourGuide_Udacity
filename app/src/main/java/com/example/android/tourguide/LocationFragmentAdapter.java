package com.example.android.tourguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class LocationFragmentAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"Hotels and restaurants", "Accommodations", "Utilities",
            "Railway Stations", "Airports", "Game reserves"};

    public LocationFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HotelsFragment();
        } else if (position == 1) {
            return new AccommodationsFragment();
        } else if (position == 2) {
            return new UtilitiesFragment();
        } else if (position == 3){
            return new RailwaysFragment();
        } else if (position == 4){
            return new AirportsFragment();
        }else{
            return new GameReservesFragment();
        }
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
