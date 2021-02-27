package com.sipanduberadat.user.models

data class Banjar(val id: Long, val desaAdat: DesaAdat, val name: String, val activeStatus: Boolean) {
    override fun toString(): String {
        return name
    }
}