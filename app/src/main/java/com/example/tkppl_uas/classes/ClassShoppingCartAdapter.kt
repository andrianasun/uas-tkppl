package com.example.tkppl_uas.classes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class ClassShoppingCartAdapter(private val data: ArrayList<ClassShoppingCart>) : RecyclerView.Adapter<ClassShoppingCartViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassShoppingCartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ClassShoppingCartViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ClassShoppingCartViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}