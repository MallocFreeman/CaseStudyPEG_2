package com.example.pegcasestudy2.profile.dao;

/**
 * Data class for a profile.
 */
public class Profile {

  private String name;
  private final int age;
  private final Gender gender;
  private final Location location;
  private String description;

  public Profile(String name, int age, Gender gender, Location location, String description) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.location = location;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Gender getGender() {
    return gender;
  }

  public Location getLocation() {
    return location;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return name + (age != 0 ? ", " + age : "");
  }
}
