package com.example.pegcasestudy2.image;

import com.example.pegcasestudy2.R;
import com.example.pegcasestudy2.profile.dao.Gender;
import org.junit.Assert;
import org.junit.Test;

public class ImageResourceProviderTest {

  @Test()
  public void nullPassed_Valid_DummyReturned() {
    Assert.assertEquals(R.drawable.dummy, ImageResourceProvider.provide(null));
  }

  @Test()
  public void diversPassed_Valid_DummyReturned() {
    Assert.assertEquals(R.drawable.dummy, ImageResourceProvider.provide(Gender.DIVERSE));
  }

  @Test()
  public void malePassed_Valid_MaleAvatarReturned() {
    Assert.assertEquals(R.drawable.male_avatar, ImageResourceProvider.provide(Gender.MALE));
  }

  @Test()
  public void femalePassed_Valid_FemaleAvatarReturned() {
    Assert
        .assertEquals(R.drawable.female_avatar, ImageResourceProvider.provide(Gender.FEMALE));
  }
}