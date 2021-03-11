package com.sipanduberadat.user.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kabupaten(val id: Long, val provinsi: Provinsi, val name: String,
                     val activeStatus: Boolean): Parcelable {
    override fun toString(): String {
        return name
    }
}