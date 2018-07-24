package technolifestyle.com.kotlinPractice.TwoPaneLayout


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import technolifestyle.com.kotlinPractice.R


class SettingOptionsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(
                R.layout.fragment_settings_options_view, container, false)
    }
}
