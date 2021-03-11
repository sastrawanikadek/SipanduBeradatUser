package com.sipanduberadat.user.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DesaAdat(val id: Long, val kecamatan: Kecamatan, val name: String, val latitude: Double,
                    val longitude: Double, val activeStatus: Boolean): Parcelable {
    override fun toString(): String {
        return name
    }
}