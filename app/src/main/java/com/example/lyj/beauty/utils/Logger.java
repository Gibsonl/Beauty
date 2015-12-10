package com.example.lyj.beauty.utils;

import android.util.Log;

import com.example.lyj.beauty.config.AppConfig;


/**
 * ־
 * */
public class Logger {
	
	public static final String HTTP="HTTP"; 
	
	public static void e(String tag,String content){
		if(AppConfig.DEBUG){
			Log.e(tag, content);
		}
	}
	
	

}
