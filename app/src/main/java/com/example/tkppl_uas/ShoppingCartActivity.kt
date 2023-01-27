package com.example.tkppl_uas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tkppl_uas.classes.ClassShoppingCart
import com.example.tkppl_uas.classes.ClassShoppingCartAdapter
import kotlinx.android.synthetic.main.activity_shopping_cart.*

class ShoppingCartActivity : AppCompatActivity() {
    lateinit var recyclerView1: RecyclerView
    lateinit var recyclerView2: RecyclerView
    lateinit var shoppingCartAdapter1: ClassShoppingCartAdapter
    lateinit var shoppingCartAdapter2: ClassShoppingCartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

        addShoppingCartRecycleView()
        recyclerView1.layoutManager = object : LinearLayoutManager(this){
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView1.adapter = shoppingCartAdapter1

        recyclerView2.layoutManager = object : LinearLayoutManager(this){
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView2.adapter = shoppingCartAdapter2

        btnCheckout.setOnClickListener { btnCheckoutClick() }
        btnCheckout2.setOnClickListener { btnCheckoutClick() }
    }

    private fun btnCheckoutClick() {
        val intent = Intent(this, CheckoutActivity::class.java)
        startActivity(intent)
    }

    private fun addShoppingCartRecycleView() {
        recyclerView1 = rvShoppingCartItem
        val data1 = ArrayList<ClassShoppingCart>()
        data1.add(ClassShoppingCart(R.drawable.img_broccoli, "vegetable", "Broccoli Organic", 25000, "1kg", 1, data1.size))
        data1.add(ClassShoppingCart(R.drawable.img_celery, "vegetable", "Celery", 10000, "100gr",1, data1.size))
        shoppingCartAdapter1 = ClassShoppingCartAdapter(data1)

        recyclerView2 = rvShoppingCartItem2
        val data2 = ArrayList<ClassShoppingCart>()
        data2.add(ClassShoppingCart(R.drawable.img_celery, "vegetable", "Celery", 10000, "100gr",2, data1.size))

        shoppingCartAdapter2 = ClassShoppingCartAdapter(data2)
    }

    fun onBackBtnClicked(view: View) {
        finish()
    }
}