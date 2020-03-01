package com.example.alexb.ringforme.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.alexb.ringforme.db.AppDatabase;
import com.example.alexb.ringforme.db.entity.User;

import java.util.List;

/**
 * Created by alexb on 9/1/2017.
 */

public class UserListViewModel extends AndroidViewModel {

    private final LiveData<List<User>> userList;

    private AppDatabase appDatabase;

    public UserListViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

        userList = appDatabase.userModel().getAllUsers();
    }

    public LiveData<List<User>> getUserList() {
        return userList;
    }

    public void deleteUser(User user) {
        new deleteAsyncTask(appDatabase).execute(user);
    }

    public void addUser(User user) {
        new addAsyncTask(appDatabase).execute(user);
    }

    private static class deleteAsyncTask extends AsyncTask<User, Void, Void> {

        private AppDatabase db;

        deleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final User...params) {
            db.userModel().deleteUser(params[0]);
            return null;
        }
    }

    private static class addAsyncTask extends AsyncTask<User, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final User...params) {
            db.userModel().addUser(params[0]);
            return null;
        }
    }
}
