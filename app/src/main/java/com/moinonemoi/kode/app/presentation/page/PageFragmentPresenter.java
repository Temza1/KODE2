package com.moinonemoi.kode.app.presentation.page;



import android.util.Log;

import com.moinonemoi.kode.app.data.entity.Item;
import com.moinonemoi.kode.app.data.repository.WorkerListRepositoryImpl;
import com.moinonemoi.kode.app.domain.GetWorkerListUseCase;
import com.moinonemoi.kode.app.domain.WorkerListRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PageFragmentPresenter {

    public static final String LOG_PAGE_FRAGMENT_PRESENTER = "PageFragmentPresenter";

    private WorkerListRepository workerListRepository = new WorkerListRepositoryImpl();

    private GetWorkerListUseCase getWorkerListUseCase = new GetWorkerListUseCase(workerListRepository);



    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private FragmentView fragmentView;

    private Boolean secondStartMethod = false;
    public void attachView(FragmentView fragmentView) {
        this.fragmentView = fragmentView;
    }


    public void getWorkerList() {
        Disposable disposable = getWorkerListUseCase.execute().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Item>>() {
                    @Override
                    public void accept(List<Item> items) throws Throwable {

                        fragmentView.showResult(items);
                        showLogList(items);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.d(LOG_PAGE_FRAGMENT_PRESENTER,throwable.toString());
                    }
                });


    }



    /*public void loadUsers() {
        Disposable disposable = apiService.loadUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Item>>() {
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
    }*/


    private void showLogList(List<Item> list) {
        for (Item user : list) {
            Log.d(LOG_PAGE_FRAGMENT_PRESENTER,user.getAvatarUrl());
        }
    }



}
