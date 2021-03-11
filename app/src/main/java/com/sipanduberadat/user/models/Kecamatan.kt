package com.sipanduberadat.user.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kecamatan(val id: Long, val kabupaten: Kabupaten, val name: String,
                     val activeStatus: Boolean): Parcelable {
    override fun toString(): String {
        return name
    }
}