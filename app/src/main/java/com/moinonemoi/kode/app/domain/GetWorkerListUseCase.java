package com.moinonemoi.kode.app.domain;

import android.database.Observable;

import com.moinonemoi.kode.app.data.Item;

import java.util.List;

public class GetWorkerListUseCase  {



    private WorkerListRepository workerListRepository;

    public GetWorkerListUseCase(WorkerListRepository workerListRepository) {
        this.workerListRepository = workerListRepository;
    }

    public Observable<List<Item>> execute(String type) {
        return workerListRepository.getWorkerList();
    }

    public Observable<List<Item>> execute(String type, String searchText) {
        return workerListRepository.getWorkerList();
    }

    //TODO:сортировка по дате рождения и алфавиту
}
