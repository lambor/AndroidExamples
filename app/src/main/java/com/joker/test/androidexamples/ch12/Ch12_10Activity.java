package com.joker.test.androidexamples.ch12;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.joker.test.androidexamples.MainActivity;
import com.joker.test.androidexamples.R;

/**
 * Created by lambor on 17-3-10.
 *
 */

public class Ch12_10Activity extends AppCompatActivity implements View.OnClickListener {

    public static void start(Context context) {
        context.startActivity(new Intent(context,Ch12_10Activity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch12_10);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        findViewById(R.id.basic).setOnClickListener(this);
        findViewById(R.id.collapsed).setOnClickListener(this);
        findViewById(R.id.headsup).setOnClickListener(this);
        findViewById(R.id.visibility).setOnClickListener(this);

        vbTypesGroup = (RadioGroup) findViewById(R.id.visibilityType);
    }

    RadioGroup vbTypesGroup;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.basic:
                notifyBasic();
                break;
            case R.id.collapsed:
                notifyCollapsed();
                break;
            case R.id.headsup:
                notifyHeadsup();
                break;
            case R.id.visibility:
                int visibilityType = vbTypesGroup.getCheckedRadioButtonId();
                if(visibilityType == -1) {
                    Toast.makeText(this, "please select one visibility type", Toast.LENGTH_SHORT).show();
                } else {
                    notifyVisibility(visibilityType);
                }
                break;
        }
    }

    NotificationManager notificationManager;

    private void notifyBasic() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        builder.setContentTitle("Basic Notifications");
        builder.setContentText("I am a basic notification");
        builder.setSubText("it is really basic");

        notificationManager.notify(123,builder.build());
    }

    private void notifyCollapsed() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));

        RemoteViews contenView = new RemoteViews(getPackageName(),R.layout.layout_ch12_10_content);
        RemoteViews bigContentView = new RemoteViews(getPackageName(),R.layout.layout_ch12_10_expand);
        builder.setCustomContentView(contenView);
        builder.setCustomBigContentView(bigContentView);
        notificationManager.notify(456,builder.build());
    }

    private void notifyHeadsup() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setContentTitle("Headsup Notification")
                .setContentText("I am a Headsup notification");

        Intent push = new Intent();
        push.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        push.setClass(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,push,PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentText("Headsup Notification on Android 5.0").setFullScreenIntent(pendingIntent,true);

        notificationManager.notify(789,builder.build());
    }

    private void notifyVisibility(int typeid) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("Notification for Visibility Test")
                .setSmallIcon(R.mipmap.ic_launcher);
        if(typeid == R.id.typePublic) {
            builder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
            builder.setContentText("Public");

        } else if(typeid == R.id.typePrivate) {
            builder.setVisibility(NotificationCompat.VISIBILITY_PRIVATE);
            builder.setContentText("Private");
        } else if(typeid == R.id.typeSecret) {
            builder.setVisibility(NotificationCompat.VISIBILITY_SECRET);
            builder.setContentText("Secret");
        }
        notificationManager.notify(3509,builder.build());
    }
}
