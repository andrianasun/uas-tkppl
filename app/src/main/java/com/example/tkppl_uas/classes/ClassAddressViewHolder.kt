package com.example.tkppl_uas

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tkppl_uas.classes.ClassAddress

class ClassAddressViewHolder(
    inflater: LayoutInflater, parent: ViewGroup
): RecyclerView.ViewHolder(inflater.inflate(R.layout.custom_recycle_view_address_list, parent, false)) {

    private var deliveryAdd: TextView? = null
    private var home: TextView? = null
    private var street: TextView? = null

    init {
        deliveryAdd = itemView.findViewById(R.id.tvDeliveryAddress)
        home = itemView.findViewById(R.id.tvAddressName)
        street = itemView.findViewById(R.id.tvAddressDetail)
    }

    fun bind(data: ClassAddress) {
        deliveryAdd?.text = data.deliveryAdd
        home?.text = data.home
        street?.text = data.street
    }
}

