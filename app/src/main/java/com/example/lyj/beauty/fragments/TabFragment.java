package com.example.lyj.beauty.fragments;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lyj.beauty.R;
import com.example.lyj.beauty.adapters.CustomViewPagerAdapter;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

import java.util.ArrayList;
import java.util.List;

public class TabFragment extends Fragment {
	//Fragment布局
	private View layout;
	//导航条
	private ScrollIndicatorView indicator;
	//滑动页面
	private ViewPager viewPager;
	//导航条和ViewPager绑定
	private IndicatorViewPager indicatorViewPager;
	
	private FragmentActivity activity;
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		this.activity = (FragmentActivity) activity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// 导入布局
		layout = inflater.inflate(R.layout.fragment_tab, container,false);
		//初始化ViewPager
		viewPager = (ViewPager) layout.findViewById(R.id.tab_viewPager);
		//初始化导航条
		indicator = (ScrollIndicatorView) layout.findViewById(R.id.tab_indicator);
		//给导航条设置ScrollBar
		indicator.setScrollBar(new ColorBar(activity, Color.RED, 5));
		
		//设置导航条的选中未选中的字体
		int selectColorId = R.color.tab_top_text_2;
		int unSelectColorId = R.color.tab_top_text_1;
	
		indicator.setOnTransitionListener(
				new OnTransitionTextListener().setColorId(activity, selectColorId, unSelectColorId));
		
		//设置保存页面2个
		viewPager.setOffscreenPageLimit(2);
		//实例化绑定的ViewPager
		indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
		//设置Adapter
		indicatorViewPager.setAdapter(new CustomViewPagerAdapter(activity.getSupportFragmentManager(), activity, getData()));
		//设置导航条自适应
		indicator.setSplitAuto(true);
		return layout;
	}
	
	private List<String> getData(){
		List<String> data = new ArrayList<String>();
		for(int i = 0; i < 10; i++){
			data.add("标签" + i);
		}
		return data;
	}
	
}
