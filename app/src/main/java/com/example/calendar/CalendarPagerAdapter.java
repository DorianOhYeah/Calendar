package com.example.calendar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CalendarPagerAdapter extends FragmentStatePagerAdapter {
    private int mYear; // the year of the chosen


    public CalendarPagerAdapter(FragmentManager fm, int year) {
        super(fm);
        mYear = year;
    }

    // get the amount of the months
    public int getCount() {
        return 12;
    }

    // get the item of the month
    public Fragment getItem(int position) {
        return CalendarFragment.newInstance(mYear, position + 1);
    }

    // get the title of the month
    public CharSequence getPageTitle(int position) {
        return new String(Constant.xuhaoArray[position + 1] + "月");
    }

}