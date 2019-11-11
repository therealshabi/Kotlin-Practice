package technolifestyle.com.kotlinPractice

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_card_item.view.*
import technolifestyle.com.kotlinPractice.asyncTask.AsyncTaskActivity
import technolifestyle.com.kotlinPractice.autoImageSlider.AutoImageSliderActivity
import technolifestyle.com.kotlinPractice.bottomSheet.BottomSheetActivity
import technolifestyle.com.kotlinPractice.bottomSheet.BottomSheetFragmentActivity
import technolifestyle.com.kotlinPractice.contentprovider.ContentProviderActivity
import technolifestyle.com.kotlinPractice.locationService.LocationActivity
import technolifestyle.com.kotlinPractice.navigationLayout.InwardNavigationActivity
import technolifestyle.com.kotlinPractice.notification.NotificationActivity
import technolifestyle.com.kotlinPractice.twoPaneLayout.TwoPaneLayoutActivity
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion.ASYNC_TASK_ACTIVITY
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion.AUTO_IMAGE_SLIDER_ACTIVITY
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion.BOTTOM_SHEET_ACTIVITY_TAG
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion
        .BOTTOM_SHEET_FRAGMENT_ACTIVITY
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion.CONTENT_PROVIDER_ACTIVITY
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion
        .INWARD_NAVIGATION_LAYOUT_ACTIVITY
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion.LOCATION_ACTIVITY_TAG
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion.NOTIFICATION_ACTIVITY_TAG
import technolifestyle.com.kotlinPractice.utils.StringUtils.Companion.TWO_PANE_LAYOUT_ACTIVITY

class PracticeAdapter(private val context: Context?,
                      private val practiceTopics: MutableList<String>) :
        RecyclerView.Adapter<PracticeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PracticeViewHolder {
        val view = LayoutInflater.from(context).inflate(
                R.layout.main_card_item, parent, false)
        return PracticeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return practiceTopics.size
    }

    override fun onBindViewHolder(holder: PracticeViewHolder, position: Int) {
        holder.bindItem(practiceTopics[position])
    }
}

class PracticeViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private val tvPracticeItem = itemView.tvPractice!!

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.tag) {
            NOTIFICATION_ACTIVITY_TAG -> view.context.startActivity(
                    Intent(view.context, NotificationActivity::class.java))
            BOTTOM_SHEET_ACTIVITY_TAG -> view.context.startActivity(Intent(
                    view.context, BottomSheetActivity::class.java))
            BOTTOM_SHEET_FRAGMENT_ACTIVITY -> view.context.startActivity(Intent(
                    view.context, BottomSheetFragmentActivity::class.java))
            INWARD_NAVIGATION_LAYOUT_ACTIVITY -> view.context.startActivity(Intent(
                    view.context, InwardNavigationActivity::class.java))
            TWO_PANE_LAYOUT_ACTIVITY -> view.context.startActivity(Intent(
                    view.context, TwoPaneLayoutActivity::class.java))
            LOCATION_ACTIVITY_TAG -> view.context.startActivity(Intent(
                    view.context, LocationActivity::class.java))
            AUTO_IMAGE_SLIDER_ACTIVITY -> view.context.startActivity(Intent(
                    view.context, AutoImageSliderActivity::class.java))
            ASYNC_TASK_ACTIVITY -> view.context.startActivity(Intent(
                    view.context, AsyncTaskActivity::class.java))
            CONTENT_PROVIDER_ACTIVITY -> view.context.startActivity(Intent(
                    view.context, ContentProviderActivity::class.java))
        }
    }

    fun bindItem(item: String) {
        tvPracticeItem.text = item
        itemView.tag = item
    }
}
