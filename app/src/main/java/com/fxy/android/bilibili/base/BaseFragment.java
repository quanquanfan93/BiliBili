package com.fxy.android.bilibili.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


import butterknife.ButterKnife;

/**
 *
 * @author FXY
 * @date 2017/10/16 0016
 * 这边主要是对fragment进行了一个封装，包括了设置布局ID和里面View,同时也包括了ButterKnife的注解绑定
 * 以及防止内存重启后getActivity()空指针情况的做法
 */

public abstract class BaseFragment extends Fragment implements View.OnTouchListener{
    protected AppCompatActivity mActivity;

    /**
     * 获取布局ID
     *
     * @return 返回布局ID
     */
    public abstract int getContentViewId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(getContentViewId(),container,false);
        ButterKnife.bind(this,view);
        initialAllMembersView(savedInstanceState);
        return view;
    }

    /**
     * 初始化
     * @param savedInstanceState
     */
    public abstract void initialAllMembersView(Bundle savedInstanceState);

    /**
     * app在后台运行时，资源紧张的情况下app的资源会被回收（杀死app进程），这个时候再把app从后台调到前台时，这个app就会重启（总的过程成为内存重启）
     * 屏幕旋转等配置发生变化时也会导致当前的Activity重启，内部机制和内存重启的过程差不多。
     * 系统在把app回收前会保存Activity的状态，而Activity中FragmentManager会保存Fragment。Fragment会在Activity的onCreate方法调用后紧接着恢复（从onAttach开始）
     * 目的：为了防止内存重启后，调用getActivity()返回为null，报空指针异常
     * 通常原因:在调用getActivity()，当前的fragment就已经onDetach()了宿主Activity
     * 例如:pop了Fragment后，该Fragment的异步操作仍在执行，但是在执行完成之后调用getActivity()方法报空指针。
     * 保证Fragment在onDetach()后仍持有Activity的引用，仍能通过getActivity()获取到（但是有内存泄露的风险）
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity=(AppCompatActivity)context;
    }


    /**
     * 防止点击穿透问题
     * 回传true可以防止穿透。Fragment被点击时，监听器回传true，表明点击已经被当前页面吸收了。
     * @param view
     * @param motionEvent
     * @return
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return true;
    }

}
