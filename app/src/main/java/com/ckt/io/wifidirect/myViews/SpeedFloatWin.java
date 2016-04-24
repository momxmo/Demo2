package com.ckt.io.wifidirect.myViews;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.ckt.io.wifidirect.R;


/**
 * Created by admin on 2015/11/11.
 */
public class SpeedFloatWin {

    static boolean isFloatViewAdded = false;
    static boolean isFirstShow = true;
    static int x;
    static int y;
    static View view;


    public static void hide(Context context) {
        final WindowManager wm = (WindowManager) context.getApplicationContext()
                .getSystemService(Context.WINDOW_SERVICE);
        if (isFloatViewAdded && view != null) {
            wm.removeViewImmediate(view);
        }
        isFloatViewAdded = false;

        //保存悬浮窗口的位置
        SharedPreferences mySharedPreferences = context.getSharedPreferences(
                "WifiDirect", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putInt("x", x);
        editor.putInt("y", y);
        editor.commit();
    }

    public static void updateSpeed(String sendSpeed, String receviceSpeed) {
        if (view == null) return;
        TextView txt_sendSpeed = (TextView) view.findViewById(R.id.txt_speed_send);
        txt_sendSpeed.setText(sendSpeed);
        TextView txt_receiveSpeed = (TextView) view.findViewById(R.id.txt_speed_recevice);
        txt_receiveSpeed.setText(receviceSpeed);
        //wm.updateViewLayout(v, params);
        view.invalidate();
    }
}
