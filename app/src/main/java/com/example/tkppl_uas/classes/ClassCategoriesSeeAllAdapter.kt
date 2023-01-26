package com.example.tkppl_uas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tkppl_uas.classes.ClassCategories
import com.example.tkppl_uas.classes.ClassCategoriesSeeAllViewHolder

class ClassCategoriesSeeAllAdapter(private val data: ArrayList<ClassCategories>) : RecyclerView.Adapter<ClassCategoriesSeeAllViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassCategoriesSeeAllViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ClassCategoriesSeeAllViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ClassCategoriesSeeAllViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}