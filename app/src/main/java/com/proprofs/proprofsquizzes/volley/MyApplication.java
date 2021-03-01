package com.proprofs.proprofsquizzes.volley;

import android.app.Application;
import android.content.Context;

/**
 * Created by Avanish Singh on 04/07/2016.
 */
public class MyApplication extends Application {

    private static MyApplication sInstance ;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
    public  static MyApplication getsInstance(){

        return sInstance;
    }
    public static Context getAppContext(){
        return sInstance.getApplicationContext();
    }
}
