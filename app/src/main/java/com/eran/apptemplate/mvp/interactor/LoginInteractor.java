package com.eran.apptemplate.mvp.interactor;

import com.eran.apptemplate.callback.BaseCallback;
import com.eran.apptemplate.model.UserModel;

import java.util.List;

/**
 * 类描述：
 * 创建人： 唐僧 Eran
 * 创建时间：2016/5/17
 * 修改人： 唐僧 Eran
 * 修改时间：2016/5/17
 * 修改备注：
 */
public interface LoginInteractor {
    interface OnFinishedListener {
        void loginFinished();
    }
    /**
     * 请求登录
     * 描述：登录接口
     * 接口地址：
     * 请求方式：POST
     */
    void login(String userName,String passWord, OnFinishedListener onFinishedListener);
}
