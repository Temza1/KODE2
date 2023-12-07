package com.moinonemoi.kode.app.di;

import com.moinonemoi.kode.app.presentation.main.MainFragment;
import com.moinonemoi.kode.app.presentation.page.PageFragment;

import dagger.Component;

@Component(modules = {AppModule.class, DataModule.class, DomainModule.class})
public interface AppComponent {

    void inject(PageFragment fragment);
    void inject(MainFragment fragment);
}
