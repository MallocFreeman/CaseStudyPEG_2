package com.example.pegcasestudy2.profile.repository

import android.content.res.Resources
import com.example.pegcasestudy2.profile.dao.Profile
import com.example.pegcasestudy2.profile.dao.Profiles
import java.util.*
import java.util.stream.Collectors

/**
 * The {@link ProfileJsonRepository} provides access to {@link Profile} information that are stored
 * in a json file.
 */
class ProfileJsonRepository(private val resources: Resources, private val resource: Int) : ProfileRepository {
    override val profiles: List<Profile?>?
        get() = Arrays.stream(ProfileJsonReader.read(resources, resource)
                .map(Profiles::profiles)
                .orElse(arrayOf()))
                .collect(Collectors.toList())
}
