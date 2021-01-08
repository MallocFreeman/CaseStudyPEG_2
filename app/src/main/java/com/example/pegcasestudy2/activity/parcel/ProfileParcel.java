package com.example.pegcasestudy2.activity.parcel;

import android.os.Parcel;
import android.os.Parcelable;
import com.example.pegcasestudy2.profile.dao.Gender;
import com.example.pegcasestudy2.profile.dao.Location;
import com.example.pegcasestudy2.profile.dao.Profile;

/**
 * Wrapper to provide a {@link Parcelable} that contains a {@link Profile}
 */
public class ProfileParcel implements Parcelable {

  public static final String PARCELABLE_NAME = "ProfileParcelable";
  private final Profile profile;

  public ProfileParcel(final Profile profile) {
    this.profile = profile;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(profile.getAge());
    dest.writeString(profile.getName());
    dest.writeString(profile.getDescription());
    dest.writeParcelable(new GenderParcel(profile.getGender()), PARCELABLE_WRITE_RETURN_VALUE);
    dest.writeParcelable(new LocationParcel(profile.getLocation()), PARCELABLE_WRITE_RETURN_VALUE);
  }

  public Profile getProfile() {
    return profile;
  }

  public static final Creator<ProfileParcel> CREATOR = new Creator<ProfileParcel>() {
    @Override
    public ProfileParcel createFromParcel(Parcel in) {
      int age = in.readInt();
      String name = in.readString();
      String description = in.readString();
      Gender gender = in.<GenderParcel>readParcelable(GenderParcel.class.getClassLoader())
          .getGender();
      Location location = in.<LocationParcel>readParcelable(LocationParcel.class.getClassLoader())
          .getLocation();
      return new ProfileParcel(new Profile(name, age, gender, location, description));
    }

    @Override
    public ProfileParcel[] newArray(int size) {
      return new ProfileParcel[size];
    }
  };
}