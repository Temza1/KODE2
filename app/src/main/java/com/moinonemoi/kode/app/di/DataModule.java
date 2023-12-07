package com.moinonemoi.kode.app.di;

import static com.moinonemoi.kode.app.data.UsersDataBase.DB_NAME;

import androidx.room.Room;

import com.moinonemoi.kode.app.data.ApiService;
import com.moinonemoi.kode.app.data.UsersDataBase;
import com.moinonemoi.kode.app.domain.GetWorkerListUseCase;
import com.moinonemoi.kode.app.domain.WorkerListRepository;

import dagger.Module;

@Module
public class DataModule {

    public GetWorkerListUseCase provideGetWorkerListUseCase(WorkerListRepository workerListRepository) {
        return new GetWorkerListUseCase(workerListRepository);
    }


    public WorkerListRepository provideWorkerListRepository() {
        return new WorkerListRepositoryImpl;
    }

    public ApiService provideApiService() {
        return ApiService;
    }

    public UsersDataBase provideUserDB() {
        return UsersDataBase.getInstance()
    }



}
