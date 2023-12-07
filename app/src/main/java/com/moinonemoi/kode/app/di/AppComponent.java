package com.moinonemoi.kode.app.di;

import com.moinonemoi.kode.app.presentation.FirstFragment;
import com.moinonemoi.kode.app.presentation.SecondaryFragment;

import dagger.Component;

@Component(modules = {AppModule.class, DataModule.class, DomainModule.class})
public interface AppComponent {

    void inject(SecondaryFragment fragment);
    void inject(FirstFragment fragment);
}
