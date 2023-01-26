package com.example.tkppl_uas

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tkppl_uas.classes.classLoadingDialogBar
import kotlinx.android.synthetic.main.activity_forgot_pass.*

class ForgotPassActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)
        showProgressDialog()
    }

    fun validateEmpty() {
        when{
            TextUtils.isEmpty(etPhoneNumber.text.toString().trim())->{
                text_input_layout_phone_number.setError("Please Enter Phone Number")
            }
        }
        if(!TextUtils.isEmpty(etPhoneNumber.text.toString().trim()))
            text_input_layout_phone_number.setError(null)
    }

    fun onSendClick(view: View) {
        validateEmpty()
        if(etPhoneNumber.text.toString().isNotEmpty())
        {
            val intent = Intent(this, ForgotPassConfirmCodeActivity::class.java)
            startActivity(intent)
        }
    }
    fun onBackBtn(view: View) {
        finish()
    }
    fun showProgressDialog (){
        val loading = classLoadingDialogBar(this, 1000)
        loading.startLoading()
    }

    fun onBackBtnClicked(view: View) {
        finish()
    }
}