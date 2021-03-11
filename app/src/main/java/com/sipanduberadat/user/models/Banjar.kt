package com.sipanduberadat.user.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Banjar(val id: Long, val desaAdat: DesaAdat, val name: String,
                  val activeStatus: Boolean): Parcelable {
    override fun toString(): String {
        return name
    }
}