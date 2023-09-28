package com.moinonemoi.kode.app.di;

import com.moinonemoi.kode.app.presentation.presentation.FirstFragmentPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private FirstFragmentPresenter presenter;

    public FirstFragmentPresenter providePresenter() {
        return presenter;
    }
}
