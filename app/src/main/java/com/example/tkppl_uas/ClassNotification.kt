package com.example.tkppl_uas.classes

var notifList = ArrayList<ClassNotification>()
val NOTIF_ID_EXTRA = "notifExtra"

class ClassNotification (
    val image: Int,
    val info: String,
    val time: String,
    val id: Int? = notifList.size){
}