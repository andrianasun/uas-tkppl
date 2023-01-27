package com.example.tkppl_uas.classes

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tkppl_uas.R
import java.text.NumberFormat
import java.util.*

class ClassShoppingCartViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.custom_recycle_view_shopping_cart, parent, false)) {
    private var imgView : ImageView? = null
    private var type : TextView? = null
    private var title : TextView? = null
    private var price: TextView? = null
    private var weight: TextView? = null
    private var quantity: EditText? = null

    init {
        imgView = itemView.findViewById(R.id.ivProductImage)
        type = itemView.findViewById(R.id.tvProductType)
        title = itemView.findViewById(R.id.tvProductTitle)
        price = itemView.findViewById(R.id.tvProductPrice)
        weight = itemView.findViewById(R.id.tvProductWeight)
        quantity = itemView.findViewById(R.id.etQuantity)
    }

    fun bind(data: ClassShoppingCart){
        imgView?.setImageResource(data.imgView)
        type?.setText(data.type)
        title?.setText(data.title)
        price?.setText("${formatRupiah(data.price.toDouble())}")
        weight?.setText(data.weight)
        quantity?.setText(data.quantity.toString())
    }

    private fun formatRupiah(number : Double) : String{
        var localeID = Locale("in", "ID")
        var formatRupiah = NumberFormat.getCurrencyInstance(localeID)
        return formatRupiah.format(number)
    }
}
