package com.fxy.android.bilibili.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 *
 * @author FXY
 * @date 2017/10/16 0016
 * 这边主要是对Activity进行了一个封装，包括了设置布局ID和里面View,同时也包括了ButterKnife的注解绑定
 */

public abstract class BaseActivity extends AppCompatActivity{

    /**
     * 获取布局文件的ID
     *
     * @return 布局文件ID
     */
    protected abstract int getContentViewId();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        initialAllMembersView(savedInstanceState);
    }

    /**
     * 初始化
     * @param savedInstanceState
     */
    protected abstract void initialAllMembersView(Bundle savedInstanceState);
}
