package com.moinonemoi.kode.app.domain;

import android.database.Observable;

import com.moinonemoi.kode.app.data.entity.Item;

import java.util.List;

public interface WorkerListRepository {

    public Observable<List<Item>> getWorkerList();


}
