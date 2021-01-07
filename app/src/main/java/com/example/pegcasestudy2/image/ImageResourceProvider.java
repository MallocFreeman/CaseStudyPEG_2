package com.example.pegcasestudy2.image;

import com.example.pegcasestudy2.R;
import com.example.pegcasestudy2.profile.dao.Gender;

public class ImageResourceProvider {

  /**
   * Depending on the gender the corresponding resource ID will be returned.
   *
   * @param gender the {@link Gender} to be used.
   * @return the corresponding resource ID.
   */
  public static int provide(Gender gender) {
    int resourceID = R.drawable.dummy;

    if (Gender.MALE.equals(gender)) {
      resourceID = R.drawable.male_avatar;
    }

    if (Gender.FEMALE.equals(gender)) {
      resourceID = R.drawable.female_avatar;
    }
    return resourceID;
  }
}
