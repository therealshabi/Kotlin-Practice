package technolifestyle.com.kotlinPractice.BottomSheet


import android.annotation.SuppressLint
import android.app.Dialog
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialogFragment
import android.support.design.widget.CoordinatorLayout
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import technolifestyle.com.kotlinPractice.R

class BottomSheetFragment : BottomSheetDialogFragment() {

    @SuppressLint("InflateParams", "RestrictedApi")
    override fun setupDialog(dialog: Dialog?, style: Int) {
        super.setupDialog(dialog, style)

        val view = LayoutInflater.from(context).inflate(R.layout.fragment_bottom_sheet, null)
        dialog?.setContentView(view)

        val params: CoordinatorLayout.LayoutParams = (view.parent as View).layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior

        if (behavior != null && behavior is BottomSheetBehavior) {

            behavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
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
                    Toast.makeText(context, "Bottom Sheet State Changed to: $state", Toast.LENGTH_SHORT).show()
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                }
            })
        }
    }
}
