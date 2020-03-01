package com.example.alexb.ringforme.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import com.example.alexb.ringforme.db.AppDatabase;
import com.example.alexb.ringforme.db.entity.User;
import com.example.alexb.ringforme.util.AudioUtil;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class PhoneCallReceivedIntentService extends IntentService {

    private  final String TAG = this.getClass().getSimpleName();

    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String VOL_UP = "com.example.alexb.ringforme.service.action.INC_VOL";


    private static final String EXTRA_NUM = "com.example.alexb.ringforme.service.extra.NUMBER";

    public PhoneCallReceivedIntentService() {
        super("PhoneCallReceivedIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startVolIncrease(Context context, String param1) {
        Intent intent = new Intent(context, PhoneCallReceivedIntentService.class);
        intent.setAction(VOL_UP);
        intent.putExtra(EXTRA_NUM, param1);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (VOL_UP.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_NUM);
                handleActionFoo(intent, param1);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(Intent intent, String param1) {

        Context context = getApplicationContext();
        AppDatabase db = AppDatabase.getDatabase(context);
        Log.d(TAG, "Querying db for number: " + param1);
        User user = db.userModel().getUserByNumber(param1);
        if (user != null) {
            Log.d(TAG, "Found User, start AudioUtil");
            AudioUtil.setVolume(context);
        } else {
            Log.d(TAG, "No User Found");
        }
    }
}
