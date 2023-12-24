package com.moinonemoi.kode.app.data.repository;


import android.annotation.SuppressLint;
import android.util.Log;

import com.moinonemoi.kode.app.data.api.ApiFactory;
import com.moinonemoi.kode.app.data.api.ApiService;
import com.moinonemoi.kode.app.data.entity.Item;
import com.moinonemoi.kode.app.data.entity.UserResponce;
import com.moinonemoi.kode.app.domain.WorkerListRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WorkerListRepositoryImpl implements WorkerListRepository {

    public static final String LOG_WORKER_REPOSITORY_IMPL = "WorkerListRepositoryImpl";
    private ApiService apiService = ApiFactory.apiService;


    private String name = "категория";


    @Override
    public Observable<List<Item>> getWorkerList() {
        return apiService.loadUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<UserResponce, List<Item>>() {
                    @Override
                    public List<Item> apply(UserResponce userResponce) throws Throwable {
                        return userResponce.getItems();
                    }
                });
    }







}
