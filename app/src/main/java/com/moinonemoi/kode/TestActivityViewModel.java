package com.moinonemoi.kode;

import android.app.Application;
import android.app.Notification;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Database;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TestActivityViewModel extends ViewModel {

    private ApiService apiService;
    private CompositeDisposable compositeDisposable;
    private UsersDao usersDao;


    public MutableLiveData<List<Item>> items = new MutableLiveData<>();

    public MutableLiveData<List<Item>> getItem() {
        return items;
    }

    public TestActivityViewModel(@NonNull Application application) {
        usersDao = UsersDataBase.getInstance(application).usersDao();
    }


    public void loadUsers(ItemAdapter itemAdapter) {
        Disposable disposable = apiService.loadUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<Item>>() {
                    @Override
                    public void accept(List<Item> users) throws Throwable {
                        addDB(users,itemAdapter);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {

                    }
                });

        compositeDisposable.add(disposable);
    }

    public void addDB(List<Item> users,ItemAdapter itemAdapter) {
        Disposable disposable = usersDao.add(users).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Throwable {
                        itemAdapter.setUsers(users);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {

                    }
                });

        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
