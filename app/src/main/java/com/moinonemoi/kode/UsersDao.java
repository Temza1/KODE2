package com.moinonemoi.kode;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface UsersDao {

    @Query("SELECT * FROM users" )
    Observable<List<Item>> getUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable add(List<Item> users);

    /*@Query("SELECT * FROM users WHERE department = 'analytics'")
    Single<List<Item>> getDepAnalyst();*/

}
