package com.moinonemoi.kode.app.presentation.presentation;

import com.moinonemoi.kode.ApiService;
import com.moinonemoi.kode.app.data.Item;
import com.moinonemoi.kode.app.data.UsersDao;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FirstFragmentPresenter implements FragmentPresenter{

    private UsersDao usersDao;
    private ApiService apiService;
    private CompositeDisposable compositeDisposable;
    private FragmentView view;

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
        Disposable disposable = usersDao.add(users).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        view.showResult(users);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {

                    }
                });

        compositeDisposable.add(disposable);
    }



}
