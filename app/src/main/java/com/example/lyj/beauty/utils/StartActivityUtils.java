package com.example.lyj.beauty.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.lyj.beauty.MyApplication;


public class StartActivityUtils {
	private static final int REQUEST_CODE=0;
	private static final int RESULT_CODE=1;
	public static  void jump(Context context,Class<?> cls,boolean isFinsih){
		Intent intent=new Intent(MyApplication.getAppContext(), cls);
		context.startActivity(intent);
		if(isFinsih){
			((Activity) context).finish();
		}
		
	}
	
	public static void jumFragment(Context context,Class<?> cls){
		Intent intent=new Intent(context,cls);
		context.startActivity(intent);
	}



	
}
