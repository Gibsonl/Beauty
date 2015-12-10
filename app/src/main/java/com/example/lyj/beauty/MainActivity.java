package com.example.lyj.beauty;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.RadioGroup;

import com.example.lyj.beauty.activities.BaseActivity;
import com.example.lyj.beauty.fragments.CategoryFragment;
import com.example.lyj.beauty.fragments.GiftFragment;
import com.example.lyj.beauty.fragments.HomeFragment;
import com.example.lyj.beauty.fragments.MineFragment;
import com.example.lyj.beauty.utils.PageFragmentUtil;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.x;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    private final String TAG = MainActivity.class.getSimpleName();

    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //导入布局
        x.view().inject(this);
        fm=getSupportFragmentManager();
        initView();
    }
    private void initView(){


    }


    @Event(value=R.id.table_Rg,type=RadioGroup.OnCheckedChangeListener.class)
    private void onCheckedChanged(RadioGroup group, int checkedId){
        switch (checkedId){
            case R.id.home_Rb:
                PageFragmentUtil.switchPages(fm,R.id.container, HomeFragment.class,HomeFragment.TAG);
                break;

            case R.id.gift_Rb:
                PageFragmentUtil.switchPages(fm,R.id.container, GiftFragment.class,GiftFragment.TAG);

                break;

            case R.id.category_Rb:
                PageFragmentUtil.switchPages(fm,R.id.container,CategoryFragment.class,CategoryFragment.TAG);
                break;

            case R.id.mine_Rb:
                PageFragmentUtil.switchPages(fm,R.id.container, MineFragment.class,MineFragment.TAG);
                break;
        }
    }




}
