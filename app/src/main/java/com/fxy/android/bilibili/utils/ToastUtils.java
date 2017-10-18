package com.fxy.android.bilibili.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 当前注释类：Toast
 * @author FXY
 */
public class ToastUtils {

    /**
     * 工具类无法实例化
     */
    private ToastUtils() {
            /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static boolean isShow = true;

    /**
     * 短时间显示Toast
     * @param context 上下文
     * @param message 消息
     */
    public static void showShort(Context context, CharSequence message){
        if (isShow) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 短时间显示Toast
     *
     * @param context 上下文
     * @param message 消息
     */
    public static void showShort(Context context, int message) {
        if (isShow) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 长时间显示Toast
     *
     * @param context 上下文
     * @param message 消息
     */
    public static void showLong(Context context, CharSequence message) {
        if (isShow) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 长时间显示Toast
     *
     * @param context 上下文
     * @param message 消息
     */
    public static void showLong(Context context, int message) {
        if (isShow) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context 上下文
     * @param message 消息
     * @param duration 显示时间
     */
    public static void show(Context context, CharSequence message, int duration) {
        if (isShow) {
            Toast.makeText(context, message, duration).show();
        }
    }

    /**
     * 自定义显示Toast时间
     *
     * @param context 上下文
     * @param message 消息
     * @param duration 显示时间
     */
    public static void show(Context context, int message, int duration) {
        if (isShow) {
            Toast.makeText(context, message, duration).show();
        }
    }
}
