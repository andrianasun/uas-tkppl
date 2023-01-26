package com.example.tkppl_uas

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tkppl_uas.classes.*
import kotlinx.android.synthetic.main.fragment_home.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment(), ClassProductClickListener {
    private var param1: String? = null
    private var param2: String? = null
    lateinit var  recyclerView: RecyclerView
    lateinit var categoriesAdapter: ClassCategoriesAdapter
    lateinit var productAdapter: ClassProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //recyclerview categories
        addCategoriesRecycleview()
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = categoriesAdapter

        //recyclerview products
        addProductRecycleView()

        recyclerView.layoutManager = object : GridLayoutManager(activity, 2){
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView.adapter = productAdapter

        //set button See All clicked
        btnSeeAll.setOnClickListener {
            val intent = Intent(this.requireContext(), AllCategoriesActivity::class.java)
            startActivity(intent)
        }

        btnCart.setOnClickListener {
            val intent = Intent(activity, ShoppingCartActivity::class.java)
            startActivity(intent)
        }

    }

    private fun addCategoriesRecycleview() {
        recyclerView = rvCategories
        var data = ArrayList<ClassCategories>()
        data.add(ClassCategories(R.drawable.img_vegetables, "Vegetables"))
        data.add(ClassCategories(R.drawable.img_fruits, "Fruits"))
        data.add(ClassCategories(R.drawable.img_seasoning, "Seasoning"))
        data.add(ClassCategories(R.drawable.img_meat, "Meat"))
        data.add(ClassCategories(R.drawable.img_protein, "Protein"))

        categoriesAdapter = ClassCategoriesAdapter(data)
    }

    private fun addProductRecycleView() {
        recyclerView = rvProducts
        productList.add(ClassProduct(R.drawable.img_broccoli,"Broccoli Organic", 25000, "1 kg"))
        productList.add(ClassProduct(R.drawable.img_celery,"Celery Organic", 1000, "1 kg"))
        productList.add(ClassProduct(R.drawable.img_broccoli,"Broccoli Organic", 25000, "1 kg"))
        productList.add(ClassProduct(R.drawable.img_celery,"Celery Organic", 1000, "1 kg"))
        productList.add(ClassProduct(R.drawable.img_broccoli,"Broccoli Organic", 25000, "1 kg"))
        productList.add(ClassProduct(R.drawable.img_celery,"Celery Organic", 1000, "1 kg"))
        productList.add(ClassProduct(R.drawable.img_broccoli,"Broccoli Organic", 25000, "1 kg"))
        productList.add(ClassProduct(R.drawable.img_celery,"Celery Organic", 1000, "1 kg"))
        productList.add(ClassProduct(R.drawable.img_broccoli,"Broccoli Organic", 25000, "1 kg"))
        productList.add(ClassProduct(R.drawable.img_celery,"Celery Organic", 1000, "1 kg"))
        productList.add(ClassProduct(R.drawable.img_broccoli,"Broccoli Organic", 25000, "1 kg"))
        productList.add(ClassProduct(R.drawable.img_celery,"Celery Organic", 1000, "1 kg"))
        productList.add(ClassProduct(R.drawable.img_broccoli,"Broccoli Organic", 25000, "1 kg"))
        productList.add(ClassProduct(R.drawable.img_celery,"Celery Organic", 1000, "1 kg"))
        productList.add(ClassProduct(R.drawable.img_broccoli,"Broccoli Organic", 25000, "1 kg"))
        productList.add(ClassProduct(R.drawable.img_celery,"Celery Organic", 1000, "1 kg"))

        val homeFragment = this
        productAdapter = ClassProductAdapter(productList, homeFragment)


    }

    override fun onClick(product: ClassProduct) {
        val intent = Intent(this.requireContext(), ProductDetailActivity::class.java)
        intent.putExtra(PRODUCT_ID_EXTRA, product.id)
        startActivity(intent)
    }

}