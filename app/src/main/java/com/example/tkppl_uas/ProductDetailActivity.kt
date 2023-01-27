package com.example.tkppl_uas

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import com.example.tkppl_uas.classes.ClassProduct
import com.example.tkppl_uas.classes.PRODUCT_ID_EXTRA
import com.example.tkppl_uas.classes.classLoadingDialogBar
import com.example.tkppl_uas.classes.productList
import com.example.tkppl_uas.databinding.ActivityProductDetailBinding
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_product_detail.*
import java.text.NumberFormat
import java.util.*

class ProductDetailActivity : AppCompatActivity(),
    GestureDetector.OnGestureListener
{

    private  lateinit var binding: ActivityProductDetailBinding
    var negoCount = 3
    var productCount = 0
    lateinit var mDetector: GestureDetectorCompat
    var x1: Float = 0.0f
    var x2: Float = 0.0f
    var y1: Float = 0.0f
    var y2: Float = 0.0f

    companion object{
        const val  MIN_DISTANCE = 300
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        btnNegotiation.setBackgroundColor(Color.GREEN)

        //gesture detector
        mDetector = GestureDetectorCompat(this, this)

        binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val productID = intent.getIntExtra(PRODUCT_ID_EXTRA, -1)
        val product = productFromID(productID)

        val productWeight = resources.getStringArray(R.array.weight)
        val arrayAdapter = ArrayAdapter(this, R.layout.custom_dropdown_product_weight_items, productWeight)
        dropdownProductWeightItem.setAdapter(arrayAdapter)

        if(product != null){
            binding.tvProductTitle.setText(product.title)
            binding.ivProductImage.setImageResource(product.imgView)
            binding.tvProductPrice.setText(formatRupiah(product.price.toDouble()))
        }

        btnMinus.isClickable = false
        etCount.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                false
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(etCount.text.equals("") or etCount.text.isNullOrEmpty()) {
                    etCount.setText("0")
                }
                true
            }

            override fun afterTextChanged(s: Editable?) {
                if(etCount.text.toString().toUInt().toInt() > 0){
                    btnMinus.isClickable = true
                }
                else{
                    btnMinus.isClickable = false
                }
                productCount = etCount.text.toString().toUInt().toInt()
                true
            }

        })
    }

    private fun formatRupiah(number : Double) : String{
        var localeID = Locale("in", "ID")
        var formatRupiah = NumberFormat.getCurrencyInstance(localeID)
        return formatRupiah.format(number)
    }

    private fun productFromID(productID: Int): ClassProduct? {
        for(product in productList){
            if(product.id == productID) {
//                Toast.makeText(this, product.id.toString(), Toast.LENGTH_SHORT).show()
                return product
            }
            else
                continue
        }
        return null
    }

    fun showProgressDialog (){
        val loadingNego = classLoadingDialogBar(this, 2000, "Waiting for confirmation...")
        loadingNego.startLoading()
    }

    fun onBtnMinusClicked(view: View) {
        productCount--
        if(etCount.text.toString().toUInt().toInt() <= 1){
            btnMinus.isClickable = false
        }
        etCount.setText("${productCount}")
    }
    fun onBtnPlusClicked(view: View) {
        productCount++
        btnMinus.isClickable = true
        etCount.setText("${productCount}")
    }

    fun onAddToCartCLicked(view: View) {
        Toast.makeText(this,"Item added to cart!", Toast.LENGTH_LONG).show()
    }

    fun onBackBtnClicked(view: View) {
        finish()
    }

    override fun onDown(e: MotionEvent?): Boolean {
        //digunakan ketika kita melakukan tap down (hanya saat awal tap)
        return false
    }

    override fun onShowPress(e: MotionEvent?) {
        //digunakan ketika kita melakukan down da

    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        return false
    }

    override fun onLongPress(e: MotionEvent?) {

    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        return false
    }

    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        super.dispatchTouchEvent(event)
        when(event?.action) {
            //when we start to swipe
            0 -> {
                x1 = event.x
                y1 = event.y
            }

            //when we end the swipe
            1 -> {
                x2 = event.x
                y2 = event.y

                val valueX: Float = x2 - x1
                val valueY: Float = y2 - y1

                if (Math.abs(valueX) > MIN_DISTANCE) {
                    if (x2 > x1) {
//                        Toast.makeText(this, "Right swipe", Toast.LENGTH_SHORT).show()
                    } else if (x2 < x1) {
//                        Toast.makeText(this, "Left swipe", Toast.LENGTH_SHORT).show()
                        if(negoCount >= 1){
                            val dialogNego : android.app.AlertDialog
                            val negoInflater = this.layoutInflater
                            val dialogNegoView = negoInflater.inflate(R.layout.custom_dialog_negotiation, null)
                            val builder = android.app.AlertDialog.Builder(this)
                                .setView(dialogNegoView)
                            val etPrice = dialogNegoView.findViewById<EditText>(R.id.etPrice)
                            var tvNegoDesc = dialogNegoView.findViewById<TextView>(R.id.tvPriceOfferDesc)
                            val layoutPrice = dialogNegoView.findViewById<TextInputLayout>(R.id.text_input_layout_price)
                            val btnOk = dialogNegoView.findViewById<Button>(R.id.btnOk)
                            val btnCancel = dialogNegoView.findViewById<Button>(R.id.btnCancel)
                            tvNegoDesc.setText("You have ${negoCount} chances to negotiate")
                            dialogNego = builder.create()
                            dialogNego.show()



                            btnOk.setOnClickListener {
                                tvNegoDesc.setText("You have ${negoCount} chances to negotiate")
                                val productID = intent.getIntExtra(PRODUCT_ID_EXTRA, -1)
                                val product = productFromID(productID)
                                if(product != null){
                                    if(TextUtils.isEmpty(etPrice.text.toString().trim())){
                                        //ntar deh, ad errornya nih
                                        layoutPrice.setError("Please Enter Price")
                                        return@setOnClickListener
                                    }
                                    if(!TextUtils.isEmpty(etPrice.text.toString().trim()))
                                        layoutPrice.setError(null)
                                    val productPrice = product.price.toDouble()
                                    val negoPrice = productPrice - (0.2 * productPrice)
                                    if(negoCount <= 1){
                                        Handler().postDelayed(object : Runnable {
                                            override fun run() {
                                                btnNegotiation.setBackgroundColor(Color.RED)
                                                btnNegotiation.isClickable = false
                                            }
                                        }, 2000)
                                    }
                                    if(etPrice.text.toString().toUInt().toInt() < negoPrice){
                                        showProgressDialog()
                                        val dialogNegoFailed : android.app.AlertDialog
                                        val negoFailedInflater = this.layoutInflater
                                        val dialogNegoFailedView = negoFailedInflater.inflate(R.layout.custom_dialog_nego_fail, null)
                                        val builder = android.app.AlertDialog.Builder(this)
                                            .setView(dialogNegoFailedView)
                                        val tvNegoFailed = dialogNegoFailedView.findViewById<TextView>(R.id.tvNegoFailed)
                                        tvNegoFailed.setText("Negotiation remaining ${negoCount-1} times")
                                        if(negoCount <= 1){
                                            tvNegoFailed.setText("Your negotiation chances has run out")
                                        }
                                        negoCount -= 1
                                        dialogNegoFailed = builder.create()
                                        Handler().postDelayed(object : Runnable {
                                            override fun run() {
                                                tvNegoDesc.setText("You have ${negoCount} chances to negotiate")
                                                dialogNegoFailed.show()
                                            }
                                        }, 2000)
                                    }
                                    else{
                                        showProgressDialog()
                                        negoCount = -1
                                        val dialogNegoSuccess : android.app.AlertDialog
                                        val negoSuccessInflater = this.layoutInflater
                                        val dialogNegoSuccessView = negoSuccessInflater.inflate(R.layout.custom_dialog_nego_success, null)
                                        val builder = android.app.AlertDialog.Builder(this)
                                            .setView(dialogNegoSuccessView)
                                        val btnAddToCart = dialogNegoSuccessView.findViewById<Button>(R.id.btnAddToCart)
                                        dialogNegoSuccess = builder.create()
                                        Handler().postDelayed(object : Runnable {
                                            override fun run() {
                                                dialogNegoSuccess.show()
                                                btnNegotiation.setBackgroundColor(Color.GREEN)
                                                btnNegotiation.isClickable = false
                                            }
                                        }, 2000)
                                        btnAddToCart.setOnClickListener {
                                            Toast.makeText(this,"Item added to cart!", Toast.LENGTH_LONG).show()
                                            dialogNegoSuccess.dismiss()
                                        }
                                    }
                                }
                                dialogNego.dismiss()
                            }

                            btnCancel.setOnClickListener {
                                dialogNego.dismiss()
                            }
                        }
                    }
                } else if (Math.abs(valueY) > MIN_DISTANCE) {
                    if (y2 > y1) {
//                        Toast.makeText(this, "Bottom swipe", Toast.LENGTH_SHORT).show()
                    } else if (y2 < y1) {
//                        Toast.makeText(this, "Up swipe", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
        return mDetector.onTouchEvent(event)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(EXTRA_NEGO_COUNT, negoCount)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        negoCount = savedInstanceState?.getInt(EXTRA_NEGO_COUNT)
    }
}