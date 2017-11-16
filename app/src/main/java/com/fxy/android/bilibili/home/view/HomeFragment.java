package com.fxy.android.bilibili.home.view;

import android.os.Bundle;
import android.widget.Toolbar;

import com.fxy.android.bilibili.R;
import com.fxy.android.bilibili.base.BaseFragment;

import butterknife.BindView;

/**
 *
 * @author FXY
 * @date 2017/11/16 0016
 */

public class HomeFragment extends BaseFragment{

    @Override
    public int getContentViewId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initialAllMembersView(Bundle savedInstanceState) {
    }
}
