package com.moinonemoi.kode.app.di;

import static com.moinonemoi.kode.app.data.UsersDataBase.DB_NAME;

import androidx.room.Room;

import com.moinonemoi.kode.app.data.UsersDataBase;

import dagger.Module;

@Module
public class DataModule {

    /*private static UsersDataBase instance = null;

    public UsersDataBase provideDB() {
        if(instance == null) {
            instance = Room.databaseBuilder(
                    application,
                    UsersDataBase.class,
                    DB_NAME
            ).build();
        }
        return instance;
    }*/
}
