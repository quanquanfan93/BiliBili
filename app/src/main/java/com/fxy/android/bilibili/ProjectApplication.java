package com.fxy.android.bilibili;

import android.app.Application;

import com.fxy.android.bilibili.utils.ToastUtils;

/**
 *
 * @author FXY
 * @date 2017/10/16 0016
 */

public class ProjectApplication extends Application {

    /**
     * 获取ProjectApplication实例
     * getApplicationContext()和getResources不适用于静态方法
     * 设置Context以便全局调用可能造成内存泄露
     */
    public ProjectApplication getInstance(){
        return this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    /**
     * 对网络请求的判断。成功则判断数据是否为空；失败则提供提示消息；判断数据是否为JSONOBJECT格式
     * @param response
     * @return
     */
    public boolean onResponseCheck(String response){
        if("".equals(response)){
            ToastUtils.showLong(getApplicationContext(),getResources().getString(R.string.app_toast_none_data_error));
            return false;
        }else{
            return true;
        }
    }

    /**
     * 网络出错提示
     */
    public void onNetError(){
        ToastUtils.showLong(getApplicationContext(),getResources().getString(R.string.app_toast_network_error));
    }

    /**
     * 服务器请求出错提示
     */
    public void onServiceError(){
        ToastUtils.showLong(getApplicationContext(),getResources().getString(R.string.app_toast_service_error));
    }

    /**
     * 用户操作成功提示
     */
    public void onReturnSuccess(){
        ToastUtils.showLong(getApplicationContext(),getResources().getString(R.string.app_toast_return_success));
    }

    /**
     * 加载完所有数据提示
     */
    public void onLoadAllData(){
        ToastUtils.showLong(getApplicationContext(),getResources().getString(R.string.app_toast_load_all_data));
    }
}
