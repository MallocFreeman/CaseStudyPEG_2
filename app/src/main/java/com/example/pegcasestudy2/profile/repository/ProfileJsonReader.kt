package com.example.pegcasestudy2.profile.repository

import android.content.res.Resources
import com.example.pegcasestudy2.profile.dao.Profiles
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import java.io.InputStreamReader
import java.util.*

/**
 * Utility class to wrap the usage of [Gson]
 */
internal object ProfileJsonReader {
    /**
     * Reads the content of the given json file represented by the passed uri.
     *
     * @param id the resource id of the desired json file.
     * @return A list filled with [Profile] objects with the corresponding values from given
     * file. In case of an error an empty list will be returned.
     */
    fun read(resources: Resources, id: Int): Optional<Profiles> {
        return Optional
                .ofNullable(Gson().fromJson<Profiles>(createJsonReader(resources, id), Profiles::class.java))
    }

    private fun createJsonReader(resources: Resources, id: Int): JsonReader {
        return JsonReader(InputStreamReader(resources.openRawResource(id)))
    }
}
