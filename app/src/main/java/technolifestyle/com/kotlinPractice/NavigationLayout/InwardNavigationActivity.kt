package technolifestyle.com.kotlinPractice.NavigationLayout

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_inward_navigation.*
import technolifestyle.com.kotlinPractice.R


class InwardNavigationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inward_navigation)

        drawerLayout.setScrimColor(Color.TRANSPARENT)
        drawerLayout.drawerElevation = 0f

        val actionBarDrawerToggle = object : ActionBarDrawerToggle(
                this, drawerLayout, R.string.open, R.string.close) {

            private val scaleFactor = 10f

            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                val slideX = drawerView.width * slideOffset
                llContent.translationX = slideX
                llContent.scaleX = 1 - slideOffset.div(scaleFactor)
                llContent.scaleY = 1 - slideOffset.div(scaleFactor)
            }
        }

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
    }
}
