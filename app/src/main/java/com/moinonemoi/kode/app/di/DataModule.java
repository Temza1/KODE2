package com.moinonemoi.kode.app.di;

import com.moinonemoi.kode.app.data.api.ApiService;
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
