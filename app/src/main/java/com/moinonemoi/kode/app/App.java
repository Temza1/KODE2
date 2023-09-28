package com.moinonemoi.kode.app;

import android.app.Application;

import com.moinonemoi.kode.app.di.AppComponent;

public class App extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
