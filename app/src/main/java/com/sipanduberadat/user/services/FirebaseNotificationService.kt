package com.sipanduberadat.user.services

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.sipanduberadat.user.R


class FirebaseNotificationService: FirebaseMessagingService() {

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)

        val soundUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        val notificationBuilder = NotificationCompat.Builder(this, "REPORT").apply {
            setSmallIcon(R.drawable.logo)
            setContentTitle("Notification")
            setContentText("You have new notification")
            setSound(soundUri)
            setVibrate(longArrayOf(300, 300, 300))
            priority = NotificationCompat.PRIORITY_HIGH
        }
        val notificationManager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel("REPORT", "REPORT",
                NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.vibrationPattern = longArrayOf(300, 300, 300)

            val att = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()
            notificationChannel.setSound(soundUri, att)

            notificationManager.createNotificationChannel(notificationChannel)
        }

        notificationManager.notify(0, notificationBuilder.build())
    }

    override fun onNewToken(p0: String) {
        super.onNewToken(p0)

        Log.e("TOKEN", p0)
    }

}