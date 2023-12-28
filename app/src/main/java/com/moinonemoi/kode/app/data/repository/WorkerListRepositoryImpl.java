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
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class WorkerListRepositoryImpl implements WorkerListRepository {

    public static final String LOG_REPOSITORY_IMPL = "WorkerListRepositoryImpl";
    private ApiService apiService = ApiFactory.apiService;

    private List<Item> users;

    public void setUsers(List<Item> users) {
        this.users = users;
    }

    public List<Item> getUsers() {
        return users;
    }

    private String name = "категория";


    @Override
    public Observable<List<Item>> getWorkerList() {
        return apiService.loadUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<UserResponce, List<Item>>() {
                    @Override
                    public List<Item> apply(UserResponce userResponce) throws Throwable {
                        setUsers(userResponce.getItems());
                        return userResponce.getItems();
                    }
                }).doOnError(new Consumer<Throwable>() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.e(LOG_REPOSITORY_IMPL,throwable.toString());
                    }
                });
    }



    public Observable<List<String>> getCategoryList() {
        Observable<List<Item>> list = Observable.just(getUsers());
        return list.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<List<Item>, List<String>>() {
                    @SuppressLint("LongLogTag")
                    @Override
                    public List<String> apply(List<Item> items) throws Throwable {
                        List<String> category = new ArrayList<>();
                        if(items != null) {
                            for (Item item : items) {
                                String departament = item.getDepartment();
                                if(!category.contains(departament) && category.size() < 12) {
                                    category.add(departament);
                                } else {
                                    return category;
                                }
                            }
                        } else {
                            Log.d(LOG_REPOSITORY_IMPL,"list of users is empty");
                        }
                        return category;
                    }
                });
    }


}
