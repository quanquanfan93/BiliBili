package com.fxy.android.bilibili.home.view;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.fxy.android.bilibili.R;
import com.fxy.android.bilibili.base.BaseFragment;

import butterknife.BindFont;
import butterknife.BindView;

/**
 *
 * @author FXY
 * @date 2017/11/16 0016
 */

public class HomeFragment extends BaseFragment{
    @BindView(R.id.psts_home_tab)
    PagerSlidingTabStrip mPagerSlidingTabStrip;
    @BindView(R.id.vp_home_pager)
    ViewPager mViewPager;
    /**
     * 获取当前屏幕的密度
     */
    private DisplayMetrics dm;

    @Override
    public int getContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initialAllMembersView(Bundle savedInstanceState) {
        mViewPager.setAdapter(new HomePagerAdapter(getChildFragmentManager()));
        mPagerSlidingTabStrip.setViewPager(mViewPager);
        dm = getResources().getDisplayMetrics();
        setTabsValue();
    }

    /**
     * 对PagerSlidingTabStrip的各项属性进行赋值。
     */
    private void setTabsValue() {
        //设置Tab是自动填充满屏幕的
        mPagerSlidingTabStrip.setShouldExpand(true);
        //设置Tab的分割线为透明
        mPagerSlidingTabStrip.setDividerColor(Color.TRANSPARENT);
        //设置Tab的背景色
        mPagerSlidingTabStrip.setBackgroundColor(getResources().getColor(R.color.theme_color_primary));
        //设置Tab Indicator的高度
        mPagerSlidingTabStrip.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, dm));// 4
        //设置Tab Indicator的颜色
        mPagerSlidingTabStrip.setIndicatorColor(Color.WHITE);
        //设置Tab底部线的高度
        mPagerSlidingTabStrip.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0, dm));
        //将字体换成正常非加粗的颜色
        mPagerSlidingTabStrip.setTypeface(null, Typeface.NORMAL);
        //设置字体颜色
        mPagerSlidingTabStrip.setTextColor(Color.parseColor("#99FFFFFF"));

        //将tab里面的字体变大
        final LinearLayout linearLayout=(LinearLayout)mPagerSlidingTabStrip.getChildAt(0);
        for(int i=0;i<linearLayout.getChildCount();i++){
            TextView textView=(TextView)linearLayout.getChildAt(i);
            textView.setScaleX((float)1.15);
            textView.setScaleY((float)1.15);
        }
        TextView textViewFirst=(TextView)linearLayout.getChildAt(0);
        textViewFirst.setTextColor(Color.parseColor("#FFFFFF"));

        mPagerSlidingTabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for(int i=0;i<linearLayout.getChildCount();i++){
                    TextView textView = (TextView) linearLayout.getChildAt(i);
                    if(i==position) {
                      textView.setTextColor(Color.parseColor("#FFFFFF"));
                    }else {
                        textView.setTextColor(Color.parseColor("#99FFFFFF"));
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
