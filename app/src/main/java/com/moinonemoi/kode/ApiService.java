package com.moinonemoi.kode;

import com.moinonemoi.kode.app.data.Item;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("users")
    Observable<List<Item>> loadUsers();


}
