package com.example.lyj.beauty.events;


/**
 * Created by LYJ on 2015/11/30.
 */
public class BaseEvent {

    //辨别消息的类型
    public final int msg;
    //通用的数据类型
    private String data;



    public BaseEvent(int msg) {
        this.msg = msg;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }



}
