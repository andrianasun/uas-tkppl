package com.example.tkppl_uas

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tkppl_uas.classes.classLoadingDialogBar
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        showProgressDialog()
    }

    fun validateEmpty(){
        when{
            TextUtils.isEmpty(etUsername2.text.toString().trim())->{
                text_input_layout_username2.setError("Please Enter Username")
            }
            TextUtils.isEmpty(etEmail2.text.toString().trim())->{
                text_input_layout_email2.setError("Please Enter Email")
            }
            TextUtils.isEmpty(etPassword2.text.toString().trim())->{
                text_input_layout_password2.setError("Please Enter Password")
            }
            TextUtils.isEmpty(etPhoneNumber2.text.toString().trim())->{
                text_input_layout_phone2.setError("Please Enter Password")
            }
        }
        if(!TextUtils.isEmpty(etUsername2.text.toString().trim()))
            text_input_layout_username2.setError(null)
        if(!TextUtils.isEmpty(etEmail2.text.toString().trim()))
            text_input_layout_email2.setError(null)
        if(!TextUtils.isEmpty(etPassword2.text.toString().trim()))
            text_input_layout_password2.setError(null)
        if(!TextUtils.isEmpty(etPhoneNumber2.text.toString().trim()))
            text_input_layout_phone2.setError(null)
    }

    fun onSignInTVClick(view: View) {
        val intent = Intent(this, SigninActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
    fun onSignUpClick(view: View) {
        validateEmpty()
        if (etUsername2.text.toString().isNotEmpty() && etEmail2.text.toString().isNotEmpty()
            && etPassword2.text.toString().isNotEmpty() && etPhoneNumber2.text.toString().isNotEmpty())
        {
            var signUpToast = Toast.makeText(this, "You have successfuly create an account", Toast.LENGTH_LONG)
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
            signUpToast.show()
            finish()
        }
    }

    fun showProgressDialog (){
        val loading = classLoadingDialogBar(this, 1000)
        loading.startLoading()
    }

}