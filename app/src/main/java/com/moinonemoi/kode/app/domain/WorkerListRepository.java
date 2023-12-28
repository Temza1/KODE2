package com.moinonemoi.kode.app.domain;


import com.moinonemoi.kode.app.data.entity.Item;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

public interface WorkerListRepository {

    Observable<List<Item>> getWorkerList();

    Observable<List<String>> getCategoryList();


    ///TODO:добавить метод,который возвращает список категорий?


}
