package com.example.tkppl_uas

import android.graphics.Color
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        switch_darktheme.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                Toast.makeText(applicationContext, "Dark mode active", Toast.LENGTH_SHORT).show()
/*                rootLayout.setBackgroundColor(Color.BLACK)
                switch_darktheme.setTextColor(Color.WHITE)
                switch_notification.setTextColor(Color.WHITE)
                tvSetting.setTextColor(Color.WHITE)
                layoutLanguage.setBackgroundColor(Color.BLACK)
                layoutLanguage.boxStrokeColor = Color.parseColor("#FFFFFF")
                layoutLanguage.hintTextColor*/
                tvSetting.setTextColor(Color.WHITE)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            }else{
                Toast.makeText(applicationContext, "Light mode active", Toast.LENGTH_SHORT).show()
/*                rootLayout.setBackgroundColor(Color.WHITE)
                switch_darktheme.setTextColor(Color.BLACK)
                switch_notification.setTextColor(Color.BLACK)
                tvSetting.setTextColor(Color.BLACK)
                layoutLanguage.setBackgroundColor(Color.WHITE)
                layoutLanguage.boxStrokeColor = Color.parseColor("#000000")*/
                tvSetting.setTextColor(Color.BLACK)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        switch_notification.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                Toast.makeText(applicationContext, "Notification on active", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Notification off active", Toast.LENGTH_SHORT).show()
            }
        }

        val language = resources.getStringArray(R.array.Language)
        val arrayAdapter = ArrayAdapter(this, R.layout.custom_dropdown_language_item, language)
        autoCompleteTvLanguage.setAdapter(arrayAdapter)

        saveSettings.setOnClickListener {
            Toast.makeText(this, "Save settings success", Toast.LENGTH_SHORT).show()
            finish()
        }
    }



}
