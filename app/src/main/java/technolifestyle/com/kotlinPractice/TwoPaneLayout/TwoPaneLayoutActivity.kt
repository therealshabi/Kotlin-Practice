package technolifestyle.com.kotlinPractice.TwoPaneLayout

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import technolifestyle.com.kotlinPractice.R

class TwoPaneLayoutActivity : AppCompatActivity(), SettingOptionsFragment.OnOptionClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_pane_layout)

        val fragmentManager = supportFragmentManager

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction().add(R.id.container, SettingOptionsFragment()).commit()
        }
    }

    override fun onOptionSelected(option: String) {
        val intent = Intent(this, SettingsDetailActivity::class.java)
        intent.putExtra(SettingsDetailActivity.EXTRA_SETTING_OPTION, option)
        startActivity(intent)
    }
}
