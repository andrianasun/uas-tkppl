package com.example.tkppl_uas

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tkppl_uas.classes.ClassCategories
import kotlinx.android.synthetic.main.fragment_home.*

class AllCategoriesActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var categoriesAdapter: ClassCategoriesSeeAllAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_categories)

        addCategoriesRecycleview()
        recyclerView.layoutManager = object : GridLayoutManager(this, 2){
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView.adapter = categoriesAdapter
    }

    private fun addCategoriesRecycleview() {
        recyclerView = rvCategories
        var data = ArrayList<ClassCategories>()
        data.add(ClassCategories(R.drawable.img_vegetables, "Vegetables"))
        data.add(ClassCategories(R.drawable.img_fruits, "Fruits"))
        data.add(ClassCategories(R.drawable.img_seasoning, "Seasoning"))
        data.add(ClassCategories(R.drawable.img_meat, "Meat"))
        data.add(ClassCategories(R.drawable.img_protein, "Protein"))

        categoriesAdapter = ClassCategoriesSeeAllAdapter(data)
    }

    fun onBackBtnClicked(view: View) {
        finish()
    }
}