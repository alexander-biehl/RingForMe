package com.example.alexb.ringforme.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

import com.example.alexb.ringforme.db.AppDatabase;
import com.example.alexb.ringforme.db.entity.User;

/**
 * Created by alexb on 9/26/2017.
 */

public class AddViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    public AddViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());
    }

    public void add(final User user) {
        new addAsyncTask(appDatabase).execute(user);
    }

    private static class addAsyncTask extends AsyncTask<User, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final User... params) {
            db.userModel().addUser(params[0]);
            return null;
        }
    }
}
