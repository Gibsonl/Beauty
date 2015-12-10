package com.example.lyj.beauty.fragments.viewPagerGuide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lyj.beauty.R;
import com.example.lyj.beauty.beans.VpGuideEntity;
import com.example.lyj.beauty.https.HttpParams;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2015/12/8.
 */
public class GuideFragment01 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.guidefragment,container,false);
initView(rootView);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initView(View v) {


    }
    //下载数据
    private void LoadData(){

        RequestParams params = new RequestParams(HttpParams.HOME_VPGUIDE01);
        x.http().get(params, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson = new Gson();
                VpGuideEntity guide = gson.fromJson(result,VpGuideEntity.class);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }
}
