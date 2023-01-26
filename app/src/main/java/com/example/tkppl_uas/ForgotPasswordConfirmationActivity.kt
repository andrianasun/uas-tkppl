package com.example.project

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tkppl_uas.R
import com.example.tkppl_uas.SigninActivity
import com.example.tkppl_uas.classes.classLoadingDialogBar
import kotlinx.android.synthetic.main.activity_forgot_password_confirmation.*
import kotlinx.android.synthetic.main.activity_signin.*

class ForgotPasswordConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password_confirmation)
        val newPass = findViewById<EditText>(R.id.etNewPass)
        val confirmPass = findViewById<EditText>(R.id.etConfirmPass)
        showProgressDialog()
    }

    fun validate():Boolean{
        when{
            TextUtils.isEmpty(etNewPass.text.toString().trim())->{
                text_input_layout_new_pass.setError("Please Enter New Password")
                return false
            }
            TextUtils.isEmpty(etConfirmPass.text.toString().trim())->{
                text_input_layout_confirm_pass.setError("Please Enter Confirm Password")
                return false
            }
            !etNewPass.text.toString().equals(etConfirmPass.text.toString())->{
                var validateToast = Toast.makeText(this, "New password and confirme password must be same", Toast.LENGTH_LONG)
                validateToast.show()
                return false
            }
        }
        if(!TextUtils.isEmpty(etPassword2.text.toString().trim()))
            text_input_layout_password.setError(null)
        return true
    }
    fun onVerifyClick(view: View) {
        validate()
        if (validate().equals(true))
        {
            showProgressDialog()
            val isDialog : android.app.AlertDialog
            val inflater = this.layoutInflater
            val dialogView = inflater.inflate(R.layout.custom_dialog_goto_signin, null)
            val builder = android.app.AlertDialog.Builder(this)
                .setView(dialogView)
                .setCancelable(false)
            isDialog = builder.create()
            Handler().postDelayed(object : Runnable {
                override fun run() {
                    isDialog.show()
                }
            }, 1000)
            val btn = dialogView.findViewById<Button>(R.id.button)
            btn.setOnClickListener {
                val intent = Intent(this, SigninActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            }

        }

    }
    fun showProgressDialog (){
        val loading = classLoadingDialogBar(this, 1000)
        loading.startLoading()
    }

    fun onBackBtnClicked(view: View) {
        finish()
    }
}