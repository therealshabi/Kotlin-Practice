package technolifestyle.com.kotlinPractice.twoPaneLayout


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_settings_options_view.view.*
import technolifestyle.com.kotlinPractice.R


class SettingOptionsFragment : Fragment() {

    private lateinit var mCallBack: OnOptionClickListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(
                R.layout.fragment_settings_options_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mNetworkOption = view.networkOption as LinearLayout
        val mDisplayOption = view.displayOption as LinearLayout
        val mStorageOption = view.storageOption as LinearLayout

        mNetworkOption.setOnClickListener {
            mCallBack.onOptionSelected(getString(R.string.network))
        }

        mDisplayOption.setOnClickListener {
            mCallBack.onOptionSelected(getString(R.string.display))
        }

        mStorageOption.setOnClickListener {
            mCallBack.onOptionSelected(getString(R.string.storage))
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            mCallBack = context as OnOptionClickListener
        } catch (e: Exception) {
            throw ClassCastException(context.toString() +
                    getString(R.string.class_cast_exception_settings_option))
        }
    }

    interface OnOptionClickListener {
        fun onOptionSelected(option: String)
    }
}
