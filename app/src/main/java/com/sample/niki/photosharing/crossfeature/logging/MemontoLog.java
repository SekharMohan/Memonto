package com.sample.niki.photosharing.crossfeature.logging;

import android.util.Log;

import com.sample.niki.photosharing.BuildConfig;


/**
 * Created by Sekar Madhiyazhagan
 */
public class MemontoLog {
    /***********************************************************
     * Constants / Keys
     **********************************************************/
    private static final String TAG = "MemontoLog";

    /***********************************************************
     * Constructors
     **********************************************************/
    private MemontoLog() {
    }

    /***********************************************************
     * Business methods
     **********************************************************/
    public static int v(String message) {
        return MemontoLog.v(TAG, message);
    }

    public static int v(String tag, String message) {
        if (BuildConfig.DEBUG) {
            return Log.v(tag, message);
        } else {
            //do nothing
            return -1;
        }
    }

    public static int v(String tag, String message, Throwable throwable) {
        if (BuildConfig.DEBUG) {
            return Log.v(tag, message);
        } else {
            //do nothing
            return -1;
        }
    }

    public static int d(String message) {
        return MemontoLog.d(TAG, message);
    }

    public static int d(String tag, String message) {
        if (BuildConfig.DEBUG) {
            return Log.d(tag, message);
        } else {
            //do nothing
            return -1;
        }
    }

    public static int d(String tag, String message, Throwable throwable) {
        if (BuildConfig.DEBUG) {
            return Log.d(tag, message);
        } else {
            //do nothing
            return -1;
        }
    }

    public static int i(String message) {
        return MemontoLog.i(TAG, message);
    }

    public static int i(String tag, String message) {
        if (BuildConfig.DEBUG) {
            return Log.i(tag, message);
        } else {
            //do nothing
            return -1;
        }
    }

    public static int i(String tag, String message, Throwable throwable) {
        if (BuildConfig.DEBUG) {
            return Log.i(tag, message);
        } else {
            //do nothing
            return -1;
        }
    }

    public static int w(String message) {
        return MemontoLog.w(TAG, message);
    }

    public static int w(String tag, String message) {
        if (BuildConfig.DEBUG) {
            return Log.w(tag, message);
        } else {
            //do nothing
            return -1;
        }
    }

    public static int w(String tag, String message, Throwable throwable) {
        if (BuildConfig.DEBUG) {
            return Log.w(tag, message);
        } else {
            //do nothing
            return -1;
        }
    }

    public static int w(String tag, Throwable throwable) {
        if (BuildConfig.DEBUG) {
            return Log.w(tag, throwable);
        } else {
            //do nothing
            return -1;
        }
    }

    public static int e(String message) {
        return MemontoLog.e(TAG, message);
    }

    public static int e(String tag, String message) {
        if (BuildConfig.DEBUG) {
            return Log.e(tag, message);
        } else {
            //do nothing
            return -1;
        }
    }

    public static int e(String tag, String message, Throwable throwable) {
        if (BuildConfig.DEBUG) {
            return Log.e(tag, message);
        } else {
            //do nothing
            return -1;
        }
    }
}