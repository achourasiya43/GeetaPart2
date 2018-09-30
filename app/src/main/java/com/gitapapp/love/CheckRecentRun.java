package com.gitapapp.love;


import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class CheckRecentRun extends Service {

    private static long delay = 86400000L;
    private String message = "Have a nice day ! Do read, share, discuss and apply a Verse today.";

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferences settings = getSharedPreferences(IndexActivity.PREFS, MODE_PRIVATE);

        if (settings.getBoolean("enabled", true)) {
            if (settings.getLong("lastRunTime", Long.MAX_VALUE) < System.currentTimeMillis() - delay)
                sendNotification();
        }

        setAlarm();
        stopSelf();
    }

    public void setAlarm() {

        Intent serviceIntent = new Intent(this, CheckRecentRun.class);
        PendingIntent pi = PendingIntent.getService(this, 131313, serviceIntent,
                PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + delay, pi);
    }

    public void sendNotification() {

        Intent mainIntent = new Intent(this, IndexActivity.class);
        @SuppressWarnings("deprecation")
        Notification noti = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setContentIntent(PendingIntent.getActivity(this, 131314, mainIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT))
                .setContentTitle(getResources().getString(R.string.app_name))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                .setContentText(message)
                .setDefaults(Notification.DEFAULT_ALL)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker(message)
                .setWhen(System.currentTimeMillis())
                .getNotification();


        NotificationManager notificationManager
                = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(131315, noti);
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}