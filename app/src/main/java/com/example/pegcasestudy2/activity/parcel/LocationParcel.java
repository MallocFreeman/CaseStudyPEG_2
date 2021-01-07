package com.example.pegcasestudy2.activity.parcel;

import android.os.Parcel;
import android.os.Parcelable;
import com.example.pegcasestudy2.profile.dao.Location;

public class LocationParcel implements Parcelable {

  private Location location;

  public LocationParcel(Location location) {
    this.location = location;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(location.getCity());
    dest.writeString(location.getZip());
  }

  public Location getLocation() {
    return location;
  }

  public static final Creator<LocationParcel> CREATOR = new Creator<LocationParcel>() {
    @Override
    public LocationParcel createFromParcel(Parcel in) {
      return new LocationParcel(new Location(in.readString(), in.readString()));
    }

    @Override
    public LocationParcel[] newArray(int size) {
      return new LocationParcel[size];
    }
  };
}
