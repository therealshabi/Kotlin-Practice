package technolifestyle.com.kotlinPractice.twoPaneLayout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_two_pane_layout.*
import technolifestyle.com.kotlinPractice.R
import technolifestyle.com.kotlinPractice.twoPaneLayout.twoPaneFragments.DisplaySettingsFragment
import technolifestyle.com.kotlinPractice.twoPaneLayout.twoPaneFragments.NetworkSettingsFragment
import technolifestyle.com.kotlinPractice.twoPaneLayout.twoPaneFragments.StorageSettingsFragment


class TwoPaneLayoutActivity : AppCompatActivity(), SettingOptionsFragment.OnOptionClickListener {

    private var isTwoPane: Boolean = false
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_pane_layout)

        fragmentManager = supportFragmentManager

        isTwoPane = detailContainer!=null

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.container, SettingOptionsFragment()).commit()
        }
    }

    override fun onOptionSelected(option: String) {
        if (isTwoPane) {
            when (option) {
                getString(R.string.network) -> {
                    fragmentManager.beginTransaction()
                            .replace(R.id.detailContainer, NetworkSettingsFragment())
                            .commit()
                }
                getString(R.string.display) -> {
                    fragmentManager.beginTransaction()
                            .replace(R.id.detailContainer, DisplaySettingsFragment())
                            .commit()
                }
                getString(R.string.storage) -> {
                    fragmentManager.beginTransaction()
                            .replace(R.id.detailContainer, StorageSettingsFragment())
                            .commit()
                }
            }
        } else {
            val intent = Intent(this, SettingsDetailActivity::class.java)
            intent.putExtra(SettingsDetailActivity.EXTRA_SETTING_OPTION, option)
            startActivity(intent)
        }
    }
}
