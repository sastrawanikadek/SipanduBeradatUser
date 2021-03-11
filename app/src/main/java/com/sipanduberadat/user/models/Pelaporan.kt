package com.sipanduberadat.user.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Pelaporan(val id: Long, val krama: Krama, val desaAdat: DesaAdat,
                     val jenisPelaporan: JenisPelaporan, val time: Date, val latitude: Double,
                     val longitude: Double, val status: String, val title: String?,
                     val photo: String?, val description: String?): Parcelable