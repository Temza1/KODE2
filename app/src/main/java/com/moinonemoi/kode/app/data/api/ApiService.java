package com.moinonemoi.kode.app.data.api;

import com.moinonemoi.kode.app.data.entity.UserResponce;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("users")
    Observable<UserResponce> loadUsers();


}
