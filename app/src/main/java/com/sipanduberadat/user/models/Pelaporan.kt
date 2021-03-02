package com.sipanduberadat.user.models

import java.util.*

data class Pelaporan(val id: Long, val krama: Krama, val desaAdat: DesaAdat,
                     val jenisPelaporan: JenisPelaporan, val time: Date, val latitude: Double,
                     val longitude: Double, val status: String)