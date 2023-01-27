package com.example.tkppl_uas.classes

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ClassEditProfile (
    var Username : String = "",
    var Email : String = "",
    var Password : String = "",
    var PhoneNumber : String = ""
) : Parcelable {

}