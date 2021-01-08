package com.example.pegcasestudy2.parcel;

import android.os.Parcel;
import android.os.Parcelable;
import com.example.pegcasestudy2.profile.dao.Profile;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProfileListParcel implements Parcelable {

  public static final String PARCELABLE_LIST_NAME = "ProfileParcelableList";
  private final List<Profile> profileList;

  public ProfileListParcel(final List<Profile> profileList) {
    this.profileList = profileList;
  }

  public List<Profile> getProfileList() {
    return profileList;
  }

  @Override
  public int describeContents() {
    return profileList.size();
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeParcelableArray(
        (ProfileParcel[]) profileList.stream().map(ProfileParcel::new).toArray(),
        PARCELABLE_WRITE_RETURN_VALUE);
  }

  public static final Creator<ProfileListParcel> CREATOR = new Creator<ProfileListParcel>() {
    @Override
    public ProfileListParcel createFromParcel(Parcel in) {
      return new ProfileListParcel(Arrays
          .stream((ProfileParcel[]) in.readParcelableArray(ProfileParcel.class.getClassLoader()))
          .map(ProfileParcel::getProfile).collect(Collectors.toList()));
    }

    @Override
    public ProfileListParcel[] newArray(int size) {
      return new ProfileListParcel[size];
    }
  };
}
