package com.example.tkppl_uas.classes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ClassCategoriesAdapter(private val data: ArrayList<ClassCategories>) : RecyclerView.Adapter<ClassCategoriesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassCategoriesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ClassCategoriesViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ClassCategoriesViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}