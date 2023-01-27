package com.example.tkppl_uas

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_address.*

class AddAddressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_address)
    }

    fun validateEmpty(): Boolean{
        if (!TextUtils.isEmpty(Username.text.toString().trim())&&
            !TextUtils.isEmpty(Address.text.toString().trim())&&
            !TextUtils.isEmpty(otherDetailAddress.text.toString().trim())&&
            !TextUtils.isEmpty(Phone.text.toString().trim()))
        {
            return true
        }
        else {
            when{
                TextUtils.isEmpty(Username.text.toString().trim())->{
                    text_input_layout_username.setError("Please Enter Username")
                }
                TextUtils.isEmpty(Address.text.toString().trim())->{
                    text_input_layout_address.setError("Please Enter Email")
                }
                TextUtils.isEmpty(otherDetailAddress.text.toString().trim())->{
                    text_input_layout_otherAddress.setError("Please Enter Password")
                }
                TextUtils.isEmpty(Phone.text.toString().trim())->{
                    text_input_layout_phone.setError("Please Enter Password")
                }
            }
            if(!TextUtils.isEmpty(Username.text.toString().trim()))
                text_input_layout_username.setError(null)
            if(!TextUtils.isEmpty(Address.text.toString().trim()))
                text_input_layout_address.setError(null)
            if(!TextUtils.isEmpty(otherDetailAddress.text.toString().trim()))
                text_input_layout_otherAddress.setError(null)
            if(!TextUtils.isEmpty(Phone.text.toString().trim()))
                text_input_layout_phone.setError(null)
            return false
        }
    }


    fun onBtnAddClicked(view: View) {
        if (validateEmpty()){
            finish()
            Toast.makeText(this, "Address added to the list", Toast.LENGTH_SHORT).show()
        }
    }


}