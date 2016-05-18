package com.eran.apptemplate.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * @类描述：Activity 自定义管理器
 * @创建人：Eran
 * @创建时间：2015/3/27 17:02
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class ScreenManager {
    private static Stack<Activity> activityStack;
    private static ScreenManager instance;
    private ScreenManager(){
    }


    public static ScreenManager getScreenManager(){
        if(instance==null){
            instance=new ScreenManager();
        }
        return instance;
    }


    public void popActivity(){
        Activity activity=activityStack.lastElement();
        if(activity!=null){
            activity.finish();
            activity=null;
        }
    }


    public void popActivity(Activity activity){
        if(activity!=null){
            activity.finish();
            activityStack.remove(activity);
            activity=null;
        }
    }


    public Activity currentActivity(){
        Activity activity = null;
        if(activityStack.size()>0){
            activity=activityStack.lastElement();
        }

        return activity;
    }


    public void pushActivity(Activity activity){
        if(activityStack==null){
            activityStack=new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 只留下一个Acitvity
     * @param cls
     */
    public void popAllActivityExceptOne(Class cls){
        while(true){
            Activity activity=currentActivity();
            if(activity==null){
                break;
            }
            if(activity.getClass().equals(cls) ){
                break;
            }
            popActivity(activity);
        }
    }

    /**
     * 结束所有Activity 退出程序
     */
    public void popAllActivityExcept(){
        while(true){
            Activity activity=currentActivity();
            if(activity==null){
                break;
            }
            popActivity(activity);
        }
    }
}
