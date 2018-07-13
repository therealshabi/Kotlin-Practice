package technolifestyle.com.kotlinPractice.BottomSheet

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bottom_sheet_fragment.*
import technolifestyle.com.kotlinPractice.R

class BottomSheetFragmentActivity : AppCompatActivity() {

    companion object {
        private const val TAG: String = "bottom_sheet"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet_fragment)

        showBottomSheetBtn.setOnClickListener{
            val fragment = BottomSheetFragment()
            fragment.show(supportFragmentManager, TAG)
        }
    }
}
