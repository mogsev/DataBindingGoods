package com.mogsev.application.databindinggoods;

import android.app.Application;
import android.util.Log;

import com.mogsev.application.databindinggoods.helper.SettingsHelper;

public class MainApplication extends Application {
    private static final String TAG = "MainApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
        SettingsHelper.initInstance(this);
    }
}
