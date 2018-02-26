package com.sample.niki.photosharing;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

/**
 * Created by Sekhar Madhiyazhagan on 2/26/2018.
 */

public class BaseApplication extends Application {

    private static BaseApplication instance = null;


    public static BaseApplication getInstance() {
        return instance;
    }
    /**
     * @return the ressources
     */
    public static Resources res() {
        return this.getResources() ;
    }
}
