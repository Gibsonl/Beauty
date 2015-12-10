package com.example.lyj.beauty.utils;


import android.content.Context;
import android.content.SharedPreferences;

import com.example.lyj.beauty.MyApplication;
import com.example.lyj.beauty.config.Constant;


/**
 * 
 * */
public class SharedPreferencesUtil {
	
	public static void putString(String key,String value){
		SharedPreferences sp= MyApplication.getAppContext().getSharedPreferences(Constant.app, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor=sp.edit();
		editor.putString(key, value);
		editor.commit();
		
	}
	
	public static String getString(String key){
		SharedPreferences sp=MyApplication.getAppContext().getSharedPreferences(Constant.app, Context.MODE_PRIVATE);
		String value=sp.getString(key, "");
		return value;
	}
	
	/**
	 *清理登录状态
	 * */
	public static void removeData(String key){
		SharedPreferences sp=MyApplication.getAppContext().getSharedPreferences(Constant.app, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor=sp.edit();
		editor.remove(key);
		editor.commit();
	}
	
}
