package com.example.alexb.ringforme.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.alexb.ringforme.db.entity.User;

import java.util.List;

/**
 * Created by alexb on 8/30/2017.
 */

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(User user);

    @Query("select * from user")
     LiveData<List<User>> getAllUsers();

    @Query("select * from user where id = :id")
     LiveData<List<User>> getUser(long id);

    @Query("select * from user where phone = :phone")
    User getUserByNumber(String phone);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(User user);

    @Query("delete from user")
    void removeAllUsers();

    /*@Query("delete from user where id = :id")
    void removeUserById(long id);*/

    @Delete
    void deleteUser(User user);
}
