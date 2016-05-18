package com.eran.apptemplate.config;

/**
 * @类描述： 系统配置文件
 * @创建人：龙章煌
 * @创建时间：2015-11-30
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class SystemConfig {
	/**
	 * 系统总开关
	 */
	public static boolean DEBUG = false;

    /**
     * 本日志类型只有在DEBUG为true的情况下才有效
     */
    public static final LogSwitch LOG_SWTICH = LogSwitch.ALL;

    /**
     * 日志类型
     */
    public enum LogSwitch {
        CONSOLE, //Logcat类型
        FILE, //本地文件类型
        NET, //网络类型
        ALL //所有
    }

}
