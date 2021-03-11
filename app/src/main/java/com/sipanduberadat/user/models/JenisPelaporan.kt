package com.sipanduberadat.user.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class JenisPelaporan(val id: Long, val name: String, val icon: String,
                          val isEmergency: Boolean): Parcelable