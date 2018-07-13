package technolifestyle.com.kotlinPractice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import technolifestyle.com.kotlinPractice.Utils.StringUtils.Companion.BOTTOM_SHEET_ACTIVTY_TAG
import technolifestyle.com.kotlinPractice.Utils.StringUtils.Companion.NOTIFICATION_ACTIVITY_TAG


class MainActivity : AppCompatActivity() {

    private var practiceTopics: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        practiceTopics.add(NOTIFICATION_ACTIVITY_TAG)
        practiceTopics.add(BOTTOM_SHEET_ACTIVTY_TAG)

        rvPractice.layoutManager = LinearLayoutManager(this)
        rvPractice.adapter = PracticeAdapter(this, practiceTopics)

    }
}