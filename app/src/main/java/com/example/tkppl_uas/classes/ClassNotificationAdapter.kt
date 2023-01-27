package com.example.tkppl_uas.classes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tkppl_uas.NotificationFragment

class ClassNotificationAdapter(
    private val data: ArrayList<ClassNotification>,
    private val clickListener: NotificationFragment
) : RecyclerView.Adapter<ClassNotificationViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassNotificationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ClassNotificationViewHolder(inflater, parent, clickListener)
    }

    override fun onBindViewHolder(holder: ClassNotificationViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}