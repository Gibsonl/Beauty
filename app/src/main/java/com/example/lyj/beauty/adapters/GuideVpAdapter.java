package com.example.lyj.beauty.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2015/12/8.
 */
public class GuideVpAdapter extends FragmentPagerAdapter {
    private List<Fragment> data;
    public GuideVpAdapter(FragmentManager fm,List<Fragment> data) {
        super(fm);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }
}
