package com.moinonemoi.kode.app.di;


import com.moinonemoi.kode.app.presentation.page.PageFragmentPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    public PageFragmentPresenter providePresenter() {
        return new PageFragmentPresenter();
    }


}
