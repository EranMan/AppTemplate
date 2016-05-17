package com.eran.apptemplate.mvp.interactor;

import com.eran.apptemplate.callback.BaseCallback;
import com.eran.apptemplate.model.UserModel;
import com.eran.apptemplate.model.WebResult;
import com.eran.apptemplate.network.okhttp.UrlConstants;
import com.eran.apptemplate.network.okhttp.WebApiImp;

import okhttp3.Call;

/**
 * 类描述：
 * 创建人： 唐僧 Eran
 * 创建时间：2016/5/17
 * 修改人： 唐僧 Eran
 * 修改时间：2016/5/17
 * 修改备注：
 */
public class LoginInteractorImp extends  BaseInteractor implements LoginInteractor{
    @Override
    public void login(String userName, String passWord,final OnFinishedListener onFinishedListener) {
        new WebApiImp().login(userName, passWord, new BaseCallback<UserModel>() {
            @Override
            public void onError(Call call, Exception e) {
                     //错误处理 ;一般情况是关闭对话框,弹出错误提示信息,如有特殊处理,可在该处处理
            }

            @Override
            public void onResponse(WebResult<UserModel> response) {
                if(UrlConstants.REQUEST_SUCCES.equals(response.getCode())){//成功
                    //根据后台返回值,进行处理
                    onFinishedListener.loginFinished();
                }else {
                    requestError();
                }
            }
        });
    }
}
