package com.sipanduberadat.user.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Provinsi(val id: Long, val negara: Negara, val name: String,
                    val activeStatus: Boolean): Parcelable