package com.moinonemoi.kode.app.domain;


import com.moinonemoi.kode.app.data.entity.Item;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface WorkerListRepository {

    public Observable<List<Item>> getWorkerList();

    ///TODO:добавить метод,который возвращает список категорий?


}
