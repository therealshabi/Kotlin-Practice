package technolifestyle.com.kotlinPractice.TwoPaneLayout.TwoPaneFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import technolifestyle.com.kotlinPractice.R

class NetworkSettingsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_network_settings, container, false)
    }


}
