package technolifestyle.com.kotlinPractice.twoPaneLayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import technolifestyle.com.kotlinPractice.R
import technolifestyle.com.kotlinPractice.twoPaneLayout.twoPaneFragments.DisplaySettingsFragment
import technolifestyle.com.kotlinPractice.twoPaneLayout.twoPaneFragments.NetworkSettingsFragment
import technolifestyle.com.kotlinPractice.twoPaneLayout.twoPaneFragments.StorageSettingsFragment

class SettingsDetailActivity : AppCompatActivity() {

    companion object {
       const val EXTRA_SETTING_OPTION = "option"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_detail)

        val option: String? = intent.getStringExtra(EXTRA_SETTING_OPTION)
        val fragmentManager = supportFragmentManager

        if (option == null) {
            finish()
            return
        }

        when (option) {
            getString(R.string.network) -> fragmentManager.beginTransaction().add(
                    R.id.settingsContainer, NetworkSettingsFragment()).commit()
            getString(R.string.storage) -> fragmentManager.beginTransaction().add(
                    R.id.settingsContainer, StorageSettingsFragment()).commit()
            getString(R.string.display) -> fragmentManager.beginTransaction().add(
                    R.id.settingsContainer, DisplaySettingsFragment()).commit()
        }
    }
}
