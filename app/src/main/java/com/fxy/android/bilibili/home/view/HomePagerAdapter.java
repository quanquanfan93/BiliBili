package com.fxy.android.bilibili.home.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 *
 * @author FXY
 * @date 2017/11/17 0017
 */

public class HomePagerAdapter extends FragmentStatePagerAdapter {
    private String[] titles={"直播","推荐","追番","影视","专栏"};

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new LiveFragment();
            case 1:
                return new RecommendFragment();
            case 2:
                return new BangumiFragment();
            case 3:
                return new MovieFragment();
            case 4:
                return  new ColumnFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
