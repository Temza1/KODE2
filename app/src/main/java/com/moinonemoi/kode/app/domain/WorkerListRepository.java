package com.moinonemoi.kode.app.domain;

import android.database.Observable;

import com.moinonemoi.kode.app.data.Item;

import java.util.List;

public interface WorkerListRepository {

    public Observable<List<Item>> getWorkerList();


}
