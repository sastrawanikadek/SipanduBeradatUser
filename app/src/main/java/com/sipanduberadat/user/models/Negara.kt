package com.sipanduberadat.user.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Negara(val id: Long, val name: String, val activeStatus: Boolean): Parcelable