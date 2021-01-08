package com.example.pegcasestudy2.profile.repository

import com.example.pegcasestudy2.profile.dao.Profile

/**
 * Interface for a datastore that provides [Profile] objects.
 */
interface ProfileRepository {
    /**
     * Retrieves a list with [Profile] elements.
     *
     * @return a list of available profiles.
     */
    val profiles: List<Profile?>?
}
