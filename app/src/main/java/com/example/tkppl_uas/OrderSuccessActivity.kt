package com.example.tkppl_uas

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tkppl_uas.service.MyProgressBarService
import kotlinx.android.synthetic.main.custom_dialog_progress_bar.*

class OrderSuccessActivity : AppCompatActivity() {
    private  val progressReceiver = object : BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            var persen = p1?.getIntExtra(EXTRA_PERSEN, 0)
            var selesai = p1?.getBooleanExtra(EXTRA_FINISH, true)
            myProgress.progress = persen ?: 0
            if(selesai!!){
                Toast.makeText(this@OrderSuccessActivity, "Finised", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_success)


        var filterDownlaod = IntentFilter(ACTION_PROGRESS)
        registerReceiver(progressReceiver, filterDownlaod)
    }

    fun onBtnTrackOrderClicked(view: View) {
        val myService = Intent(this, MyProgressBarService::class.java)
        myService.putExtra(EXTRA_TIME, 500L)
        MyProgressBarService.enqueueWork(this, myService)



        Handler().postDelayed({
            val intent = Intent(this, OrderRecordActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    //    fun onBtnBackToHomeClicked(view: View) {
//        val intent = Intent(this, MainActivity::class.java)
//        startActivity(intent)
//        finish()
//    }
    override fun onDestroy() {
        super.onDestroy()
//        val intent = Intent(this, OrderRecordActivity::class.java)
//        startActivity(intent)
        unregisterReceiver(progressReceiver)
    }
}