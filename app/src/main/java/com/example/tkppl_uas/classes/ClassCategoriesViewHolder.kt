package com.example.tkppl_uas.classes

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tkppl_uas.R

class ClassCategoriesViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.custom_recycle_view_categories, parent, false)) {
    private var imgView : ImageView? = null
    private var title : TextView? = null

    init {
        imgView = itemView.findViewById(R.id.ivImg)
        title = itemView.findViewById(R.id.tvTitle)
    }

    fun bind(data: ClassCategories){
        imgView?.setImageResource(data.imgView)
        title?.setText(data.title)
    }
}