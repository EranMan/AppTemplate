package com.eran.apptemplate.utils;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import com.eran.apptemplate.config.SystemConfig;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @类描述： 日志系统
 * @创建人：龙章煌
 * @创建时间：2015-11-30
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
public class LogUtils {

    /**
     * 保存等级大于SAVE_LOG_LEVEL的Log日志的等级
     * v:0; d:1; i:2; w:3: e:4;
     */
    private static final int SAVE_LOG_LEVEL = 2;

    private static final int LOG_LEVEL_V = 0;
    private static final int LOG_LEVEL_D = 1;
    private static final int LOG_LEVEL_I = 2;
    private static final int LOG_LEVEL_W = 3;
    private static final int LOG_LEVEL_E = 4;
    private static final int LOG_LEVEL_XC = 5;

    // sd卡中日志文件的最多保存天数
    private static final int SDCARD_LOG_FILE_SAVE_DAYS = 3;

    // sd卡中日志文件的向前清除天数
    private static final int SDCARD_LOG_FILE_CLEAN_DAYS = 30;

    // 日志文件最大保存大小: 1M
    private static final Long MAX_LOG_FILESIZE = 1000 * 1000L;

    /**
     * 进入应用后写入Log次数超过该次数后，可再次检测Log文件
     * 注：LOG_WRITE_NUMS = -1,则不需要检测次数
     */
    private static final long LOG_WRITE_NUMS = 2000L;

    //进入应用后写入Log的次数，超过LOG_WRITE_NUMS，则需要重新检测，并清零
    private static long mLogWriteNum = 0;

    // 保存Log日志的后缀名
    private static final String LOGFILE_TAGNAME = "_log.txt";
    private static final String LOGFILE_TAGNAME_CRASH = "_crash.txt";

