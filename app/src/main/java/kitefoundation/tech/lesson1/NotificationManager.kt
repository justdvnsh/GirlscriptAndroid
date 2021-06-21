package kitefoundation.tech.lesson1

import android.app.NotificationChannel
import android.app.NotificationChannelGroup
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class NotifMan {
    companion object {

        const val channel: String = "Channel1234"
        const val NOTIFY_ID: Int = 100001

        fun raiseNotification(context: Context) {
            val mgr: NotificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            initGroup(mgr)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && mgr.getNotificationChannel(channel) == null) {
                val notifChannel = NotificationChannel(
                    channel,
                    "WHATEVER",
                    NotificationManager.IMPORTANCE_DEFAULT
                )

                notifChannel.group = "UPDATES"
                notifChannel.setShowBadge(true)
                mgr.createNotificationChannel(notifChannel)
            }

            val builder = NotificationCompat.Builder(context, channel)
            val intent = Intent(context, MainActivity::class.java)
            builder.apply {
                setAutoCancel(false)
                setContentTitle("TEST NOTIFICATION TITLE")
                setContentText("TEST NOTIFICATION TEXT WRITTEN HERE .....................")
                setSmallIcon(R.drawable.ic_launcher_foreground)
                setContentIntent(PendingIntent.getActivity(
                    context,
                    0,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT
                ))
            }

            mgr.notify(NOTIFY_ID, builder.build())
        }

        fun initGroup(mgr: NotificationManager) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                mgr.createNotificationChannelGroups(
                    listOf(
                        NotificationChannelGroup("UPDATES", "upadtes"),
                        NotificationChannelGroup("ADS", "ads")
                    )
                )
            }
        }
    }
}