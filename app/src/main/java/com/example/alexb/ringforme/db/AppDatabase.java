package com.example.alexb.ringforme.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.alexb.ringforme.db.dao.UserDAO;
import com.example.alexb.ringforme.db.entity.User;

/**
 * Created by alexb on 8/30/2017.
 */

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    /** Singleton instance. */
    private static AppDatabase INSTANCE;

    /**DAO Object accessor for User objects. */
    public abstract UserDAO userModel();

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context, AppDatabase.class, "usersdb")
                    //Room.inMemmoryDatabaseBuilder(context.getApplicationContext()),
                    //AppDatabase.class)
            //.allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    /**
     * Deconstructor
     */
    public static void destroyInstance() {
        INSTANCE = null;
    }
}
