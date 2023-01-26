package com.example.tkppl_uas.classes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ClassProductAdapter (
    private val data: ArrayList<ClassProduct>,
    private val clickListener : ClassProductClickListener
) : RecyclerView.Adapter<ClassProductViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ClassProductViewHolder(inflater, parent, clickListener)
    }

    override fun onBindViewHolder(holder: ClassProductViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}