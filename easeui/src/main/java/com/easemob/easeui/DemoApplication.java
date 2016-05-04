package com.easemob.easeui;

import android.app.Application;

import com.easemob.chat.EMChat;

public class DemoApplication extends Application {

    public static boolean permission_record_audio = false; //录音权限
    public static boolean write_external_storage = false; //写出sd卡权限
    public static final int MY_PERMISSIONS_REQUEST_RECORD_AUDIO = 1;
    public static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGES = 2;

    @Override
    public void onCreate() {
        super.onCreate();
        EMChat.getInstance().setAppkey("momxmo#p2p");
        EMChat.getInstance().init(this);
        EMChat.getInstance().setDebugMode(true);//在做打包混淆时，要关闭debug模式，避免消耗不必要的资源
    }

}
