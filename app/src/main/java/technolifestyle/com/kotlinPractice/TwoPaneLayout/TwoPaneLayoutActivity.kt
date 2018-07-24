package technolifestyle.com.kotlinPractice.TwoPaneLayout

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import technolifestyle.com.kotlinPractice.R

class TwoPaneLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_pane_layout)

        val fragmentManager = supportFragmentManager

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction().add(R.id.container, SettingOptionsFragment()).commit()
        }
    }
}
