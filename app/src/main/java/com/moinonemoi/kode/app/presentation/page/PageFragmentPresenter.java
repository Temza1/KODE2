package com.moinonemoi.kode.app.presentation.page;

import android.app.Application;

import com.moinonemoi.kode.app.data.api.ApiFactory;
import com.moinonemoi.kode.app.data.api.ApiService;
import com.moinonemoi.kode.app.data.entity.Item;
import com.moinonemoi.kode.app.presentation.main.FragmentView;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PageFragmentPresenter implements FragmentPresenter {

    private ApiService apiService = ApiFactory.apiService;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private FragmentView fragmentView;
    private UsersDataBase userDB;

    public void attachView(FragmentView fragmentView) {
        this.fragmentView = fragmentView;
    }



    public void loadUsers() {
        Disposable disposable = apiService.loadUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Item>>() {
                    @Override
                    public void accept(List<Item> users) throws Throwable {
                        addDB(users);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {

                    }
                });

        compositeDisposable.add(disposable);
    }

    public void addDB(List<Item> users) {
        Disposable disposable = userDB.usersDao().add(users).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        fragmentView.showResult(users);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {

                    }
                });

        compositeDisposable.add(disposable);
    }

    public void initDB(Application application) {
        userDB = UsersDataBase.getInstance(application);
    }



}
