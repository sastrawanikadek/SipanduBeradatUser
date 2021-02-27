package com.sipanduberadat.user.models

data class DesaAdat(val id: Long, val kecamatan: Kecamatan, val name: String, val latitude: Double,
                    val longitude: Double, val activeStatus: Boolean) {
    override fun toString(): String {
        return name
    }
}