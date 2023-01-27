package com.example.tkppl_uas

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tkppl_uas.classes.ClassEditProfile
import kotlinx.android.synthetic.main.fragment_account.*
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AccountFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccountFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Thread(Runnable {
            val bitmap = processBitmap("https://i.mydramalist.com/jlqObf.jpg")
            ivProfile.post {
                println("Menambahkan gambar");
                ivProfile.setImageBitmap(bitmap)
            }
        }).start()


        btnEditProfile.setOnClickListener {
            val intent = Intent (this.requireContext(), EditProfileActivity::class.java)
            startActivityForResult(intent, EXTRA_REQUEST_EDITPROFILE_CODE)
        }

        btnAddressList.setOnClickListener {
            val intent = Intent(this.requireContext(), AddressListActivity::class.java)
            startActivity(intent)
        }

        btnSettings.setOnClickListener {
            val intent = Intent(this.requireContext(), SettingsActivity::class.java)
            startActivity(intent)
        }

        btnLogout.setOnClickListener {
            val isDialog : android.app.AlertDialog
            val inflater = this.layoutInflater
            val dialogView = inflater.inflate(R.layout.custom_dialog_signout, null)
            val builder = android.app.AlertDialog.Builder(activity)
                .setView(dialogView)
            val btnYes = dialogView.findViewById<Button>(R.id.txt_yes)
            val btnNo = dialogView.findViewById<Button>(R.id.txt_no)
            isDialog = builder.create()
            isDialog.show()
            btnYes.setOnClickListener {
                isDialog.dismiss()
                Toast.makeText(activity, "You have been signed out", Toast.LENGTH_SHORT)
                val intent = Intent(this.requireContext(), WelcomeScreenActivity::class.java)
                startActivity(intent)
            }
            btnNo.setOnClickListener {
                isDialog.dismiss()
            }
        }
    }

    private fun processBitmap(strUrl: String): Bitmap? {
        return try {
            var url = URL("https://i.mydramalist.com/jlqObf.jpg")
            val connection: HttpURLConnection = url.openConnection() as HttpURLConnection
            connection.doInput = true
            connection.connect()
            val input: InputStream = connection.inputStream
            val myBitmap = BitmapFactory.decodeStream(input)
            //proses bitmap yang lama
            myBitmap
        } catch (e: IOException){
            e.printStackTrace()
            null
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        Toast.makeText(this.requireContext(), "${requestCode} ${resultCode}", Toast.LENGTH_SHORT).show()
        if(EXTRA_REQUEST_EDITPROFILE_CODE == requestCode){
            if(EXTRA_RESULT_EDITPROFILE_CODE == resultCode){
                var intentEditProfil = data?.getParcelableExtra<ClassEditProfile>(EXTRA_EDIT_PROFILE)
                name.text = intentEditProfil?.Username
                nameGmail.text = intentEditProfil?.Email
            }
            else if(EXTRA_CANCEL_EDITPROFILE_CODE == resultCode){
                Toast.makeText(activity, "Batal", Toast.LENGTH_SHORT)
            }
        }
    }
}