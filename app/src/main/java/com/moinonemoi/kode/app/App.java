package com.moinonemoi.kode.app;

import android.app.Application;

import com.moinonemoi.kode.app.di.AppComponent;
import com.moinonemoi.kode.app.di.DaggerAppComponent;

public class App extends Application {

    static public AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }
}
