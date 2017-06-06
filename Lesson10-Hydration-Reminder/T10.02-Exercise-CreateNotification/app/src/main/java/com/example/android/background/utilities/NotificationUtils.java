package com.example.android.background.utilities;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Vibrator;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

import com.example.android.background.MainActivity;
import com.example.android.background.R;

/**
 * Utility class for creating hydration notifications
 */
public class NotificationUtils {


    public static void remindUserBecauseCharging(Context context){
        int UNIQUE_WATER_ID = 69;
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setColor(ContextCompat.getColor(context,R.color.colorPrimary))
                .setSmallIcon(R.drawable.ic_drink_notification)
                .setLargeIcon(LargeIcon(context))
                .setContentTitle(context.getString(R.string.charging_reminder_notification_title))
                .setContentInfo(context.getString(R.string.charging_reminder_notification_body))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(context.getString(R.string.charging_reminder_notification_body)))
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(contentIntent(context))
                .setAutoCancel(true);
        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN){
            notificationBuilder.setPriority(Notification.PRIORITY_HIGH);
        }

        NotificationManager notificationMan = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationMan.notify(UNIQUE_WATER_ID,notificationBuilder.build());
    }
    // to take a look at this guide to see an example of what the code in this method will look like:
    // https://developer.android.com/training/notify-user/build-notification.html





    private static PendingIntent contentIntent(Context context) {
        int Int_Id = 12;
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendintent;
        pendintent = PendingIntent.getActivity(context, Int_Id, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return pendintent;
    }

    private static Bitmap LargeIcon(Context context){
        Resources resd = context.getResources();
        return BitmapFactory.decodeResource(resd, R.drawable.ic_local_drink_black_24px);
    }


}
