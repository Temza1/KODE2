package com.moinonemoi.kode.app.di;


import com.moinonemoi.kode.app.presentation.FirstFragmentPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    public FirstFragmentPresenter providePresenter() {
        return new FirstFragmentPresenter();
    }
}
