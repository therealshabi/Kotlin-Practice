package technolifestyle.com.kotlinPractice.twoPaneLayout.twoPaneFragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import technolifestyle.com.kotlinPractice.R

class NetworkSettingsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_network_settings, container, false)
    }


}