    // 日志的输出格式
    private static SimpleDateFormat dateFormatDetail = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    // 日志文件格式
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void i(String tag, String msg) {
        if (!SystemConfig.DEBUG) return;

        if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.FILE) {
            writeLogtoFile("i", tag, msg, LOG_LEVEL_I);
        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.NET) {

        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.ALL) {
            Log.i(tag, msg);
            writeLogtoFile("i", tag, msg, LOG_LEVEL_I);
        } else {
            Log.i(tag, msg);
        }
    }

    public static void i(String tag, String msg, Throwable throwable) {
        if (!SystemConfig.DEBUG) return;

        if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.FILE) {
            writeLogtoFile("i", tag, msg, throwable, LOG_LEVEL_I);
        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.NET) {

        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.ALL) {
            Log.i(tag, msg, throwable);
            writeLogtoFile("i", tag, msg, throwable, LOG_LEVEL_I);
        } else {
            Log.i(tag, msg, throwable);
        }
    }

    public static void d(String tag, String msg) {
        if (!SystemConfig.DEBUG) return;

        if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.FILE) {
            writeLogtoFile("d", tag, msg, LOG_LEVEL_D);
        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.NET) {

        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.ALL) {
            Log.d(tag, msg);
            writeLogtoFile("d", tag, msg, LOG_LEVEL_D);
        } else {
            Log.d(tag, msg);
        }
    }

    public static void d(String tag, String msg, Throwable throwable) {
        if (!SystemConfig.DEBUG) return;

        if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.FILE) {
            writeLogtoFile("d", tag, msg, throwable, LOG_LEVEL_D);
        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.NET) {

        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.ALL) {
            Log.d(tag, msg, throwable);
            writeLogtoFile("d", tag, msg, throwable, LOG_LEVEL_D);
        } else {
            Log.d(tag, msg, throwable);
        }
    }

    public static void w(String tag, String msg) {
        if (!SystemConfig.DEBUG) return;

        if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.FILE) {
            writeLogtoFile("w", tag, msg, LOG_LEVEL_W);
        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.NET) {

        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.ALL) {
            Log.w(tag, msg);
            writeLogtoFile("w", tag, msg, LOG_LEVEL_W);
        } else {
            Log.w(tag, msg);
        }
    }

    public static void w(String tag, String msg, Throwable throwable) {
        if (!SystemConfig.DEBUG) return;

        if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.FILE) {
            writeLogtoFile("w", tag, msg, throwable, LOG_LEVEL_W);
        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.NET) {

        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.ALL) {
            Log.w(tag, msg, throwable);
            writeLogtoFile("w", tag, msg, throwable, LOG_LEVEL_W);
        } else {
            Log.w(tag, msg, throwable);
        }
    }

    public static void e(String tag, String msg) {
        if (!SystemConfig.DEBUG) return;

        if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.FILE) {
            writeLogtoFile("e", tag, msg, LOG_LEVEL_E);
        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.NET) {

        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.ALL) {
            Log.e(tag, msg);
            writeLogtoFile("e", tag, msg, LOG_LEVEL_E);
        } else {
            Log.e(tag, msg);
        }
    }

    public static void e(String tag, String msg, Throwable throwable) {
        if (!SystemConfig.DEBUG) return;

        if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.FILE) {
            writeLogtoFile("e", tag, msg, throwable, LOG_LEVEL_E);
        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.NET) {

        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.ALL) {
            Log.e(tag, msg, throwable);
            writeLogtoFile("e", tag, msg, throwable, LOG_LEVEL_E);
        } else {
            Log.e(tag, msg, throwable);
        }
    }


    public static void eCrash(String tag, String msg, Throwable throwable) {
        if (!SystemConfig.DEBUG) return;

        if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.FILE) {
            writeLogtoFile("e", tag, msg, throwable, LOG_LEVEL_XC);
        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.NET) {

        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.ALL) {
            Log.e(tag, msg, throwable);
            writeLogtoFile("e", tag, msg, throwable, LOG_LEVEL_XC);
        } else {
            Log.e(tag, msg, throwable);
        }
    }

    public static void v(String tag, String msg) {
        if (!SystemConfig.DEBUG) return;

        if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.FILE) {
            writeLogtoFile("v", tag, msg, LOG_LEVEL_V);
        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.NET) {

        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.ALL) {
            Log.v(tag, msg);
            writeLogtoFile("v", tag, msg, LOG_LEVEL_V);
        } else {
            Log.v(tag, msg);
        }
    }

    public static void v(String tag, String msg, Throwable throwable) {
        if (!SystemConfig.DEBUG) return;

        if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.FILE) {
            writeLogtoFile("v", tag, msg, throwable, LOG_LEVEL_V);
        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.NET) {

        } else if (SystemConfig.LOG_SWTICH == SystemConfig.LogSwitch.ALL) {
            Log.v(tag, msg, throwable);
            writeLogtoFile("v", tag, msg, throwable, LOG_LEVEL_V);
        } else {
            Log.v(tag, msg, throwable);
        }
    }

    /**
     * 打开日志文件并写入日志
     */
    private static String LOG_PATH_DIR = "";

    private static String getLogPathSDCardDir() {
        if (TextUtils.isEmpty(LOG_PATH_DIR)) {
            LOG_PATH_DIR = Environment.getExternalStorageDirectory().toString() + "/logfiles";
        }
        return LOG_PATH_DIR;
    }

    /**
     * 检测日志文件
     */
    public static void checkLogFile() {
        String logFileDir = getLogPathSDCardDir();
        File fileDir = new File(logFileDir);
        boolean isNeedDel = false;
        if (fileDir.exists()) {
            long fileSize = fileDir.length();
            if (fileSize > MAX_LOG_FILESIZE) {
                // 文件大小超过1M
                isNeedDel = true;
            }
            if (!isNeedDel) {
                String[] fileList = fileDir.list();
                if (fileList != null && fileList.length > SDCARD_LOG_FILE_CLEAN_DAYS) {
                    // 文件数量超过30条
                    isNeedDel = true;
                }
            }
        }
        if (isNeedDel) {
            delBeforeFile(logFileDir, SDCARD_LOG_FILE_SAVE_DAYS);
        }
    }

    /**
     * 删除制定的日志文件
     *
     * @param filePath:    Log日志的根目录
     * @param logSaveDays: 保存最近Log日志的天数
     */
    private static void delBeforeFile(String filePath, int logSaveDays) {
        for (int i = SDCARD_LOG_FILE_CLEAN_DAYS; i > logSaveDays; i--) {
            String needDelFiel = dateFormat.format(getDateBefore(i));
            File file = new File(filePath, needDelFiel + LOGFILE_TAGNAME);
            if (file.exists()) {
                file.delete();
            }
        }
        // 再次检测文件的大小是否超过1M
        File fileDir = new File(filePath);
        long fileSize = fileDir.length();
        while (fileSize > MAX_LOG_FILESIZE && logSaveDays-- > 0) {
            // 文件大小超过1M
            fileDir = new File(filePath);
            fileSize = fileDir.length();
            delBeforeFile(filePath, logSaveDays);
        }
    }

    /**
     * 得到现在时间前的几天日期，用来得到需要删除的日志文件名
     */
    private static Date getDateBefore(int day) {
        Date nowtime = new Date();
        Calendar now = Calendar.getInstance();
        now.setTime(nowtime);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }


    private static boolean checkWritable() {
        // Create a temporary file to see whether a volume is really writeable.
        // It's important not to put it in the root directory which may have a
        // limit on the number of files.
        String directoryName = getLogPathSDCardDir();
        File directory = new File(directoryName);
        if (!directory.isDirectory()) {
            if (!directory.mkdirs()) {
                return false;
            }
        }
        if (!directory.canWrite()) {
            directory.setWritable(true);
        }
        return directory.canWrite();
    }

    /**
     * 写Log文件到本地
     */
    private static void writeLogtoFile(String level, String tag, String text, int logLevel) {
        writeLogtoFile(level, tag, text, null, logLevel);
    }

    private static void writeLogtoFile(String level, String tag, String text, Throwable throwable, int logLevel) {// 新建或打开日志文件
        if (logLevel < SAVE_LOG_LEVEL) {
            return;
        }
        if (!checkWritable()) {
            return;
        }
        if (mLogWriteNum++ > LOG_WRITE_NUMS && LOG_WRITE_NUMS != -1) {
            mLogWriteNum = 0;
            checkLogFile();
        }
        String needWriteMessage = "";
        long currentTime = System.currentTimeMillis();
        if (throwable != null) {
            needWriteMessage = dateFormatDetail.format(currentTime) + "    " + level
                    + "    " + tag + "    " + text + "    " + throwable.getMessage();
        } else {
            needWriteMessage = dateFormatDetail.format(currentTime) + "    " + level
                    + "    " + tag + "    " + text;
        }

        String needWriteFiel = dateFormat.format(currentTime);
        try {
            String x = LOGFILE_TAGNAME;
            if (LOG_LEVEL_XC == logLevel) {
                x = LOGFILE_TAGNAME_CRASH;
            }
            File file = new File(getLogPathSDCardDir(), needWriteFiel + x);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter filerWriter = new FileWriter(file, true);//后面这个参数代表是不是要接上文件中原来的数据，不进行覆盖
            BufferedWriter bufWriter = new BufferedWriter(filerWriter);
            bufWriter.write(needWriteMessage);
            bufWriter.newLine();
            bufWriter.close();
            filerWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
