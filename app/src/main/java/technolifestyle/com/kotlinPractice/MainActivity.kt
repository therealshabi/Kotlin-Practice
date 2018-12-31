package technolifestyle.com.kotlinPractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion.AUTO_IMAGE_SLIDER_ACTIVITY
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion.BOTTOM_SHEET_ACTIVITY_TAG
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion.BOTTOM_SHEET_FRAGMENT_ACTIVITY
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion.INWARD_NAVIGATION_LAYOUT_ACTIVITY
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion.LOCATION_ACTIVITY_TAG
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion.NOTIFICATION_ACTIVITY_TAG
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion.TWO_PANE_LAYOUT_ACTIVITY


class MainActivity : AppCompatActivity() {

    private var practiceTopics: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        practiceTopics.add(NOTIFICATION_ACTIVITY_TAG)
        practiceTopics.add(BOTTOM_SHEET_ACTIVITY_TAG)
        practiceTopics.add(BOTTOM_SHEET_FRAGMENT_ACTIVITY)
        practiceTopics.add(INWARD_NAVIGATION_LAYOUT_ACTIVITY)
        practiceTopics.add(TWO_PANE_LAYOUT_ACTIVITY)
        practiceTopics.add(LOCATION_ACTIVITY_TAG)
        practiceTopics.add(AUTO_IMAGE_SLIDER_ACTIVITY)

        rvPractice.layoutManager = LinearLayoutManager(this)
        rvPractice.adapter = PracticeAdapter(this, practiceTopics)

    }
}
