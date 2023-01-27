package com.example.tkppl_uas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tkppl_uas.classes.ClassAddress

class ClassAddressAdapter(
    private val data: ArrayList<ClassAddress>
): RecyclerView.Adapter<ClassAddressViewHolder>() {
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ClassAddressViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassAddressViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ClassAddressViewHolder(inflater, parent)
    }
}
