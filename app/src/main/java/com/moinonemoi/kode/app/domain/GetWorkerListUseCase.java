package com.moinonemoi.kode.app.domain;


import com.moinonemoi.kode.app.data.entity.Item;
import com.moinonemoi.kode.app.data.entity.UserResponce;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class GetWorkerListUseCase  {



    private WorkerListRepository workerListRepository;

    public GetWorkerListUseCase(WorkerListRepository workerListRepository) {
        this.workerListRepository = workerListRepository;
    }


    public Observable<List<Item>> execute() {
        return workerListRepository.getWorkerList();
    }

    public Observable<List<Item>> execute(String type) {
        return workerListRepository.getWorkerList();
    }

    public Observable<List<Item>> execute(String type, String searchText) {
        return workerListRepository.getWorkerList();
    }

    //TODO:сортировка по дате рождения и алфавиту
}
