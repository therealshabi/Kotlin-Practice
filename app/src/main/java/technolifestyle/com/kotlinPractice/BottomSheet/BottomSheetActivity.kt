package technolifestyle.com.kotlinPractice.BottomSheet

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetBehavior.STATE_EXPANDED
import android.support.design.widget.BottomSheetBehavior.STATE_HIDDEN
import android.support.v4.widget.NestedScrollView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bottom_sheet.*
import technolifestyle.com.kotlinPractice.R


class BottomSheetActivity : AppCompatActivity() {

    private lateinit var mBottomSheetBehavior: BottomSheetBehavior<NestedScrollView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        mBottomSheetBehavior = BottomSheetBehavior.from(nestedScrollView)

        openBottomSheetBtn.setOnClickListener {
            mBottomSheetBehavior.state = STATE_EXPANDED
        }

        closeBottomSheetBtn.setOnClickListener{
            mBottomSheetBehavior.state = STATE_HIDDEN
        }

        mBottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

            override fun onStateChanged(view: View, newState: Int) {
                val state = when (newState) {
                    BottomSheetBehavior.STATE_DRAGGING -> {
                        "DRAGGING"
                    }
                    BottomSheetBehavior.STATE_SETTLING -> {
                        "SETTLING"
                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        "EXPANDED"
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        "COLLAPSED"
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        "HIDDEN"
                    }
                    else -> ""
                }
                Toast.makeText(this@BottomSheetActivity, "Bottom Sheet State Changed to: $state", Toast.LENGTH_SHORT).show()
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }

        })
    }
}
