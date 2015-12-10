package com.example.lyj.beauty.utils;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


import com.example.lyj.beauty.fragments.BaseFragment;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by LYJ on 2015/11/30.
 */
public class PageFragmentUtil {

    /**缓存当前的碎片*/
    private static BaseFragment cashFragment;
    /**切换Fragment,第一个参数是碎片管理者，第二个参数是容器的id，第三个参数是，碎片的.class,第四个参数是这个碎片的TAG*/
    public static void switchPages(FragmentManager fm,int container,Class<?> cls,String tag){
        FragmentTransaction transaction=fm.beginTransaction();

        //如果当前有fragment在展示
        if(cashFragment!=null){
            //隐藏当前
            transaction.hide(cashFragment);
        }

        //找到要展示的碎片放入缓存中
        cashFragment= (BaseFragment) fm.findFragmentByTag(tag);

        //如果要展示的fragment在Fragment中就展示出来
        if(cashFragment!=null){
            transaction.show(cashFragment);

        //否则利用反射创建一个要展示的fragment
        }else{
            try {
                cashFragment= (BaseFragment) cls.getConstructor().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            //将其加入事物中栈中
            transaction.add(container,cashFragment,tag);
        }
    }

}
