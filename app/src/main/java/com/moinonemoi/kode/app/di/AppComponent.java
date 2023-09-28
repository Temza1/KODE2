package com.moinonemoi.kode.app.di;

import com.moinonemoi.kode.app.presentation.presentation.FirstFragment;

import dagger.Component;

@Component(modules = {AppModule.class, DataModule.class, DomainModule.class})
public interface AppComponent {

    public void inject(FirstFragment fragment);
}
