package com.example.tkppl_uas

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_checkout.*
import java.time.LocalDate
import java.time.LocalTime
import java.util.*

class CheckoutActivity : AppCompatActivity() {
    var deliveryScheduleText : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        val payment = resources.getStringArray(R.array.payment)
        val arrayAdapter = ArrayAdapter(this, R.layout.custom_dropdown_payment_item, payment)
        dropdownProductPaymentItem.setAdapter(arrayAdapter)
    }

    fun onBtnChangeDeliveryScheduleClick(view: View) {
        val isDialog : android.app.AlertDialog
        val inflater = this.layoutInflater
        val dialogView = inflater.inflate(R.layout.custom_dialog_delivery_schedule, null)
        val builder = android.app.AlertDialog.Builder(this)
            .setView(dialogView)
        val rdoGroup = dialogView.findViewById<RadioGroup>(R.id.radioGroup)
        val rdoSelfPickUp = dialogView.findViewById<RadioButton>(R.id.rdoSelfPickUp)
        val rdoDelivery = dialogView.findViewById<RadioButton>(R.id.rdoDelivery)
        val switchDelivery = dialogView.findViewById<Switch>(R.id.switchDelivery)
        val date = dialogView.findViewById<LinearLayout>(R.id.llDate)
        val time = dialogView.findViewById<LinearLayout>(R.id.llTime)
        val tvDate = dialogView.findViewById<TextView>(R.id.tvDate)
        val tvTime = dialogView.findViewById<TextView>(R.id.tvTime)
        val btnConfirm = dialogView.findViewById<Button>(R.id.btnConfirm)
        switchDelivery.isVisible = false
        date.isVisible = false
        time.isVisible = false
        rdoGroup.setOnCheckedChangeListener { group, checkedId ->
            if(rdoSelfPickUp.isChecked){
                switchDelivery.isVisible = false
                date.isVisible = false
                time.isVisible = false
            }
            if(rdoDelivery.isChecked){
                switchDelivery.isVisible = true
                switchDelivery.setOnCheckedChangeListener { buttonView, isChecked ->
                    if(switchDelivery.isChecked){
                        date.isVisible = false
                        time.isVisible = false
                    }
                    else{
                        date.isVisible = true
                        time.isVisible = true

                        val cal : Calendar =  Calendar.getInstance()
                        val tahun = cal.get(Calendar.YEAR)
                        val bulan = cal.get(Calendar.MONTH)
                        val hari = cal.get(Calendar.DAY_OF_MONTH)

                        val jam = cal.get(Calendar.HOUR_OF_DAY)
                        val menit = cal.get(Calendar.MINUTE)
                        var am_pm : String = ""
                        var tanggal = LocalDate.of(tahun, bulan+1, hari)
                        var waktu = LocalTime.of(jam, menit)

                        Toast.makeText(this, "${jam} ${menit}", Toast.LENGTH_SHORT).show()
                        if(jam >= 12) am_pm = "PM"
                        else am_pm = "AM"
                        tvDate.setText(tanggal.toString())
                        tvTime.setText("${waktu} ${am_pm}")
                        date.setOnClickListener{
                            val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                                tanggal = LocalDate.of(year, monthOfYear+1, dayOfMonth)
                                tvDate.setText(tanggal.toString())
                            }, tahun, bulan, hari)
                            dpd.show()
                        }
                        time.setOnClickListener{
                            val tpd = TimePickerDialog(this,TimePickerDialog.OnTimeSetListener{ view, hour, minute ->
                                if(hour >= 12){
                                    am_pm = "PM"
//                                        waktu = LocalTime.of(hour-12, minute)
                                }
                                else {
//                                        waktu = LocalTime.of(hour, minute)
                                    am_pm = "AM"
                                }
                                waktu = LocalTime.of(hour, minute)
                                tvTime.setText("${waktu} ${am_pm}")
                            }, jam, menit,false)
                            tpd.show()
                        }
                    }
                }
            }
        }

        isDialog = builder.create()
        Handler().postDelayed(object : Runnable {
            override fun run() {
                isDialog.show()
            }
        }, 1000)
        btnConfirm.setOnClickListener {
            if(rdoSelfPickUp.isChecked){
                deliveryScheduleText = rdoSelfPickUp.text.toString()
            }
            else {
                if (switchDelivery.isChecked) {
                    deliveryScheduleText = "Delivery Now"
                } else {
                    deliveryScheduleText = "${tvDate.text},  ${tvTime.text}"
                }
            }
            tvDeliverySchedule.setText(deliveryScheduleText)
            isDialog.dismiss()
        }
    }
    fun onBtnChangeDeliveryAddressClick(view: View) {
        val intent = Intent(this, AddressListActivity::class.java)
        startActivity(intent)
    }

    fun onBtnConfirmOrderClicked(view: View) {
        val intent = Intent(this, OrderSuccessActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun onBackBtnClicked(view: View) {
        finish()
    }
}