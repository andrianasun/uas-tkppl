package com.example.tkppl_uas

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tkppl_uas.classes.ClassEditProfile
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
    }

    fun onBtnSaveProfileClicked(view: View) {
        var username = Username.text.toString()
        var email = Email.text.toString()
        var password = Password.text.toString()
        var phone = Phone.text.toString()
        var editProfile = ClassEditProfile (username, email, password, phone)
        var intentdata = Intent()
        if(username.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty()){
            setResult(EXTRA_CANCEL_EDITPROFILE_CODE, intentdata)
        }
        else{
            intentdata.putExtra(EXTRA_EDIT_PROFILE, editProfile)
            setResult(EXTRA_RESULT_EDITPROFILE_CODE, intentdata)
        }
//        Toast.makeText(this, "Save profile success", Toast.LENGTH_SHORT).show()
        finish()
    }


}