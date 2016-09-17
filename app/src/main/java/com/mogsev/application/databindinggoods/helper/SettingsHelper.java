package com.mogsev.application.databindinggoods.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SettingsHelper {
    private static final String TAG = "SettingsHelper";
    private static final String ID = "id";

    private static SettingsHelper mInstance = null;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public static void initInstance(Context context) {
        mInstance = new SettingsHelper(context);
    }

    public static synchronized SettingsHelper getInstance() {
        return mInstance;
    }

    private SettingsHelper(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        mEditor = mSharedPreferences.edit();
    }

    public void saveID(int id) {
        mEditor.putInt(ID, id);
        mEditor.apply();
    }

    public int getID() {
        return mSharedPreferences.getInt(ID, 0);
    }
}
