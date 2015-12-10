package com.example.lyj.beauty.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lyj.beauty.R;
import com.example.lyj.beauty.fragments.MoreFragment;
import com.shizhefei.view.indicator.FragmentListPageAdapter;
import com.shizhefei.view.indicator.IndicatorViewPager.IndicatorFragmentPagerAdapter;

import java.util.List;

public class CustomViewPagerAdapter extends IndicatorFragmentPagerAdapter {

	private List<String> data;
	
	private LayoutInflater inflate;
	
	public CustomViewPagerAdapter(FragmentManager fragmentManager,Context context,List<String> data) {
		super(fragmentManager);
		// TODO Auto-generated constructor stub
		this.data = data;
		inflate = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data != null ? data.size() : 0;
	}

	@Override
	public View getViewForTab(int position, View convertView, ViewGroup container) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = inflate.inflate(R.layout.tab_top, container, false);
		}
		TextView textView = (TextView) convertView;
//		textView.setText(names[position % names.length]);
		textView.setText(data.get(position));
		textView.setPadding(20, 0, 20, 0);
		return convertView;
	}

	@Override
	public Fragment getFragmentForPage(int position) {
		// TODO Auto-generated method stub
		MoreFragment fragment = new MoreFragment();
		Bundle bundle = new Bundle();
		bundle.putInt(MoreFragment.INTENT_INT_INDEX, position);
		fragment.setArguments(bundle);
		return fragment;
	}
	
	@Override
	public int getItemPosition(Object object) {
		// TODO Auto-generated method stub
		return FragmentListPageAdapter.POSITION_NONE;
	}

}
