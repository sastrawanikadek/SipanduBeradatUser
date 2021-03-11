package com.sipanduberadat.user.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Krama(val id: Long, val banjar: Banjar, val name: String, val avatar: String,
                 val phone: String, val dateOfBirth: Date, val NIK: String, val gender: String,
                 val category: String, val validStatus: Boolean, val activeStatus: Boolean): Parcelable