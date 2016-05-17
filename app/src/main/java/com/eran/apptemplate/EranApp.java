package com.eran.apptemplate;

import android.app.Application;
import android.content.Context;
/**
 * 类描述：自定义项目Application
 * 创建人： 唐僧 Eran
 * 创建时间：2016/5/3
 * 修改人： 唐僧 Eran
 * 修改时间：2016/5/3
 * 修改备注：
 */
public class EranApp extends Application {
	private static Context mContext;
   // private DBManager dbHelper;
	@Override
	public void onCreate() {
		super.onCreate();
		mContext = getApplicationContext();

	}
	
	public static Context getContext() {
		return mContext;
	}
}
