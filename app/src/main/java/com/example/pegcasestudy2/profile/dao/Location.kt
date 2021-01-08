package com.example.pegcasestudy2.profile.dao

data class Location(val city: String, val zip: String) {

    override fun toString(): String {
        return "$zip, $city"
    }
}
