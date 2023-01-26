package com.example.tkppl_uas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class WelcomeScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_screen)

    }

    fun onSignInClick(view: View) {
        val intent = Intent(this, SigninActivity::class.java)
        startActivity(intent)
    }
    fun onSignUpClick(view: View) {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }
}