package com.sipanduberadat.user.models

import java.util.*

data class Krama(val id: Long, val banjar: Banjar, val name: String, val avatar: String,
                 val phone: String, val dateOfBirth: Date, val NIK: String, val gender: String,
                 val category: String, val validStatus: Boolean, val activeStatus: Boolean)