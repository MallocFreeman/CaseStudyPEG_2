package com.example.pegcasestudy2.profile.dao;

public class Location {

  private String city;
  private String zip;

  public Location(String city, String zip) {
    this.city = city;
    this.zip = zip;
  }

  public String getCity() {
    return city;
  }

  public String getZip() {
    return zip;
  }

  @Override
  public String toString() {
    return zip + ", " + city;
  }
}
