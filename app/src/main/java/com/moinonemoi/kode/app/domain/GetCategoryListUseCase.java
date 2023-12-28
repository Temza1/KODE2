package com.moinonemoi.kode.app.domain;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public class GetCategoryListUseCase {

    private WorkerListRepository workerListRepository;

    public GetCategoryListUseCase(WorkerListRepository workerListRepository) {
        this.workerListRepository = workerListRepository;
    }

    public Observable<List<String>> execute() {
        return workerListRepository.getCategoryList();
    }
}
