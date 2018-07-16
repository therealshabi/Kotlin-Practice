package technolifestyle.com.kotlinPractice.Notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.support.v4.content.ContextCompat
import android.support.v4.graphics.drawable.DrawableCompat
import java.util.*


class NotificationUtil {

    companion object {
        private const val DEFAULT_CHANNEL_ID: String = "default_channel"
        private const val DEFAULT_CHANNEL_NAME = "default"
        var SIMPLE_NOTIFICATION_ID = 1
        var NOTIFICATION_WITH_INTENT_ID = 2
        var BIG_TEXT_STYLE_NOTIFICATION_ID = 3
        var INBOX_STYLE_NOTIFICATION_ID = 4
        var BIG_PICTURE_STYLE_NOTIFICATION_ID = 5
        var MESSAGING_STYLE_NOTIFICATION_ID = 6

        fun createNotificationChannel(notificationManager: NotificationManager) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                if (notificationManager.getNotificationChannel(DEFAULT_CHANNEL_ID) == null) {
                    notificationManager.createNotificationChannel(NotificationChannel(
                            DEFAULT_CHANNEL_ID, DEFAULT_CHANNEL_NAME,
                            NotificationManager.IMPORTANCE_DEFAULT))
                }
            }
        }

        fun createSimpleNotification(context: Context, title: String, text: String): Notification {
            val builder = NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setSmallIcon(android.R.drawable.ic_menu_view)
                    .setVibrate(longArrayOf(250, 250, 250, 250))

            return builder.build()
        }

        fun createNotificationWithIntent(
                context: Context, title: String, text: String): Notification {

            val intent = Intent(context, NotificationActivity::class.java)

            val pendingIntent: PendingIntent = PendingIntent.getActivity(
                    context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            val builder = NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setSmallIcon(android.R.drawable.ic_menu_send)
                    .setAutoCancel(true)
                    .setContentIntent(pendingIntent)

            return builder.build()
        }

        fun createBigTextStyleNotification(
                context: Context, title: String, text: String, bigText: String): Notification {
            val style = NotificationCompat.BigTextStyle()
            style.bigText(bigText)
            style.setBigContentTitle(title)
            style.setSummaryText(text)

            val builder = NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setSmallIcon(android.R.drawable.ic_menu_view)
                    .setStyle(style)

            return builder.build()
        }

        fun createInboxStyleNotification(
                context: Context, title: String, text: String, vararg lines: String): Notification {

            val style = NotificationCompat.InboxStyle()
            style.setSummaryText(text)
            style.setBigContentTitle("Big Content title - $title")
            lines.forEach { style.addLine(it) }

            val builder = NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setSmallIcon(android.R.drawable.ic_menu_view)
                    .setStyle(style)

            return builder.build()
        }

        fun createBigPictureStyleNotification(
                context: Context, title: String, text: String,
                bigPictureRes: Int, largeIcon: Int): Notification {


            val style = NotificationCompat.BigPictureStyle()
            style.setSummaryText(text)
            style.setBigContentTitle(title)
            style.bigPicture(getBitmapFromVectorDrawable(context, bigPictureRes))
            style.bigLargeIcon(getBitmapFromVectorDrawable(context, largeIcon))

            val builder = NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setSmallIcon(android.R.drawable.ic_menu_view)
                    .setStyle(style)

            return builder.build()
        }

        fun createMessagingStyleNotification(
                context: Context, title: String, text: String): Notification {

/*            val user: Person = Person.Builder().setName("Shahbaz Hussain").build()
            val style = NotificationCompat.MessagingStyle(user)
                    .addMessage("Testing", Date().time, user)
                    .addMessage("Testing 123", Date().time, user)

            val builder = NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setSmallIcon(android.R.drawable.ic_menu_view)
                    .setStyle(style)

            return builder.build()*/

            val style = NotificationCompat.MessagingStyle("Shahbaz Hussain");
            style.addMessage(NotificationCompat.MessagingStyle.Message("Testing", Date().time, "Shahbaz Hussain"))
            style.addMessage(NotificationCompat.MessagingStyle.Message("Testing 123", Date().time, "Shabi"))

            val builder = NotificationCompat.Builder(context, DEFAULT_CHANNEL_ID)
                    .setContentTitle(title)
                    .setContentText(text)
                    .setSmallIcon(android.R.drawable.ic_menu_send)
                    .setStyle(style)   //Set the notification style

            return builder.build()
        }

        private fun getBitmapFromVectorDrawable(context: Context, drawableId: Int): Bitmap {
            var drawable = ContextCompat.getDrawable(context, drawableId)
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                drawable = DrawableCompat.wrap(drawable!!).mutate()
            }

            val bitmap = Bitmap.createBitmap(drawable!!.intrinsicWidth,
                    drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)
            return bitmap
        }

    }

}
