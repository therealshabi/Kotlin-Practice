package technolifestyle.com.kotlinPractice.autoImageSlider

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_auto_image_slider.*
import technolifestyle.com.imageslider.FlipperView
import technolifestyle.com.kotlinPractice.R


class AutoImageSliderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_image_slider)

        val url = arrayOf(
                "https://blog.eap.ucop.edu/wp-content/uploads/2016/01/Julie-Huang-27.jpg",
                "https://source.unsplash.com/random",
                "https://i.pinimg.com/originals/18/40/72/184072abb72399c23ab635faaa0a94ad.jpg")

        for (i in url.indices) {
            val view = FlipperView(baseContext)
            view.setImageUrl(url[i]) { imageView, image ->
                Picasso.get().load(image).into(imageView)
            }.setDescription("Cool" + (i + 1))

            view.setDescriptionBackground(Color.BLUE, 0.5f)
            flipperLayout.addFlipperView(view)
            flipperLayout.scrollTimeInSec = 5
            view.setOnFlipperClickListener(object : FlipperView.OnFlipperClickListener {
                override fun onFlipperClick(flipperView: FlipperView) {
                    Toast.makeText(this@AutoImageSliderActivity,
                            "Here " + (flipperLayout.currentPagePosition + 1),
                            Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
