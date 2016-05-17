package com.eran.apptemplate.network.okhttp;

import com.eran.apptemplate.callback.BaseCallback;
import com.eran.apptemplate.model.UserModel;
import com.eran.apptemplate.model.WebResult;
import com.zhy.http.okhttp.OkHttpUtils;

import okhttp3.Call;

/**
 * 类描述：
 * 创建人： 唐僧 Eran
 * 创建时间：2016/5/16
 * 修改人： 唐僧 Eran
 * 修改时间：2016/5/16
 * 修改备注：
 */
public interface WebApi {
    /**
     * 请求登录
     * 描述：登录接口
     * 接口地址：
     * 请求方式：POST
     */
    void login(String userName,String passWord, BaseCallback<UserModel> baseCallback);
}
