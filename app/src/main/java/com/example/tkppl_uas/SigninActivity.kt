package com.example.tkppl_uas

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project.ForgotPassActivity
import com.example.tkppl_uas.classes.classLoadingDialogBar
import kotlinx.android.synthetic.main.activity_signin.*

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        showProgressDialog()
    }

    fun validateEmpty(){
        when{
            TextUtils.isEmpty(etUsername2.text.toString().trim())->{
                text_input_layout_username.setError("Please Enter Username")
            }
            TextUtils.isEmpty(etPassword2.text.toString().trim())->{
                text_input_layout_password.setError("Please Enter Password")
            }
        }
        if(!TextUtils.isEmpty(etUsername2.text.toString().trim()))
            text_input_layout_username.setError(null)
        if(!TextUtils.isEmpty(etPassword2.text.toString().trim()))
            text_input_layout_password.setError(null)

    }

    fun onSignInClick(view: View) {
        validateEmpty()
        if (etUsername2.text.toString().isNotEmpty()
            && etPassword2.text.toString().isNotEmpty())
        {
            var signInToast = Toast.makeText(this, "Sign In success", Toast.LENGTH_LONG)
            val intent = Intent(this, MainActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            signInToast.show()
            finish()

        }
    }
    fun onSignUpTVClick(view: View) {
        val intent = Intent(this, SignupActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
    fun onForgotPassClick(view: View) {
        val intent = Intent(this, ForgotPassActivity::class.java)
        startActivity(intent)
    }
    fun showProgressDialog (){
        val loading = classLoadingDialogBar(this, 1000)
        loading.startLoading()
    }

}