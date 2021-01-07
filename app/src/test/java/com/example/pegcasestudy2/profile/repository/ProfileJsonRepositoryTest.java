package com.example.pegcasestudy2.profile.repository;

import android.content.res.Resources;
import com.example.pegcasestudy2.profile.dao.Gender;
import com.example.pegcasestudy2.profile.dao.Location;
import com.example.pegcasestudy2.profile.dao.Profile;
import com.example.pegcasestudy2.profile.dao.Profiles;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ProfileJsonRepositoryTest {

  @Mock
  private Resources resourcesMock;

  @Rule
  public TemporaryFolder folder = new TemporaryFolder();

  @Test
  public void emptyFile_CorrectParsed_ResultIsEmpty() throws IOException {
    Assert.assertTrue(executeTestMethod(prepareJsonFile("")).isEmpty());
  }

  @Test
  public void emptyJsonObject_CorrectParsed_ResultIsEmpty() throws IOException {
    Assert.assertTrue(executeTestMethod(prepareJsonFile(createProfiles())).isEmpty());
  }

  @Test
  public void filledJsonObject_CorrectParsed_ResultIsEmpty() throws IOException {
    Profile profile = createTestProfile();
    List<Profile> profileList = executeTestMethod(prepareJsonFile(createProfiles(profile)));

    Assert.assertEquals(1, profileList.size());
    validateProfile(profile, profileList.get(0));
  }

  private List<Profile> executeTestMethod(String jsonFile) throws FileNotFoundException {
    addResourceExpectation(jsonFile);
    List<Profile> profileList = new ProfileJsonRepository(resourcesMock, 0).getProfiles();
    addMockValidation();
    return profileList;
  }

  private String prepareJsonFile(String jsonContent) throws IOException {
    File file = folder.newFile("test.json");

    try (FileWriter fileWriter = new FileWriter(file)) {
      fileWriter.write(jsonContent);
    }
    return file.getPath();
  }

  private void validateProfile(Profile base, Profile toBeValidated) {
    Assert.assertEquals(base.getName(), toBeValidated.getName());
    Assert.assertEquals(base.getAge(), toBeValidated.getAge());
    Assert.assertEquals(base.getGender(), toBeValidated.getGender());
    Assert.assertEquals(base.getDescription(), toBeValidated.getDescription());
    Assert.assertEquals(base.getLocation().getCity(), toBeValidated.getLocation().getCity());
    Assert.assertEquals(base.getLocation().getZip(), toBeValidated.getLocation().getZip());
  }

  private String createProfiles(Profile... profiles) {
    return new Gson().toJson(new Profiles(profiles));
  }

  private Profile createTestProfile() {
    return new Profile("Thomas", 27, Gender.MALE, new Location("Fahrenkrug", "23795"),
        "Still the same");
  }

  private void addResourceExpectation(String pathToJsonFile) throws FileNotFoundException {
    Mockito.when(resourcesMock.openRawResource(Mockito.anyInt()))
        .thenReturn(new FileInputStream(pathToJsonFile));
  }

  private void addMockValidation() {
    Mockito.verify(resourcesMock).openRawResource(Mockito.anyInt());
  }
}