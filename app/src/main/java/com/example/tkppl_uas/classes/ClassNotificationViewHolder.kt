package com.example.tkppl_uas.classes
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.tkppl_uas.R

class ClassNotificationViewHolder(
    inflater: LayoutInflater, parent: ViewGroup,
    private val clickListener : ClassNotificationClickListener):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.custom_recycle_view_notification, parent, false)) {
    private var imgView : ImageView? = null
    private var info : TextView? = null
    private var time : TextView? = null
    private var layout : ConstraintLayout? = null

    init {
        imgView = itemView.findViewById(R.id.ivPicture)
        info = itemView.findViewById(R.id.tvInfo)
        time = itemView.findViewById(R.id.tvTime)
        layout = itemView.findViewById(R.id.layoutNotif)
    }

    fun bind(data: ClassNotification){
        imgView?.setImageResource(data.image)
        info?.setText(data.info)
        time?.setText(data.time)
        layout?.setOnClickListener {
            clickListener.onClick(data)
        }
    }

}
