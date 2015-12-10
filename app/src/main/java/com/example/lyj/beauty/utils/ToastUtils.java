package com.example.lyj.beauty.utils;

import android.widget.Toast;

import com.example.lyj.beauty.MyApplication;


/**
 * @author: 李勇健
 * @类   说   明:	
 * @version 1.0
 * @创建时间：2015-11-14 下午5:40:01
 * 
 */
public class ToastUtils {
	public static void toast(String info){
		Toast.makeText(MyApplication.getAppContext(), info, Toast.LENGTH_SHORT).show();
	}

	public static void toastGravity(String info,int gravity,int xOffset,int yOffset){
		Toast toast=Toast.makeText(MyApplication.getAppContext(),info,Toast.LENGTH_SHORT);
		toast.setGravity(gravity,xOffset,yOffset);
		toast.show();
	}


}
