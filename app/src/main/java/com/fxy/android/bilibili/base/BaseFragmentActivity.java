package com.fxy.android.bilibili.base;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.KeyEvent;

/**
 *
 * @author FXY
 * @date 2017/10/17 0017
 * 这边主要是是对BaseActivity进一步封装，提供了BaseFragment的基础操作。
 * 主要会用到的方法是1.添加fragment：replaceFragment 2.移除fragment：popFragmentWithBackStack
 */

public abstract class BaseFragmentActivity extends BaseActivity {
    protected FragmentManager mFragmentManager;

    /**
     * 主要是封装了非空判断
     * @return FragmentManager
     */
    public FragmentManager getBaseFragmentManager(){
        if(mFragmentManager==null){
            mFragmentManager=getFragmentManager();
        }
        return mFragmentManager;
    }

    /**
     * @return Fragment事务管理器
     */
    public FragmentTransaction getBaseTransaction(){
        return getBaseFragmentManager().beginTransaction();
    }

    /**
     * fragment添加操作，并且设置是否添加到回退栈当中。
     * @param containerViewId
     * @param fragment
     * @param isAddToBackStack
     */
    public void addFragment(int containerViewId,BaseFragment fragment,boolean isAddToBackStack){
        FragmentTransaction fragmentTransaction=getBaseTransaction();
        fragmentTransaction.add(containerViewId,fragment,fragment.getClass().getSimpleName());
        if(isAddToBackStack){
            fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        fragmentTransaction.commit();
    }

    /**
     * fragment替换操作，并且设置是否添加到回退栈中
     * commitAllowingStateLoss主要是允许发生异常时状态值丢失的情况下也能够正常提交事务。
     * @param containerViewId
     * @param fragment
     * @param isAddToBackStack
     */
    public void replaceFragment(int containerViewId,BaseFragment fragment,boolean isAddToBackStack){
        FragmentTransaction fragmentTransaction=getBaseTransaction();
        fragmentTransaction.replace(containerViewId,fragment);
        if(isAddToBackStack){
            fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    /**
     * 当add fragment没有入栈时，remove方法才可以正常出栈，不然只是置于null.
     * 如果你没有将Fragment加入回退栈，remove方法可以正常出栈。
     * @param fragment
     */
    public void removeFragment(BaseFragment fragment){
        FragmentTransaction fragmentTransaction=getBaseTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

    /**
     * 从回退栈中移除fragment
     * 如果你加入了回退栈，popBackStack()系列方法才能真正出栈
     */
    public void popFragmentWithBackStack(){
        if(getBaseFragmentManager().getBackStackEntryCount()>1){
            getBaseFragmentManager().popBackStack();
        }else{
            finish();
        }
    }

    /**
     * 显示fragment
     * @param fragment
     */
    public void showFragment(BaseFragment fragment){
        if(fragment.isHidden()){
            FragmentTransaction fragmentTransaction=getBaseTransaction();
            fragmentTransaction.show(fragment);
            fragmentTransaction.commit();
        }
    }

    /**
     * 隐藏fragment
     * @param fragment
     */
    public void hideFragment(BaseFragment fragment){
        if(!fragment.isHidden()){
            FragmentTransaction fragmentTransaction=getBaseTransaction();
            fragmentTransaction.hide(fragment);
            fragmentTransaction.commit();
        }
    }

    /**
     * 返回键返回事件
     * 当事务数量等于1时直接finish掉。
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(KeyEvent.KEYCODE_BACK==keyCode){
            if(getBaseFragmentManager().getBackStackEntryCount()==1){
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
