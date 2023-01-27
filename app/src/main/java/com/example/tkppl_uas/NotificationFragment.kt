package com.example.tkppl_uas

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tkppl_uas.classes.ClassNotification
import com.example.tkppl_uas.classes.ClassNotificationAdapter
import com.example.tkppl_uas.classes.ClassNotificationClickListener
import com.example.tkppl_uas.classes.notifList
import kotlinx.android.synthetic.main.fragment_notification.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NotificationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotificationFragment : Fragment(), ClassNotificationClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var  recyclerView: RecyclerView
    lateinit var notificationAdapter: ClassNotificationAdapter

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
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NotificationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotificationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addNotificationRecycleView()
        recyclerView.layoutManager = object : LinearLayoutManager(activity){
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recyclerView.adapter = notificationAdapter
    }

    private fun addNotificationRecycleView() {
        recyclerView = rvAddress
        notifList.add(
            ClassNotification(R.drawable.img_store, "Your Order#: 000003 from our store\n" +
                    "has been processed", "30 minutes ago")
        )
        notifList.add(
            ClassNotification(R.drawable.img_store, "Your Order#: 000002 from our store\n" +
                    "has been processed", "yesterday")
        )
        notifList.add(
            ClassNotification(R.drawable.img_store, "Your Order#: 000001 from our store\n" +
                    "has been processed", "5 days ago")
        )
        notifList.add(
            ClassNotification(R.drawable.img_store, "Your Order#: 000000 from our store\n" +
                    "has been processed", "1 week ago")
        )

        val notifFragment = this
        notificationAdapter = ClassNotificationAdapter(notifList, notifFragment)


    }

    override fun onClick(notification: ClassNotification) {
        val intent = Intent(this.requireContext(), NotificationDetailActivity::class.java)
//        intent.putExtra(NOTIF_ID_EXTRA, notification.id)
        startActivity(intent)
    }
}