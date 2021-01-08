package com.example.pegcasestudy2.parcel;

import android.os.Parcel;
import android.os.Parcelable;
import com.example.pegcasestudy2.profile.dao.Gender;

public class GenderParcel implements Parcelable {

  private Gender gender;

  public GenderParcel(Gender gender) {
    this.gender = gender;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(gender.name());
  }

  public Gender getGender() {
    return gender;
  }

  public static final Creator<GenderParcel> CREATOR = new Creator<GenderParcel>() {
    @Override
    public GenderParcel createFromParcel(Parcel in) {
      return new GenderParcel(Gender.valueOf(in.readString()));
    }

    @Override
    public GenderParcel[] newArray(int size) {
      return new GenderParcel[size];
    }
  };
}