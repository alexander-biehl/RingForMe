package com.example.alexb.ringforme.util;

/**
 * Created by alexb on 8/16/2017.
 */

import android.content.Context;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;

/**
 * Utility class to handle changes to system volume
 */
public final class AudioUtil {

    private static final String TAG = "AudioUtil";//getClass().getSimpleName();

    //for now we will just set it to max until we figure out what parameters might be
    public static void setVolume(Context context) {

        AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        //TODO add this to the code, see if it solves the problem of volume not being
        //increased until afterwards
        //see: https://stackoverflow.com/questions/34093403/in-android-m-changing-the-ringer-mode-while-the-incoming-call-is-ringing-doesn

        /*
        Uri alertUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), alertUri);
if(r != null && !r.isPlaying()){
    r.play();
}
         */

        switch (am.getRingerMode()) {

            case AudioManager.RINGER_MODE_SILENT :

                am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                am.setStreamVolume(AudioManager.STREAM_RING,
                        am.getStreamMaxVolume(AudioManager.STREAM_RING),
                        0);

                Uri alertUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
                Ringtone r = RingtoneManager.getRingtone(context, alertUri);
                if(r != null && !r.isPlaying()){
                    r.play();
                }
                break;
            case AudioManager.RINGER_MODE_NORMAL :

                break;
            case AudioManager.RINGER_MODE_VIBRATE:

                am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                am.setStreamVolume(AudioManager.STREAM_RING,
                        am.getStreamMaxVolume(AudioManager.STREAM_RING),
                        0);
                break;
        }
    }
}
