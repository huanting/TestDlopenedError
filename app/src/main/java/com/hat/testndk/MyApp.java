package com.hat.testndk;

import android.app.Application;

import com.facebook.soloader.SoLoader;
import com.netease.nis.bugrpt.CrashHandler;

import java.io.IOException;

//import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by huanting on 2017/7/7.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        CrashReport.initCrashReport(this);
        CrashHandler.init(this);
        try {
            SoLoader.init(this, 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
