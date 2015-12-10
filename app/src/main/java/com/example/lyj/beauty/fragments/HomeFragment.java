package com.example.lyj.beauty.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lyj.beauty.R;
import com.example.lyj.beauty.adapters.GuideVpAdapter;
import com.example.lyj.beauty.fragments.viewPagerGuide.GuideFragment01;
import com.example.lyj.beauty.fragments.viewPagerGuide.GuideFragment02;
import com.example.lyj.beauty.fragments.viewPagerGuide.GuideFragment03;
import com.example.lyj.beauty.fragments.viewPagerGuide.GuideFragment04;
import com.example.lyj.beauty.fragments.viewPagerGuide.GuideFragment05;
import com.example.lyj.beauty.fragments.viewPagerGuide.GuideFragment06;
import com.example.lyj.beauty.views.TitleBar;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment {
    public static final String TAG=HomeFragment.class.getSimpleName();
    private TitleBar titleBar ;

    private ViewPager viewPager;
    private GuideVpAdapter adapter;
    private List<Fragment> list;
    private GuideFragment01 fragment01;
    private GuideFragment02 fragment02;
    private GuideFragment03 fragment03;
    private GuideFragment04 fragment04;
    private GuideFragment05 fragment05;
    private GuideFragment06 fragment06;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.homefragment,container,false);
        initView(rootView);
        return rootView;
    }

    private void initView(View v){
        viewPager = (ViewPager)v.findViewById(R.id.homeGuide_vp);
        titleBar = (TitleBar)v.findViewById(R.id.Home_titleBar);
        titleBar.setTitle("礼物说");
        titleBar.setSaoYiSao();
        titleBar.setSearch();
        list = new ArrayList<>();
        list.add(fragment01);
        list.add(fragment02);
        list.add(fragment03);
        list.add(fragment04);
        list.add(fragment05);
        list.add(fragment06);
        adapter = new GuideVpAdapter(getChildFragmentManager(),list);
         viewPager.setAdapter(adapter);
    }
}
