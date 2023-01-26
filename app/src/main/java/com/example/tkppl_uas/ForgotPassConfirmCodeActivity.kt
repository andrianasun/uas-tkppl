package com.example.project

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.tkppl_uas.R
import com.example.tkppl_uas.classes.classLoadingDialogBar
import kotlin.random.Random

class ForgotPassConfirmCodeActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass_confirm_code)

        val inputCode1 = findViewById<EditText>(R.id.inputCode1)
        val inputCode2 = findViewById<EditText>(R.id.inputCode2)
        val inputCode3 = findViewById<EditText>(R.id.inputCode3)
        val inputCode4 = findViewById<EditText>(R.id.inputCode4)

        showProgressDialog()
        inputCode1.isEnabled = false
        inputCode2.isEnabled = false
        inputCode3.isEnabled = false
        inputCode4.isEnabled = false

        setRandomNumber(inputCode1)
        setRandomNumber(inputCode2)
        setRandomNumber(inputCode3)
        setRandomNumber(inputCode4)
    }

    fun onSendClick(view: View) {
        val intent = Intent(this, ForgotPasswordConfirmationActivity::class.java)
        startActivity(intent)
    }
    fun randomNumber() : Int = Random.nextInt(0,9)
    fun showProgressDialog (){
        val loading = classLoadingDialogBar(this, 1000)
        loading.startLoading()
    }
    fun setRandomNumber(editText: EditText){
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                editText.setText(randomNumber().toString())
            }
        }, 1000)
    }

    fun onBackBtnClicked(view: View) {
        finish()
    }

}