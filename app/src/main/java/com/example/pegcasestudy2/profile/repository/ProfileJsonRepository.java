package com.example.pegcasestudy2.profile.repository;

import android.content.res.Resources;
import com.example.pegcasestudy2.profile.dao.Profile;
import com.example.pegcasestudy2.profile.dao.Profiles;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@link ProfileJsonRepository} provides access to {@link Profile} information that are stored
 * in a json file.
 */
public class ProfileJsonRepository implements ProfileRepository {

  private final Resources resources;
  private final int resource;

  public ProfileJsonRepository(final Resources resources, final int resource) {
    this.resources = resources;
    this.resource = resource;
  }

  @Override
  public List<Profile> getProfiles() {
    return Arrays.stream(ProfileJsonReader.read(resources, resource)
        .map(Profiles::getProfiles)
        .orElse(new Profile[0]))
        .collect(Collectors.toList());
  }
}
