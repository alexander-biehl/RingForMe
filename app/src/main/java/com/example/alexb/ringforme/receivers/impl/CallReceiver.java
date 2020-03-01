package com.example.alexb.ringforme.receivers.impl;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.alexb.ringforme.receivers.PhonecallReceiver;
import com.example.alexb.ringforme.service.PhoneCallReceivedIntentService;
import com.example.alexb.ringforme.util.AudioUtil;

import java.util.Date;

/**
 * Created by alexb on 8/16/2017.
 */

public class CallReceiver extends PhonecallReceiver {

    private static final String TAG = "CallReceiver";//this.getClass().getSimpleName();

    @Override
    public void onIncomingCallReceived(Context context, String number, Date start) {
        Log.i(TAG, "OnIncoming number: " + number);
        //check database of designated contacts
        //check number against contact
        //do designated function. i.e. turn volume up/down
        PhoneCallReceivedIntentService.startVolIncrease(context, number);
    }

    @Override
    public void onIncomingCallEnded(Context context, String number, Date start, Date ended) {

    }

    @Override
    public void onIncomingCallAnswered(Context context, String number, Date start) {

    }

    @Override
    public void onOutgoingCallEnded(Context context, String number, Date start, Date ended) {

    }

    @Override
    public void onOutgoingCallStarted(Context context, String number, Date start) {

    }

    @Override
    public void onMissedCall(Context context, String number, Date start) {

    }
}
