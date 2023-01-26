package com.example.tkppl_uas.classes

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.tkppl_uas.R
import java.text.NumberFormat
import java.util.*

class ClassProductViewHolder (
    inflater: LayoutInflater, parent: ViewGroup,
    private val clickListener : ClassProductClickListener
): RecyclerView.ViewHolder(inflater.inflate(R.layout.custom_recycle_view_product, parent, false)) {
    private var imgView: ImageView? = null
    private var title: TextView? = null
    private var weight: TextView? = null
    private var price: TextView? = null
    private var cardView: CardView? = null

    init {
        imgView = itemView.findViewById(R.id.ivProductImage)
        title = itemView.findViewById(R.id.tvProductTitle)
        weight = itemView.findViewById(R.id.tvProductWeight)
        price = itemView.findViewById(R.id.tvProductPrice)
        cardView = itemView.findViewById(R.id.productCardView)
    }

    fun bind(data: ClassProduct) {
        imgView?.setImageResource(data.imgView)
        title?.setText(data.title)
        weight?.setText("${data.weight} price")
        price?.setText(formatRupiah(data.price.toDouble()))
        cardView?.setOnClickListener {
            clickListener.onClick(data)
        }
    }

    private fun formatRupiah(number : Double) : String{
        var localeID = Locale("in", "ID")
        var formatRupiah = NumberFormat.getCurrencyInstance(localeID)
        return formatRupiah.format(number)
    }
}