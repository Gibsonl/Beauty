package com.example.lyj.beauty.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lyj.beauty.MainActivity;
import com.example.lyj.beauty.R;
import com.example.lyj.beauty.activities.SaoYiSaoActivity;
import com.example.lyj.beauty.activities.SearchActivity;
import com.example.lyj.beauty.utils.StartActivityUtils;

/**
 * Created by Administrator on 2015/12/8.
 */
public class TitleBar extends RelativeLayout implements View.OnClickListener {
    private ImageView back;
    private ImageView saoyisao;
    private ImageView search;
    private TextView  title;

    private Context context;
    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context) {
        this(context, null);
    }


    private void init(Context context) {
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.titlebar,this);
        back = (ImageView)findViewById(R.id.titleBar_back);
        saoyisao = (ImageView)findViewById(R.id.titleBar_saoyisao);
        title = (TextView)findViewById(R.id.titleBar_title);
        search = (ImageView)findViewById(R.id.titleBar_search);

        back.setVisibility(View.GONE);
        search.setVisibility(View.GONE);
        saoyisao.setVisibility(View.GONE);



    }

    //设置title
    public void setTitle(String msg){
        title.setVisibility(View.VISIBLE);
        title.setText(msg);
    }
//监听查找
    public void  setSearch(){
        search.setVisibility(View.VISIBLE);
        search.setOnClickListener(this);
    }
    //监听返回
    public void  setBack(){
        back.setVisibility(View.VISIBLE);
        back.setOnClickListener(this);
    }
//监听二维码
    public void  setSaoYiSao(){
       saoyisao.setVisibility(View.VISIBLE);
        saoyisao.setOnClickListener(this);
    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.titleBar_search:
                StartActivityUtils.jump(context, SearchActivity.class,false);

            break;
            case R.id.titleBar_back:
                ((MainActivity)context).finish();
                break;
            case R.id.titleBar_saoyisao:

                StartActivityUtils.jump(context, SaoYiSaoActivity.class,false);

                break;
        }
    }
}
