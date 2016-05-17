package com.eran.apptemplate.model;

/**
 * 类描述：负责解析服务器返回的数据(model 承载器)
 * 创建人： 唐僧 Eran
 * 创建时间：2016/5/16
 * 修改人： 唐僧 Eran
 * 修改时间：2016/5/16
 * 修改备注：
 */
public class WebResult<T> {
    private String msg;  //返回状态信息
    private String code; //返回状态码
    private T data;      //返回数据

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
