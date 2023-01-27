package com.example.tkppl_uas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tkppl_uas.classes.ClassAddress

class AddressListActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ClassAddressAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address_list)

        init()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun init() {
        recyclerView = findViewById(R.id.itemAddress)

        var data = ArrayList<ClassAddress>()
        data.add(ClassAddress("Delivery address", "Home", "42 M.H.Thamrin Street, Medan, Sumatera Utara"))
        data.add(ClassAddress("Delivery address", "Work", "43 M.H.Thamrin Street, Medan, Sumatera Utara"))
        data.add(ClassAddress("Delivery address", "School", "44 M.H.Thamrin Street, Medan, Sumatera Utara"))
        data.add(ClassAddress("Delivery address", "Asun's House", "45 M.H.Thamrin Street, Medan, Sumatera Utara"))

        adapter = ClassAddressAdapter(data)
    }
    fun onBtnAddClicked(view: View) {
        val intent = Intent(this, AddAddressActivity::class.java)
        startActivity(intent)
    }
    fun onBtnSaveAddressClicked(view: View) {
        Toast.makeText(this, "Save address success", Toast.LENGTH_SHORT).show()
        finish()
    }
}