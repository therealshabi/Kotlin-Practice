package technolifestyle.com.kotlinPractice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var practiceTopics: MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        practiceTopics.add("Notifications Android")

        rvPractice.layoutManager = LinearLayoutManager(this)
        rvPractice.adapter = PracticeAdapter(this, practiceTopics)

    }
}
