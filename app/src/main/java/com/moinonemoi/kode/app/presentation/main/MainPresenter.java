package com.moinonemoi.kode.app.presentation.main;

import com.moinonemoi.kode.app.data.entity.Item;
import com.moinonemoi.kode.app.data.repository.WorkerListRepositoryImpl;
import com.moinonemoi.kode.app.domain.GetCategoryListUseCase;
import com.moinonemoi.kode.app.domain.GetWorkerListUseCase;
import com.moinonemoi.kode.app.domain.WorkerListRepository;
import com.moinonemoi.kode.app.presentation.main.entity.MainFragmentView;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainPresenter {


    private WorkerListRepository workerListRepository = new WorkerListRepositoryImpl();

    private GetCategoryListUseCase getCategoryListUseCase = new GetCategoryListUseCase(workerListRepository);


    private MainFragmentView mainFragmentView;



    public void getCategoryList() {
        Disposable disposable = getCategoryListUseCase.execute().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<String>>() {
                    @Override
                    public void accept(List<String> categoryList) throws Throwable {

                    }
                });
    }

}
