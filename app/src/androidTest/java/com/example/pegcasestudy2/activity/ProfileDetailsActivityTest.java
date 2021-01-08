//package com.example.pegcasestudy2.activity;
//
//import static androidx.test.espresso.Espresso.onView;
//import static androidx.test.espresso.assertion.ViewAssertions.matches;
//import static androidx.test.espresso.matcher.ViewMatchers.withId;
//
//import android.content.Intent;
//import android.view.View;
//import android.widget.ImageView;
//import androidx.fragment.app.testing.FragmentScenario;
//import androidx.test.core.app.ApplicationProvider;
//import androidx.test.espresso.matcher.ViewMatchers;
//import androidx.test.ext.junit.rules.ActivityScenarioRule;
//import androidx.test.ext.junit.runners.AndroidJUnit4;
//import com.example.pegcasestudy2.R;
//import com.example.pegcasestudy2.activity.parcel.ProfileParcel;
//import com.example.pegcasestudy2.fragment.FragmentProfileOverview;
//import com.example.pegcasestudy2.profile.dao.Gender;
//import com.example.pegcasestudy2.profile.dao.Location;
//import com.example.pegcasestudy2.profile.dao.Profile;
//import org.hamcrest.Description;
//import org.hamcrest.Matcher;
//import org.hamcrest.TypeSafeMatcher;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//@RunWith(AndroidJUnit4.class)
//public class ProfileDetailsActivityTest {
//
//  @Rule
//  public ActivityScenarioRule<CaseStudyActivity> activityScenarioRule = new ActivityScenarioRule<>(CaseStudyActivity.class);
//
//  @Test
//  public void activityStartedWithIntent_ViewsFilled_CorrectValuesShown() {
//    Profile testProfile = createTestProfile();
//    validateImageView(R.drawable.male_avatar);
//    validateTextViews(R.id.detailProfileLocation, testProfile.getLocation().toString());
//    validateTextViews(R.id.detailProfileDescription, testProfile.getDescription());
//    validateTextViews(R.id.detailProfileDescription, testProfile.getDescription());
//  }
//
//  private void validateImageView(final int resourceID) {
//    onView(withId(R.id.detailProfileImage)).check(matches(withResource(resourceID)));
//  }
//
//  private void validateTextViews(final int id, String expected) {
//    onView(withId(id)).check(matches(ViewMatchers.withText(expected)));
//  }
//
//  private static Profile createTestProfile() {
//    return new Profile("Thomas", 27, Gender.MALE, new Location("Fahrenkrug", "23795"),
//        "Testy test");
//  }
//
//  /**
//   * Needed because a resource check can only be done with comparing the drawables byte for byte. To
//   * avoid this the same resource ID is used as tag.
//   *
//   * @param expectedResourceID expected resource id of the used drawable
//   * @return true if the given was used
//   */
//  public static Matcher<View> withResource(final int expectedResourceID) {
//    return new TypeSafeMatcher<View>() {
//
//      @Override
//      protected boolean matchesSafely(View view) {
//        if (expectedResourceID > 0 && view instanceof ImageView) {
//          ImageView imageView = (ImageView) view;
//          return imageView.getTag().equals(expectedResourceID);
//        }
//        return false;
//      }
//
//      @Override
//      public void describeTo(Description description) {
//        description.appendText("with drawable from resource id: ")
//            .appendText(String.valueOf(expectedResourceID));
//      }
//    };
//  }
//}