package com.eran.apptemplate;

import android.app.Application;
import android.content.Context;

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
