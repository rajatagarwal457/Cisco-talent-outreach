package ambulane.example.ambulane;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;

/**
 * Created by Ayush and Rajat on 17-11-2017.
 */

public class NotificationService extends Service {
    private static final String TAG = "Notification Service";

    public NotificationService() {}

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        main();
    }
    public void main()
    {
        View v = new View(this);
        sendNotification(v);
    }

    @SuppressWarnings("deprecated")
    protected void sendNotification(View view) {

        Log.d("token: ", "NotificationService");

        //PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        //PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.ON_AFTER_RELEASE , "TAG");

        //wl.acquire(1);
        //PowerManager.WakeLock wl_cpu = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK,"TAG_2");
        //wl_cpu.acquire(1);

        //define notification attributes
        int icon = R.mipmap.ic_launcher;
        Uri soundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        Intent intent = new Intent(this,MapsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        notificationBuilder.setContentTitle("AMBULANCE APPROACHING");
        notificationBuilder.setContentText("Please Give Way");
        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setSound(soundUri);
        notificationBuilder.setSmallIcon(icon);
        notificationBuilder.setLargeIcon(bm);
        notificationBuilder.setContentIntent(pendingIntent);
        notificationBuilder.setPriority(Notification.PRIORITY_MAX);
        notificationBuilder.setVibrate(new long[] {0,1000,1000,1000,1000});

        //build notification
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = notificationBuilder.build();
        notificationManager.notify(0,notificationBuilder.build());
        notification.defaults = Notification.DEFAULT_VIBRATE;
        notification.defaults = Notification.DEFAULT_SOUND;

        Log.d(TAG, "Notification");

    }
}
