package com.moinonemoi.kode.app.base;

import android.app.Application;

import com.moinonemoi.kode.app.di.AppComponent;

public class App extends Application {

    static public AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        /*appComponent = DaggerAppComponent.create();*/
    }
}
