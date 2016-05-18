package com.eran.apptemplate;

import android.app.Application;
import android.content.Context;

import com.eran.apptemplate.exception.crash.CustomCrash;

/**
 * 类描述：自定义项目Application
 * 创建人： 唐僧 Eran
 * 创建时间：2016/5/3
 * 修改人： 唐僧 Eran
 * 修改时间：2016/5/3
 * 修改备注：
 */
public class EranApp extends Application {
	private static EranApp instance;
	public  static EranApp getInstance(){
		return instance;
	}
   // private DBManager dbHelper;
	@Override
	public void onCreate() {
		super.onCreate();
		instance =this;
		//初始化崩溃日志收集器
		CustomCrash mCustomCrash=CustomCrash.getInstance();
		//mCustomCrash.setCustomCrashInfo(this);
	}
}
