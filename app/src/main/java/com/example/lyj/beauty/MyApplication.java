package com.example.lyj.beauty;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import org.xutils.DbManager;
import org.xutils.x;

/**
 * Created by LYJ on 2015/12/8.
 */
public class MyApplication extends Application{
    private static Context context;
    private static DbManager.DaoConfig daoConfig;
    @Override
    public void onCreate() {
        super.onCreate();
        this.context=this;

        //初始化xutils
        x.Ext.init(this);
        x.Ext.setDebug(true);


        //universe的图片下载，自带缓存,配置对象
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
                //缓存的磁盘大小
                .diskCacheSize(10*1024*1024)
                        //线程池线程的优先级,比一般要低2使的文字先出来
                .threadPriority(Thread.NORM_PRIORITY-2)
                        //加密方式
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                        //任务执行顺序，先进后出
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                        //磁盘缓存图片的数量
                .diskCacheFileCount(100)
                .build();


        //xutils初始化图片加载
        ImageLoader.getInstance().init(configuration);

        daoConfig = new DbManager.DaoConfig()
                .setDbName("beauty.db")
                .setDbDir(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS))
                .setDbVersion(1)
                .setAllowTransaction(true)
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                    }
                });

    }
    public static Context getAppContext(){
        return context;
    }
    public static  DbManager.DaoConfig getDaoConfig(){
        return daoConfig;
    }
}
