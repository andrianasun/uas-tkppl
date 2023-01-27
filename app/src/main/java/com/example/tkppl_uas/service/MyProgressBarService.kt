package com.example.tkppl_uas.service

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.app.JobIntentService
import com.example.tkppl_uas.ACTION_PROGRESS
import com.example.tkppl_uas.EXTRA_FINISH
import com.example.tkppl_uas.EXTRA_PERSEN
import com.example.tkppl_uas.JOB_ID_PROGRESS

class MyProgressBarService : JobIntentService() {

    override fun onHandleWork(intent: Intent) {
        var progress = 0
        do {
            Thread.sleep(500)
            progress += 20
            var intentProgress = Intent(ACTION_PROGRESS)
            intentProgress.putExtra(EXTRA_PERSEN, progress)
            intentProgress.putExtra(EXTRA_FINISH, false)
            if(progress >= 100){
                intentProgress.putExtra(EXTRA_FINISH, true)
            }
            sendBroadcast(intentProgress)
        }while (progress < 100)
    }
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Downlaod Selesai", Toast.LENGTH_SHORT).show()
    }
    companion object{
        fun enqueueWork(context: Context, intent: Intent){
            enqueueWork(context, MyProgressBarService::class.java,
                JOB_ID_PROGRESS, intent)
        }
    }
}