package com.sipanduberadat.user.models

data class Kecamatan(val id: Long, val kabupaten: Kabupaten, val name: String,
                     val activeStatus: Boolean) {
    override fun toString(): String {
        return name
    }
}