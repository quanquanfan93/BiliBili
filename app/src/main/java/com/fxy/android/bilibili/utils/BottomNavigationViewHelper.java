package com.fxy.android.bilibili.utils;

/**
 * Created by Administrator on 2017/11/15 0015.
 */
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import java.lang.reflect.Field;

/**
 * @author FXY
 * 这边主要是对ButtomNavigationView进行内部修改
 * 去掉原来的动画效果，并且将每个icon和里面的字体大小缩小成原来的0.8倍
 */
public class BottomNavigationViewHelper {
    public static void disableShiftMode(BottomNavigationView bottomNavigationView){
        BottomNavigationMenuView bottomNavigationMenuView=(BottomNavigationMenuView)bottomNavigationView.getChildAt(0);
        try{
            Field shiftingMode=bottomNavigationMenuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(bottomNavigationMenuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < bottomNavigationMenuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) bottomNavigationMenuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());

                //这边用来设置底部导航栏的图片和数字的大小，缩小成原来的0.8倍
                item.setScaleX((float)0.8);
                item.setScaleY((float)0.8);
            }

        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
