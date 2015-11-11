package com.example.rahul.eventreceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by RAHUL on 2/22/2015.
 */
public class EventReceiver extends BroadcastReceiver
{

    private static final String MyString="MainActivity:EventReceiver";
    private NotificationManager myNotification;
    public static final int NOTI_ID=1;

    public EventReceiver(){}
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        {

            Toast.makeText(context,"Airplane Mode",Toast.LENGTH_LONG).show();
            //Log.d(MyString,"Charging...");
            //sendNotification(context,"Date Manually Changed!");

            myNotification = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            //PendingIntent my_p_intent = PendingIntent.getActivity(context,0,new Intent(context,MainActivity.class),0);


            NotificationCompat.Builder my_Builder = new NotificationCompat.Builder(context)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setContentTitle(context.getString(R.string.message))
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText("Notification"))
                    .setContentText("Airplane Mode");

//            my_Builder.setContentIntent(my_p_intent);
            myNotification.notify(0,my_Builder.build());


        }

        else if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED))
        {

     //       Toast.makeText(context,"",Toast.LENGTH_LONG).show();
            //Log.d(MyString,"Charging...");
            //sendNotification(context,"Date Manually Changed!");

            myNotification = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            //PendingIntent my_p_intent = PendingIntent.getActivity(context,0,new Intent(context,MainActivity.class),0);


            NotificationCompat.Builder my_Builder = new NotificationCompat.Builder(context)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setContentTitle(context.getString(R.string.message))
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText("Notification"))
                    .setContentText("Power ON");

//            my_Builder.setContentIntent(my_p_intent);
            myNotification.notify(1,my_Builder.build());

        }
    }


/*
    private void sendNotification(Context context, String myString)
    {
        myNotification = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent my_p_intent = PendingIntent.getActivity(context,0,new Intent(context,MainActivity.class),0);


        NotificationCompat.Builder my_Builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(context.getString(R.string.message))
                .setStyle(new NotificationCompat.BigTextStyle()
                .bigText(myString))
                .setContentText(myString);

        my_Builder.setContentIntent(my_p_intent);
        myNotification.notify(NOTI_ID,my_Builder.build());
    }
*/

    private void sendNotification(Context context, String myString) {
//        myNotification = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
//        PendingIntent my_p_intent = PendingIntent.getActivity(context,0,new Intent(context,MainActivity.class),0);
//
//
//        NotificationCompat.Builder my_Builder = new NotificationCompat.Builder(context)
//                .setSmallIcon(R.drawable.ic_launcher)
//                .setContentTitle(context.getString(R.string.message))
//                .setStyle(new NotificationCompat.BigTextStyle()
//                        .bigText(myString))
//                .setContentText(myString);
//
//        my_Builder.setContentIntent(my_p_intent);
//        myNotification.notify(NOTI_ID,my_Builder.build());
    }
}
