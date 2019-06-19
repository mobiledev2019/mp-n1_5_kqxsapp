package com.example.kqsx2.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * This is singleton class for SharedPreferences.
 * Where you can create multiple methods for different-different data.
 */
public class AppSharedPref {


    /**
     * PREFS_NAME is a file name which generates inside data folder of application
     */
    private static final String PREFS_NAME = "share_prefs";

    static SharedPreferences sp;
    static SharedPreferences.Editor prefEditor = null;

    private static Context mContext = null;
    public static AppSharedPref instance = null;

    public static AppSharedPref getInstance(Context context) {
        mContext = context;
        if (instance == null) {
            instance = new AppSharedPref();
        }
        sp = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        prefEditor = sp.edit();
        return instance;
    }

    public void setName(String key, String value) {
        prefEditor.putString(key, value);
        prefEditor.apply();
    }


    public String getName(String key)
    {
        // if name key available then it will returned value of name otherwise returned empty string.
        return sp.getString(key, "");
    }

    public void clearData() {
        prefEditor.clear();
        prefEditor.commit();
    }
}
