package com.example.whatsapprecovery;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.os.Bundle;
import android.util.Log;

public class NotificationService extends NotificationListenerService {

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        String packageName = sbn.getPackageName();
        if (packageName.equals("com.whatsapp") || packageName.equals("com.whatsapp.w4b")) {
            Bundle extras = sbn.getNotification().extras;
            String title = extras.getString("android.title");
            CharSequence text = extras.getCharSequence("android.text");

            if (title != null && text != null) {
                Log.d("WhatsAppRecovery", "Sender: " + title + " Message: " + text.toString());
            }
        }
    }

    @Override
    public void onNotificationRemoved(StatusBarNotification sbn) {
        // Notification removed
    }
}
