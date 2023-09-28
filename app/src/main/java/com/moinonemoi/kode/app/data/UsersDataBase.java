package com.moinonemoi.kode.app.data;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Item.class}, version = 1, exportSchema = false)
public abstract class UsersDataBase extends RoomDatabase {

    private static UsersDataBase instance = null;
    public static final String DB_NAME = "users.db";

    public static UsersDataBase getInstance(Application application) {
        if(instance == null) {
            instance = Room.databaseBuilder(
                    application,
                    UsersDataBase.class,
                    DB_NAME
            ).build();
            }
        return instance;
        }

        public abstract UsersDao usersDao();
    }
