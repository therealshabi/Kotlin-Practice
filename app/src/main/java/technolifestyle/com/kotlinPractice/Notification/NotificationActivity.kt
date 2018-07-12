package technolifestyle.com.kotlinPractice.Notification

import android.app.Notification
import android.app.NotificationManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_notification.*
import technolifestyle.com.kotlinPractice.R


class NotificationActivity : AppCompatActivity() {

    private lateinit var mNotificationManager: NotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        NotificationUtil.createNotificationChannel(mNotificationManager)

        initializeViews()
    }

    private fun initializeViews() {

        var notification: Notification

        simpleNotificationBtn.setOnClickListener {
            notification = NotificationUtil.createSimpleNotification(
                    this, "Simple Notification", "I am a boring notification")
            mNotificationManager.notify(NotificationUtil.SIMPLE_NOTIFICATION_ID, notification)
        }

        intentNotificationBtn.setOnClickListener {
            notification = NotificationUtil.createNotificationWithIntent(
                    this, "Notification with Intent",
                    "Close the app and click me")
            mNotificationManager.notify(NotificationUtil.NOTIFICATION_WITH_INTENT_ID, notification)
        }

        bigTextNotificationBtn.setOnClickListener {
            notification = NotificationUtil.createBigTextStyleNotification(
                    this, "Big Text Style Notification",
                    "I am the content text of a smaller notification.",
                    """I am the content of a Big Notification."
                            There are some lines that don't mean anything,
                            but I had to put them here.""")

            mNotificationManager.notify(
                    NotificationUtil.BIG_TEXT_STYLE_NOTIFICATION_ID, notification)
        }

        inboxStyleNotificationBtn.setOnClickListener {
            notification = NotificationUtil.createInboxStyleNotification(
                    this, "Inbox Style Notification",
                    "This is an inbox style Notification!!",
                    "I am line 1",
                    "I am line 2",
                    "I am line 3",
                    "I am line 4",
                    "I am line 5",
                    "I am line 6")

            mNotificationManager.notify(
                    NotificationUtil.INBOX_STYLE_NOTIFICATION_ID, notification)
        }

        bigPictureStyleNotificationBtn.setOnClickListener {
            notification = NotificationUtil.createBigPictureStyleNotification(
                    this,
                    "Big Picture Notification",
                    "You are going to see a big picture",
                    R.drawable.ic_gaming,
                    R.drawable.ic_gaming
            )
            mNotificationManager.notify(NotificationUtil.BIG_PICTURE_STYLE_NOTIFICATION_ID, notification)
        }

        messagingStyleNotificationBtn.setOnClickListener {
            notification = NotificationUtil.createMessagingStyleNotification(
                    this,
                    "Big Picture Notification",
                    "You are going to see a big picture"
            )
            mNotificationManager.notify(NotificationUtil.MESSAGING_STYLE_NOTIFICATION_ID, notification);
        }
    }
}
