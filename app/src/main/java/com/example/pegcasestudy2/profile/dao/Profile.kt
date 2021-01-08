package com.example.pegcasestudy2.profile.dao

/**
 * Data class for a profile.
 */
data class Profile(val name: String, val age: Int, val gender: Gender, val location: Location, val description: String) {

    override fun toString(): String {
        return name + if (age != 0) ", $age" else ""
    }
}