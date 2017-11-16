package com.fxy.android.bilibili.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.fxy.android.bilibili.R;
import com.fxy.android.bilibili.base.BaseFragmentActivity;
import com.fxy.android.bilibili.utils.BottomNavigationViewHelper;
import com.fxy.android.bilibili.utils.ToastUtils;

import butterknife.BindView;

/**
 * @author FXY
 */
public class MainActivity extends BaseFragmentActivity implements NavigationView.OnNavigationItemSelectedListener{
    @BindView(R.id.tb_main_tool)
    Toolbar mToolbar;
    @BindView(R.id.dl_main)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation)
    NavigationView mNavigationView;
    @BindView(R.id.bnv_main_view)
    BottomNavigationView mBottomNavigationView;


    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initialAllMembersView(Bundle savedInstanceState) {
        setSupportActionBar(mToolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_drawer_home);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        mNavigationView.setNavigationItemSelectedListener(this);
        displayNavigationViewScrollbars(mNavigationView);
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
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
}
