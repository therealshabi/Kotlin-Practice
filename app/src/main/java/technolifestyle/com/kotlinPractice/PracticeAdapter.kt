package technolifestyle.com.kotlinPractice

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.main_card_item.view.*
import technolifestyle.com.kotlinPractice.BottomSheet.BottomSheetActivity
import technolifestyle.com.kotlinPractice.Notification.NotificationActivity
import technolifestyle.com.kotlinPractice.Utils.StringUtils.Companion.BOTTOM_SHEET_ACTIVTY_TAG
import technolifestyle.com.kotlinPractice.Utils.StringUtils.Companion.NOTIFICATION_ACTIVITY_TAG

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
            NOTIFICATION_ACTIVITY_TAG -> view.context.startActivity(Intent(view.context, NotificationActivity::class.java))
            BOTTOM_SHEET_ACTIVTY_TAG -> view.context.startActivity(Intent(view.context, BottomSheetActivity::class.java))
        }
    }

    fun bindItem(item: String) {
        tvPracticeItem.text = item
        itemView.tag = item
    }
}
