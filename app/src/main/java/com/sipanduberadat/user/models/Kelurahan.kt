package com.sipanduberadat.user.models

data class Kelurahan(val id: Long, val kecamatan: Kecamatan, val name: String,
                     val activeStatus: Boolean) {
    override fun toString(): String {
        return name
    }
}