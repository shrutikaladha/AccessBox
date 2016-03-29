package com.accessbox.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.accessbox.fragment.FavoriteFragment;
import com.accessbox.fragment.MainCategoryFragment;
import com.accessbox.fragment.ShortlistFragment;

/**
 * Created by shrutika on 29/3/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private int NUM_ITEMS = 3;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: MainCategoryFragment mainCategoyFragment = new MainCategoryFragment();
                return mainCategoyFragment;
            case 1: FavoriteFragment favoriteFragment = new FavoriteFragment();
                return favoriteFragment;
            case 2: ShortlistFragment shortlistFragment = new ShortlistFragment();
                return shortlistFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "All";
            case 1:
                return "Favorite";
            case 2:
                return "Shortlist";
            default:
                return "Not assigned";
        }
    }
}
