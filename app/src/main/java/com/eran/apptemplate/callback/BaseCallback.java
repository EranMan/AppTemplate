package com.eran.apptemplate.callback;

import com.eran.apptemplate.model.WebResult;
import com.google.gson.Gson;

import java.io.IOException;
import com.zhy.http.okhttp.callback.Callback;
import okhttp3.Response;

/**
 * 类描述：解析服务器返回的数据,并转换为对应的model
 * 创建人： 唐僧 Eran
 * 创建时间：2016/5/16
 * 修改人： 唐僧 Eran
 * 修改时间：2016/5/16
 * 修改备注：
 */
public abstract class BaseCallback<T> extends Callback<WebResult<T>>
{
    @Override
    public WebResult<T> parseNetworkResponse(Response response) throws IOException
    {
        String string = response.body().string();
        WebResult<T> webResult = new Gson().fromJson(string, WebResult.class);
        return webResult;
    }


}
