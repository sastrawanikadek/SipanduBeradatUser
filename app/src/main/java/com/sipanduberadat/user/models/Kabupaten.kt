package com.sipanduberadat.user.models

data class Kabupaten(val id: Long, val name: String, val activeStatus: Boolean) {
    override fun toString(): String {
        return name
    }
}