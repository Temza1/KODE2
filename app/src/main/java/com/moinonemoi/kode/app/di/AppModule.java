package com.moinonemoi.kode.app.di;


import android.app.Application;

import androidx.fragment.app.Fragment;

import com.moinonemoi.kode.app.data.Item;
import com.moinonemoi.kode.app.presentation.FirstFragmentPresenter;
import com.moinonemoi.kode.app.presentation.FragmentView;

import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    public FirstFragmentPresenter providePresenter() {
        return new FirstFragmentPresenter();
    }


}
