package com.example.tkppl_uas.classes

var cartProductList = ArrayList<ClassShoppingCart>()

class ClassShoppingCart(
    val imgView : Int,
    val type: String,
    val title: String,
    val price: Int,
    val weight: String = "",
    val quantity: Int = 1,
    val id: Int? = productList.size
)