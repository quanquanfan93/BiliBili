package com.fxy.android.bilibili.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.fxy.android.bilibili.R;
import com.fxy.android.bilibili.base.BaseFragmentActivity;
import com.fxy.android.bilibili.category.view.CategoryFragment;
import com.fxy.android.bilibili.communicate.view.CommunicateFragment;
import com.fxy.android.bilibili.dynamic.view.DynamicFragment;
import com.fxy.android.bilibili.home.view.HomeFragment;
import com.fxy.android.bilibili.utils.BottomNavigationViewHelper;
import com.fxy.android.bilibili.utils.ToastUtils;

import butterknife.BindView;

/**
 * @author FXY
 */
public class MainActivity extends BaseFragmentActivity implements NavigationView.OnNavigationItemSelectedListener,BottomNavigationView.OnNavigationItemSelectedListener,View.OnClickListener{
    @BindView(R.id.tb_main_tool)
    Toolbar mToolbar;
    @BindView(R.id.dl_main)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation)
    NavigationView mNavigationView;
    @BindView(R.id.bnv_main_view)
    BottomNavigationView mBottomNavigationView;
    @BindView(R.id.tv_main_title)
    TextView mTitleTextView;
    @BindView(R.id.rl_navigation_view)
    RelativeLayout mNavigationRelativeLayout;
    @BindView(R.id.iv_main_drawer_home)
    ImageView mDrawerHomeImageView;
    @BindView(R.id.rl_main_drawer_home)
    RelativeLayout mDrawerHomeRelativeLayout;
    @BindView(R.id.nested_scroll_view)
    NestedScrollView mNestedScrollView;
    @BindView(R.id.abl_main)
    AppBarLayout mAppBarLayout;

    private Menu mToolbarMenu;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initialAllMembersView(Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayShowTitleEnabled(false);
        }
        mToolbarMenu=mToolbar.getMenu();
        mNavigationView.setNavigationItemSelectedListener(this);
        mBottomNavigationView.setOnNavigationItemSelectedListener(this);
        mToolbar.setOnClickListener(this);
        displayNavigationViewScrollbars(mNavigationView);
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        replaceFragment(R.id.content_layout,new HomeFragment(),false);
        mNestedScrollView.setFillViewport(true);//解决NestedScrollView嵌套ViewPager时显示不完全的问题。
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.tb_main_toolbar_game_center:
                ToastUtils.showShort(this,"this is game center");
                break;
            case R.id.tb_main_toolbar_download:
                ToastUtils.showShort(this,"this is download");
                break;
            case R.id.tb_main_toolbar_search:
                ToastUtils.showShort(this,"this is search");
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                ToastUtils.showShort(this,"this is home");
                break;
            case R.id.nav_history:
                ToastUtils.showShort(this,"this is history");
                break;
            case R.id.nav_file_download:
                ToastUtils.showShort(this,"this is file download");
                break;
            case R.id.nav_favorite:
                ToastUtils.showShort(this,"this is favorite");
                break;
            case R.id.nav_follow:
                ToastUtils.showShort(this,"this is follow");
                break;
            case R.id.nav_watch_later:
                ToastUtils.showShort(this,"this is watch later");
                break;
            case R.id.nav_live_center:
                ToastUtils.showShort(this,"this is live center");
                break;
            case R.id.nav_vip:
                ToastUtils.showShort(this,"this is vip");
                break;
            case R.id.nav_unicom:
                ToastUtils.showShort(this,"this is unicom");
                break;
            case R.id.nav_member_order:
                ToastUtils.showShort(this,"this is member order");
                break;
            case R.id.bottom_nav_home:
                ToastUtils.showShort(this,"this is nav home");
                replaceFragment(R.id.content_layout,new HomeFragment(),false);
                mTitleTextView.setText("");
                mToolbarMenu.findItem(R.id.tb_main_toolbar_game_center).setVisible(true);
                mToolbarMenu.findItem(R.id.tb_main_toolbar_download).setVisible(true);
                mToolbarMenu.findItem(R.id.tb_main_toolbar_search).setVisible(true);
                mAppBarLayout.setElevation(0);
                break;
            case R.id.bottom_nav_category:
                ToastUtils.showShort(this,"this is nav category");
                replaceFragment(R.id.content_layout,new CategoryFragment(),false);
                mTitleTextView.setText("分区");
                mToolbarMenu.findItem(R.id.tb_main_toolbar_game_center).setVisible(false);
                mToolbarMenu.findItem(R.id.tb_main_toolbar_download).setVisible(false);
                mToolbarMenu.findItem(R.id.tb_main_toolbar_search).setVisible(true);
                mAppBarLayout.setElevation(10);
                break;
            case R.id.bottom_nav_dynamic:
                ToastUtils.showShort(this,"this is dynamic");
                replaceFragment(R.id.content_layout,new DynamicFragment(),false);
                mTitleTextView.setText("动态");
                mToolbarMenu.findItem(R.id.tb_main_toolbar_game_center).setVisible(false);
                mToolbarMenu.findItem(R.id.tb_main_toolbar_download).setVisible(false);
                mToolbarMenu.findItem(R.id.tb_main_toolbar_search).setVisible(false);
                mAppBarLayout.setElevation(10);
                break;
            case R.id.bottom_nav_communicate:
                ToastUtils.showShort(this,"this is communicate");
                replaceFragment(R.id.content_layout,new CommunicateFragment(),false);
                mTitleTextView.setText("消息");
                mToolbarMenu.findItem(R.id.tb_main_toolbar_game_center).setVisible(false);
                mToolbarMenu.findItem(R.id.tb_main_toolbar_download).setVisible(false);
                mToolbarMenu.findItem(R.id.tb_main_toolbar_search).setVisible(false);
                mAppBarLayout.setElevation(10);
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * 去掉导航页的滚动条
     * @param navigationView
     */
    public void displayNavigationViewScrollbars(NavigationView navigationView){
        if(navigationView!=null){
            NavigationMenuView navigationMenuView=(NavigationMenuView)navigationView.getChildAt(0);
            if(navigationMenuView!=null){
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }

    @Override
    public void onClick(View view) {
        mDrawerLayout.openDrawer(mNavigationRelativeLayout);
    }
}
