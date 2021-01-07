package com.example.pegcasestudy2.profile.repository;

import android.content.res.Resources;
import com.example.pegcasestudy2.profile.dao.Profile;
import com.example.pegcasestudy2.profile.dao.Profiles;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.InputStreamReader;
import java.util.Optional;

class ProfileJsonReader {

  /**
   * Reads the content of the given json file represented by the passed uri.
   *
   * @param id the resource id of the desired json file.
   * @return A list filled with {@link Profile} objects with the corresponding values from given
   * file. In case of an error an empty list will be returned.
   */
  static Optional<Profiles> read(final Resources resources, final int id) {
    return Optional
        .ofNullable(new Gson().fromJson(createJsonReader(resources, id), Profiles.class));
  }

  private static JsonReader createJsonReader(final Resources resources, final int id) {
    return new JsonReader(new InputStreamReader(resources.openRawResource(id)));
  }
}
