package com.tutorialsee.ecommer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter1 extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter1(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Eapp1 tab1 = new Eapp1();
                return tab1;
           // case 1:
            //    Eapp2 tab2 = new Eapp2();
              //  return tab2;
            //case 2:
              //  Eapp3 tab3 = new Eapp3();
                //return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}