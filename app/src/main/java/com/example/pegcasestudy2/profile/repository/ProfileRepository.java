package com.example.pegcasestudy2.profile.repository;

import com.example.pegcasestudy2.profile.dao.Profile;
import java.util.List;

/**
 * Interface for a datastore that provides {@link Profile} objects.
 */
public interface ProfileRepository {

  /**
   * Retrieves a list with {@link Profile} elements.
   *
   * @return a list of available profiles.
   */
  List<Profile> getProfiles();
}
