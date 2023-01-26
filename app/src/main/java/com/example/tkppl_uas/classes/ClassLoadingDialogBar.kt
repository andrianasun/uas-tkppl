package com.example.tkppl_uas.classes

import android.app.Activity
import android.app.AlertDialog
import android.os.Handler
import android.widget.TextView
import com.example.tkppl_uas.R

class classLoadingDialogBar (val myActivity: Activity, val timeDelay: Long, var text : String = "") {
    private lateinit var isDialog : AlertDialog
    fun startLoading(){
        val inflater = myActivity.layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_dialog_loading, null)
        val builder = AlertDialog.Builder(myActivity)
            .setView(dialogView)
            .setCancelable(false)
        val textView = dialogView.findViewById<TextView>(R.id.textView)
        if(!text.equals("")){
            textView.setText(text)
        }
        isDialog = builder.create()
        isDialog.show()
        val handler = Handler()
        handler.postDelayed(object : Runnable {
            override fun run() {
                isDialog.dismiss()
            }
        }, timeDelay)
    }
}