package com.example.tkppl_uas.classes

var productList = ArrayList<ClassProduct>()
val PRODUCT_ID_EXTRA = "productExtra"

class ClassProduct(
    val imgView : Int,
    val title: String,
    val price: Int,
    val weight: String? = "",
    val id: Int? = productList.size
)
