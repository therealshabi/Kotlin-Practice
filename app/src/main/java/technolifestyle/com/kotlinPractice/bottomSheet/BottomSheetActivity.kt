package technolifestyle.com.kotlinPractice.bottomSheet

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_HIDDEN
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

        closeBottomSheetBtn.setOnClickListener {
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
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                        ""
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
